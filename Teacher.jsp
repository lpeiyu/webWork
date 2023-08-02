<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/3/29
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/Student.css">
    <title>班级管理系统</title>
</head>
<body>
<div class="head"><span class="one">班级管理系统</span><a href="exit.html" class="three">退出</a></div>
<div class="menu">
    <div class="classes"><a href="displayStudentServlet" target="right">学生列表</a></div><hr/>
    <%--    修改成绩--%>
    <div class="classes"><a href="TeaScore.jsp" target="right">成绩列表</a></div><hr/>
    <%--    新增和删除作业--%>
    <div class="classes"><a href="Work.jsp" target="right">作业列表</a></div><hr/>
    <div class="classes"><a href="fileUpload.jsp" target="right">上传或下载文件</a></div><hr/>
</div>
</body>
</html>
