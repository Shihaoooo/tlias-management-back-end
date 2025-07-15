package com.itheima.pojo.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpJobDataStatistics {
    private List<Object> jobList;
    private List<Object> amountList;
}
