<%@ page import="jsp.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //创建User对象
    User user = new User();
    user.setName("zhangsan");


    //将User对象存储到request域当中
    request.setAttribute("pwd", user);
    request.setAttribute("skd", "hello word");


%>

${pwd}<br>
${pwd.name}<br>
${pwd["name"]}<br>
${skd}

