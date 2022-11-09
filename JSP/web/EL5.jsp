<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] name ={"zhangsan","lisi","wangwu"};
    request.setAttribute("nameArray",name);

    //list 同理

%>

${nameArray}
${nameArray[0]}
${nameArray[100]}
<%--nameArray[100]不会报错 只是取不到--%>
