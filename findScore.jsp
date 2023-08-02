<%@ page import="empty.Score" %><%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/4/24
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/allClass.css">
    <title>班级管理系统</title>
</head>
<body>
<jsp:include page="Teacher.jsp"></jsp:include>
<div class="panel-head" style="height: 40px;background-color: #a8a5a5;padding-left: 240px;line-height: 40px;"><strong class="icon-reorder">成绩列表</strong></div><body>
<table class="table">
    <tr>
        <td>学名</td>
        <td>课程号</td>
        <td>课程成绩</td>
    </tr>
    <tr>
        <td><c:out value="${score.getSno()}"/></td>
        <td><c:out value="${score.getCno()}"/></td>
        <td><c:out value="${score.getScore()}"/></td>
    </tr>
</table>
</body>
</html>
