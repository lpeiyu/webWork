<%@ page import="empty.Work" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/4/23
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/allClass.css">
    <title>班级管理系统</title>
</head>
<body>
<jsp:include page="Teacher.jsp"></jsp:include>
<div class="panel-head" style="height: 40px;background-color: #a8a5a5;padding-left: 240px;line-height: 40px;"><strong class="icon-reorder">作业列表</strong></div>
<table class="table" id="tbl">
    <tr>
        <td>课程号</td>
        <td>发布日期</td>
        <td>截止日期</td>
        <td>作业内容</td>
    </tr>
<% ArrayList<Work> works=(ArrayList<Work>) request.getAttribute("works");
    for (Work work1:works){
%>
<tr>
    <td><%=work1.getCno() %></td>
    <td><%=work1.getPublishDate() %></td>
    <td><%=work1.getDeadline() %></td>
    <td><%=work1.getMessage() %></td>
</tr>
<%} %>
</table>
</body>
</html>
