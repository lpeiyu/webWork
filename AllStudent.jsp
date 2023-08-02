<%@ page import="empty.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/5/12
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/allClass.css">
    <title>班级管理系统</title>
</head>
<body>
<jsp:include page="Student.jsp"></jsp:include>
<div class="panel-head" style="height: 40px;background-color: #a8a5a5;padding-left: 240px;line-height: 40px;"><strong class="icon-reorder">学生列表</strong></div>
<table class="table" id="tbl">
    <tr>
        <td>学号</td>
        <td>学生姓名</td>
        <td>年龄</td>
        <td>户籍</td>
    </tr>
    <% ArrayList<Student> students=(ArrayList<Student>) request.getAttribute("students");
        for (Student stu:students){
    %>
    <tr>
        <td><%=stu.getSno() %></td>
        <td><%=stu.getSname() %></td>
        <td><%=stu.getSage() %></td>
        <td><%=stu.getSaddress() %></td>
    </tr>
    <%} %>
</table>
</body>
</html>
