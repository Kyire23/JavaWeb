package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 员工管理的。
 * 员工管理的前提也是需要先登录。
 */
public class OrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*// post请求乱码问题
        request.setCharacterEncoding("UTF-8");
        // 响应中文乱码问题
        response.setContentType("text/html;charset=UTF-8");*/

        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("username") != null){
            String servletPath = request.getServletPath();
            //...
        }else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}