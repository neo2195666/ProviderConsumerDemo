package com.example.provider9001.dao;

import com.example.provider9001.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Department department);

    public Department queryById(Long id);

    public List<Department> queryAll();
}
