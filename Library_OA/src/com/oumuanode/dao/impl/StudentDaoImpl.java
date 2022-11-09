package com.oumuanode.dao.impl;



import com.oumuanode.dao.StudentDao;
import com.oumuanode.domain.User;
import com.oumuanode.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        try {
            //1.定义sql
            String sql = "SELECT * FROM student_info WHERE username = ?";
            //2.执行sql
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户保存
     *
     * @param user
     */
    @Override
    public void save(User user) {
        String sql = "INSERT INTO student_info(username,password,name,email,telephone,gender,birthday,status,code) VALUES (?,?,?,?,?,?,?,?,?)";
        template.update(sql, user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getTelephone(),
                user.getGender(),
                user.getBirthday(),
                user.getStatus(),
                user.getCode());
    }

    /**
     * 根据激活码查询用户对象
     *
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        try {
            String sql = "SELECT * FROM student_info WHERE code = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

    /**
     * 修改指定用户激活状态
     *
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql = "UPDATE student_info SET STATUS = 'Y' WHERE uid=?";
        template.update(sql, user.getUid());
    }

    /**
     * 根据用户名和密码查询的方法
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try {
            //1.定义sql
            String sql = "SELECT * FROM student_info WHERE username = ? AND password = ?";
            //2.执行sql
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM student_info";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    /**
     * 删除用户
     *
     * @param uid
     */
    @Override
    public void deleteById(int uid) {
        String sql = "DELETE FROM student_info WHERE uid = ?";
        template.update(sql, uid);
    }

    /**
     * 根据id查询用户
     *
     * @param uid
     * @return
     */
    @Override
    public User findById(int uid) {
        String sql = "SELECT * FROM student_info WHERE uid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), uid);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE student_info SET username = ?, name = ?, email = ?, telephone = ?, gender = ?," +
                " birthday = ?, education = ?, family = ?,department = ? WHERE uid = ?";
        template.update(sql, user.getUsername(), user.getName(), user.getEmail(), user.getTelephone(),
                user.getGender(), user.getBirthday(), user.getEducation(), user.getFamily(),user.getDepartment(), user.getUid());
    }
}
