package com.oumuanade.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //获取ServletConfig对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象"+application);

        //通过ServletContext 对象可以记录日志
        //记录在 CATALINA_HOME/logs 目录下
        application.log("这是日志");
    }
}
