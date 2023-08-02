<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/5/20
  Time: 22:21
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
<div class="panel-head" style="height: 40px;background-color: #a8a5a5;padding-left: 240px;line-height: 40px;"><strong class="icon-reorder">成绩列表</strong></div><body>
<form method="post" action="FindScoreServlet">
    <div class="search" style="padding: 10px;">
        <input type="text" name="Sno" value="输入学号查询" style="height: 30px;width: 230px;"> <button style="font-size: 16px;">查询</button>
    </div>
</form>
<table class="table">
    <tr>
        <td>学名</td>
        <td>课程号</td>
        <td>课程成绩</td>
    </tr>
    <c:forEach items="${scores}" var="s">
    <tr>
        <td>${s.getSno()}</td>
        <td>${s.getCno()}</td>
        <td>${s.getScore()}</td>
    </tr>
    </c:forEach>
</body>
</html>
