package com.example.provider9001.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //开启链式编程
public class Department implements Serializable {
    private long departmentno;
    private String departmentname;
    private String db_source;

    public Department(String departmentName) {
        this.departmentname = departmentname;
    }
}
