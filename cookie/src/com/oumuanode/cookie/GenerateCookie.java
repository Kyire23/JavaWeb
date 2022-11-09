package com.oumuanode.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ck/ls")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie =new Cookie("addf","1226464");
        cookie.setMaxAge(60*60);
        cookie.setPath("/cookie");
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        //如果不是null 表示一定有cookie
        if (cookie != null){
            //遍历数组
            for (Cookie cookie2:cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name+"="+value);
            }
        }
    }
}
