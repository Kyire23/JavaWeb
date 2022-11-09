package com.oumuanode.dao.impl;


import com.oumuanode.dao.AdminDao;
import com.oumuanode.domain.Admin;
import com.oumuanode.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {
    //对 JDBC 开发过程中的驱动加载、连接的开启和关闭、SQL 语句的创建与执行、异常处理、事务处理、数据类型转换等操作的封装。
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名和密码查询的方法
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        try {
            //1.定义sql
            String sql = "SELECT * FROM admin_info WHERE username = ? AND password = ?";
            //2.执行sql将数据库查询结果转换为Java类对象。 常应用于使用Spring的JdbcTemplate查询数据库，获取List结果列表，数据库表字段和实体类自动对应。
            Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), username, password);
            return admin;
        } catch (Exception e) {
            return null;
        }
    }
}

