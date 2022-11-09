<%--
  Created by IntelliJ IDEA.
  User: Kyire
  Date: 2022/10/22
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("username","zhangsan");
%>
<%=request.getAttribute("username")%>
${username}
<html>
<head>
    <title>EL表达式</title>
</head>
<body>

</body>
</html>
