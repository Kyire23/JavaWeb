<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="jsp.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String,String> map = new HashMap<>();
    map.put("name","zhangsan");
    map.put("password","123");

    Map<String, User> userMap2 = new HashMap<>();
    User user = new User();
    user.setName("zhnagsan");
    userMap2.put("user",user);
    request.setAttribute("userMap",map);
%>
${userMap.name}
<hr>
${userMap.name}
<br>
${userMap.password}
<br>