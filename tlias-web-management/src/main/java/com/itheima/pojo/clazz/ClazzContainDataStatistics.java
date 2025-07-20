package com.itheima.pojo.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
public class ClazzContainDataStatistics {
    private List<Object> clazzList;
    private List<Object> dataList;
}
