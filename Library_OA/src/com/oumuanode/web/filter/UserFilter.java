package com.oumuanode.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/user/*")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        // 获取资源请求路径
        String uri = request.getRequestURI();

        System.out.println("用户filter：" + uri);

        if (uri.contains("/user/login")) {
            chain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            Object admin = request.getSession().getAttribute("admin");
            if (user != null || admin != null) {
                chain.doFilter(req, resp);
            } else {
                request.getRequestDispatcher("/user_login.html").forward(request, resp);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
