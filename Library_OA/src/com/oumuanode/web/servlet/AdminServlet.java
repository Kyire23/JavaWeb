package com.oumuanode.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.oumuanode.domain.Admin;
import com.oumuanode.domain.ResultInfo;
import com.oumuanode.service.AdminService;
import com.oumuanode.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {
    private AdminService service = (AdminService) new AdminServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //验证码校验
        String verifycode = request.getParameter("verifycode");

        //从Session中获取验证码
        HttpSession session = request.getSession();
        String check_code= (String) session.getAttribute("CHECKCODE_SERVER");
        //保证验证码只能使用一次 刷新session
        session.removeAttribute("CHECKCODE_SERVER");
        //开始校验
        if (check_code == null | !check_code.equals(verifycode)) {
            ResultInfo info = new ResultInfo();
            //失败
            info.setFlag(false);
            info.setErrorMsg("请输出正确的验证码");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //获取用户密码方法
        Map<String, String[]> map = request.getParameterMap();
        //封装用户信息
        Admin admin = new Admin();
        /**
         *BeanUtils.populate 这个方法会遍历map<key, value>中的key，如果bean中有这个属性
         * 就把这个key对应的value值赋给bean的属性
         */
        try {
            BeanUtils.populate(admin, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Admin admin1 = service.login(admin);
        ResultInfo info = new ResultInfo();
        //判断用户对象是否为空
        if (admin1 == null) {
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        } else {
            session.setAttribute("admin", admin1);
            info.setFlag(true);
        }

        //响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }
}
