package com.example.provider9002.service;

import com.example.provider9002.dao.DeptDao;
import com.example.provider9002.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Department department) {
        return deptDao.addDept(department);
    }

    @Override
    public Department queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Department> queryAll() {
        return deptDao.queryAll();
    }
}
