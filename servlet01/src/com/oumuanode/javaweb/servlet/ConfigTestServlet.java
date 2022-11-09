package com.oumuanode.javaweb.servlet;

import javax.servlet.*;
import javax.servlet.GenericServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        out.print("ServletConfig对象是:"+config.toString());
        out.print("<br>");

        String servletName = config.getServletName();
        out.print("<servlet-name>"+servletName+"<servlet-name>");

        //遍历集合
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String parameterName = initParameterNames.nextElement();
            String parameterVal = config.getInitParameter(parameterName);
            out.print(parameterName+"="+parameterVal);
            out.print("<br>");
        }

        String driver = config.getInitParameter("driver");
        out.print(driver);

        //实际获取Servlet对象初始化信息 可以不用获取ServletConfig对象 也可以通过this来调用
        Enumeration<String> names = this.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            //打印到后台
            System.out.println(name+"="+value);

        }
        //通过ServletConfig对象获取ServletContext对象
        ServletContext application = config.getServletContext();
        //输出
        System.out.print("<br>"+application);

        //也可以使用this
        ServletConfig application2 = this.getServletConfig();
        out.print("<br>"+application2);

    }
}
