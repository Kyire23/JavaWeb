package com.oumuanade.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //获取ServletConfig对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象" + application);

        //获取上下文初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        //获取context Path (获取应用上下文的根)
        String contextPath = application.getContextPath();
        out.print(contextPath+"<br>");

        //获取文件的绝对路径
        String realPath = application.getRealPath("/index.html");
        out.print(realPath+"<br>");

        //向ServletContext应用域中存数据
        User user = new User("jack","123");
        //存
        application.setAttribute("userObj",user);
        //取
        Object userObj = application.getAttribute("userObj");
        //输出到浏览器
        out.print(userObj+"<br>");

    }
}
