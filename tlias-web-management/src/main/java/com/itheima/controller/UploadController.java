package com.itheima.controller;

import com.itheima.pojo.result.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Slf4j
@RequestMapping("/upload")
@Controller
public class UploadController {
    @Autowired
    AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("")
    public Result upload(MultipartFile file) throws Exception {
        // 获取原始名称
        String originalName = file.getOriginalFilename();

        // 创建输入流对象
        InputStream inputStream = file.getInputStream();

        // 开始上传
        String httpsLocation = aliyunOSSOperator.upload(originalName,inputStream);

        return Result.success(httpsLocation);

    }
}
