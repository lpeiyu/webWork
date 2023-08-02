<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/4/21
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="./css/login.css">
  <title>班级管理系统登录</title>
</head>
<body>
<div class="login">
  <form action="LoginServlet" method="post">
    <h1>班级管理系统</h1>
    <p>
      <label>账号：<input type="text" name="id" value="${cookie.id.value}"/></label>
    </p>
    <p>
      <label>密码：<input type="password" name="password" value="${cookie.password.value}"/></label>
    </p>
    <p>
      <input type="radio" name="user" value="stu">学生  <input type="radio" name="user" value="tea">教师
    </p>
    <p>
      <input type="checkbox" name="check" value="check">记住密码
    </p>
    <p>没有账号？<a href="register.jsp">去注册</a></p>
    <p>
      <label>
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
      </label>
    </p>
  </form>
</div>
</body>
</html>

