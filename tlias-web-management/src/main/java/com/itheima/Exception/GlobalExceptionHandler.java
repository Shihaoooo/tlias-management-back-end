package com.itheima.Exception;

import com.itheima.pojo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 重复值异常处理器
    @ExceptionHandler(value = DuplicateKeyException.class)
    public Result duplicateKeyException(DuplicateKeyException duplicateKeyException) {

        // 打印错误信息
        String message = duplicateKeyException.getMessage();

        message = "重复的值：" + message.substring(message.indexOf("Duplicate entry")).split(" ")[2] + "请重试！";

        log.error(duplicateKeyException.getMessage(), duplicateKeyException);

        return Result.error(message);
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        log.error(e.getMessage(), e);

        return Result.error("服务端出错啦" + e.getMessage());
    }
}
