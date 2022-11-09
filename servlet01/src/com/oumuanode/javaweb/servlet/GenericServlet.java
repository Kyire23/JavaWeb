package com.oumuanode.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编写一个标准的Servlet
 * GenericServlet 充当适配器
 */
public  abstract class GenericServlet implements Servlet {
    //声明成员变量
    private ServletConfig config;

    @Override
    public final void init(ServletConfig config) throws ServletException {
        this.config = config;
        //如果LoginServlet再想重写init方法只需
        this.init();
    }

    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
