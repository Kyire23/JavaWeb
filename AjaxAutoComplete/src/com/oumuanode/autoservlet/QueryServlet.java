package com.oumuanode.autoservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keywords = request.getParameter("keywords");


        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/oumuanode?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select content from t_ajax where content like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keywords+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                String content = rs.getNString("content");
                sb.append("{\"content\":\""+content+"\"},");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.subSequence(0,sb.length()-1)+"]");
    }
}
