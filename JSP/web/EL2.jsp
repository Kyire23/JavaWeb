<%@ page import="jsp.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //创建User对象
    User user = new User();
    user.setName("jack");
    user.setPassword("123");
    user.setAge(18);

    //将User对象存储到request域当中
    request.setAttribute("userObj", user);

    session.setAttribute("data","session");
%>
${userObj}
<br>
${userObj.name}
${userObj.password}
${userObj.age}
<%--EL表达式在没有指定范围时从小范围中取数据--%>
<%-- pageContext < request < session < application --%>
${sessionScope.data}<br>


