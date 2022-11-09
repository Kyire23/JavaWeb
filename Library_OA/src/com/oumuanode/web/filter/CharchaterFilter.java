package com.oumuanode.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决全站乱码问题，处理所有的请求
 */
@WebFilter("/*")
public class CharchaterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain filterChain) throws IOException, ServletException {
        //将父接口转为子接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) rep;

        String uri = request.getRequestURI();

        if (uri.contains(".css")) {
            response.setContentType("text/css;charset=utf-8");
            filterChain.doFilter(request, response);
        }


        //获取请求方法
        String method = request.getMethod();
        //解决post请求中文数据乱码问题
        if (method.equalsIgnoreCase("post")) {
            request.setCharacterEncoding("utf-8");
        }
        //处理响应乱码
        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");


        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
