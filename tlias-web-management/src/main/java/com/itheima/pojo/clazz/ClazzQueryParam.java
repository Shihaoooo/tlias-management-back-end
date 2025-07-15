package com.itheima.pojo.clazz;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private String name; //班级名称

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate begin;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate end;
    private Integer currentPage;
    private Integer pageSize;
}
