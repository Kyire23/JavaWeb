package com.oumuanode.service.impl;

import com.oumuanode.dao.AdminDao;
import com.oumuanode.dao.impl.AdminDaoImpl;
import com.oumuanode.domain.Admin;
import com.oumuanode.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        return adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }
}
