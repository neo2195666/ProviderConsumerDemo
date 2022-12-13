package com.example.provider9002.service;

import com.example.provider9002.pojo.Department;

import java.util.List;

public interface DeptService {

    public boolean addDept(Department department);

    public Department queryById(Long id);

    public List<Department> queryAll();
}
