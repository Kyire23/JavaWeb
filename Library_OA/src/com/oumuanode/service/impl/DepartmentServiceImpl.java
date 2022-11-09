package com.oumuanode.service.impl;


import com.oumuanode.dao.DepartmentDao;
import com.oumuanode.dao.impl.DepartmentDaoImpl;
import com.oumuanode.domain.Department;
import com.oumuanode.service.DepartmentService;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao deaprtmentDao = (DepartmentDao) new DepartmentDaoImpl();

    @Override
    public List<Department> findAll() {
        List<Department> departments = deaprtmentDao.findAll();
        return departments;
    }

    @Override
    public void deleteDepartmentById(int did) {
        deaprtmentDao.deleteDepartmentById(did);
    }

    @Override
    public void addDepartment(String department) {
        deaprtmentDao.addDeaprtment(department);
    }
}
