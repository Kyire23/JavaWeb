package com.oumuanode.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder xml = new StringBuilder();
        xml.append("<students>");
        xml.append("<student>");
        xml.append("<name>zhangsan</name>");
        xml.append("<age>20</age>");
        xml.append("</student>");
        xml.append("<student>");
        xml.append("<name>lisi</name>");
        xml.append("<age>22</age>");
        xml.append("</student>");
        xml.append("</students>");

        out.print(xml);
    }
}
