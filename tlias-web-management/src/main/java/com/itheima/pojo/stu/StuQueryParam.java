package com.itheima.pojo.stu;

import lombok.Data;

@Data
public class StuQueryParam {
    private String name;
    private Integer degree; // 学历（1.初中 2.高中 3.大专 4.本科 5.硕士 6.博士
    private Integer clazzId;
    private Integer currentPage;
    private Integer pageSize;
}
