<%--<%@ page import="java.sql.ResultSet" %>--%>
<%--<%@ page import="javax.sql.DataSource" %>--%>
<%--<%@ page import="java.sql.Connection" %>--%>
<%--<%@ page import="java.sql.Statement" %>&lt;%&ndash;--%>
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/5/3
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*" %>
<%
    DataSource dataSource=(DataSource) application.getAttribute("dataSource");
    Connection conn= dataSource.getConnection();
    Statement stmt= conn.createStatement();
    ResultSet rst=stmt.executeQuery("SELECT * FROM score");
%>
<html>
<head>
    <title>班级管理系统</title>
</head>
<body>
<table>
    <tr>
        <td>学名</td>
        <td>课程号</td>
        <td>课程成绩</td>
    </tr>
    <% while (rst.next()){ %>
    <tr>
        <td><%= rst.getString(1)%></td>
        <td><%= rst.getString(2)%></td>
        <td><%= rst.getInt(3)%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
