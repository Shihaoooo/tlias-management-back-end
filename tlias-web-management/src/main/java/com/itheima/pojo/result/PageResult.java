package com.itheima.pojo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T>{
    private List<T> rows;  // 行数据
    private Long total;  // 总记录数
}



