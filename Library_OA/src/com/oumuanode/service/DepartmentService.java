package com.oumuanode.service;


import com.oumuanode.domain.Department;

import java.util.List;


public interface DepartmentService {
    /**
     * 查询所有院系
     * @return
     */
    List<Department> findAll();

    void deleteDepartmentById (int did);

    void addDepartment(String department);
}
