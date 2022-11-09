package com.oumuanode.service.impl;


import com.oumuanode.dao.StudentDao;
import com.oumuanode.dao.impl.StudentDaoImpl;
import com.oumuanode.domain.User;
import com.oumuanode.service.UserService;
//import com.oumuanode.utils.MailUtils;
//import com.oumuanode.utils.UuidUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean register(User user) {
        //根据用户名查询用户对象
        User u = studentDao.findByUsername(user.getUsername());
        //判断u是否为null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }

//        //设置激活码，唯一字符串
//        user.setCode(UuidUtil.getUuid());
//        //设置激活状态
//        user.setStatus("N");
//        //保存用户信息
//        studentDao.save(user);
//
//        //激活邮件发送，邮件正文？
//        String content = "<a href='http://localhost:6060/user/active?code=" + user.getCode() + "'>点击激活您的账号</a>";
////        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
//
        return true;

    }

    /**
     * 激活用户
     *
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = studentDao.findByCode(code);
        if (user != null) {
            //2.调用dao的修改激活状态的方法
            studentDao.updateStatus(user);
            return true;
        } else {
            return false;
        }

    }


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return studentDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return studentDao.findAll();
    }

    /**
     * 删除用户方法
     *
     * @param uid
     */
    @Override
    public void deleteUser(int uid) {
        studentDao.deleteById(uid);
    }

    /**
     * 删除选中用户方法
     * @param uids
     */
    @Override
    public void deleteSelectedUser(String[] uids) {
        for (String id : uids) {
            studentDao.deleteById(Integer.parseInt(id));
        }
    }

    /**
     * 根据id查询用户
     *
     * @param uid
     * @return
     */
    @Override
    public User findUserById(int uid) {
        return studentDao.findById(uid);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        studentDao.update(user);
        return true;
    }
}

