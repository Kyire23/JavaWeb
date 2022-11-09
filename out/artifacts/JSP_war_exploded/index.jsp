<%@page contentType="text/html;charset=UTF-8" %>
<%
    System.out.println("hello jsp");//相当于在方法体里写代码
%>

<%
    //在service 方法中编写代码是有顺序 依次逐行执行
    int num = 100;
    System.out.println("num" + num);
%>

<%! //service以外执行
    private String name = "jack";

    static {
        System.out.println("静态代码块执行了");
    }

    //方法
    public static void m1() {
        System.out.println("m1 method execute!");
    }

%>

<%
    String name = "jack";
    System.out.println("name" + name);
   // out.write("name2" + name);//不代表出错

    //输出java变量使用内置对象out
    int i = 100;
//    out.write(i);

    int a=100;
    int b =100;
    int c = a+b;

%>
<%--输出普通字符串--%>

zhangsan

<%=100+200%>
<%-- == out.print(); 不能加; --%>
<%= c%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Scanner" %>
<!-- 以下为HTML代码 -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>模拟服务器与浏览器的一次简单交互</title>
</head>
<body>
<!--  以下为嵌入的java语句 -->
<%
    Date date = new Date(); // 获取当前时间戳
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 时间日期格式
    String today = sdf.format(date);
    Scanner input = new Scanner(System.in);
    System.out.println("浏览器需要你的名字：");
//    String name = input.nextLine();
    System.out.println("浏览器需要你的性别：");
    String sex = input.nextLine();
    System.out.println("浏览器需要你的年龄：");
    int age = input.nextInt();
    input.close();
%>
当日时间：<%= today%>
<br>
服务器的名字：<%= name %>
<br>
服务器的性别：<%= sex %>
<br>
服务器的年龄：<%= age %>

<%
    exception.printStackTrace();
%>
</body>
</html>
<!-- 例如设置为java语言 -->
<%@ page language="java"%>
<!-- 设置JSP页面的MIME类型和字符编码为UTF-8 -->
<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<%@page pageEncoding="UTF-8" session="false" import="com" errorPage="index.jsp" %>
