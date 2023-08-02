<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/5/20
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/Student.css">
    <title>班级管理系统</title>
</head>
<body>
<jsp:include page="Student.jsp"></jsp:include>
${sessionScope.message}<br>
您的IP地址是${pageContext.request.remoteAddr}<br>
<p>自应用程序启动以来，该页面被访问了${applicationScope.count}次</p>
</body>
</html>
