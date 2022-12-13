package com.example.provider9001.service;

import com.example.provider9001.pojo.Department;

import java.util.List;

public interface DeptService {

    public boolean addDept(Department department);

    public Department queryById(Long id);

    public List<Department> queryAll();
}
