<%@ page contentType="text/html;charset=UTF-8" language="java" %>


应用的根路径: ${pageContext.request.contexPath}<br>

用户名:<%=request.getParameter("name")%><br>
用户名:${param.name}<br>

爱好：${param.aihao}<br>
爱好：<%=request.getParameter("aihao")%>

一维数组：${paramValues.aihao}<br>
一维数组：<%=request.getParameterValues("aihao")%><br>

<%--获取数组当中的元素，【下标】--%>
爱好 ${paramValues.aihao[0]},${paramValues.aihao[1]},${paramValues.aihao[2]}