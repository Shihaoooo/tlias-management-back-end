package com.itheima.pojo.emp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
// 员工查询参数类（当查询参数过多时，可以通过设置一个实体类去接受参数，以简化参数的接受过程）
public class EmpQueryParam {
    private Integer currentPage; // 当前页码
    private Integer pageSize; // 每页显示条数
    private String name; // 员工姓名
    private Integer gender; // 性别

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; // 入职日期
}
