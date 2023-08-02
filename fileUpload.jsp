<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/4/18
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级管理系统</title>
</head>
<body>
<%--<jsp:include page="Teacher.jsp"></jsp:include>--%>
<c:import url="Teacher.jsp" charEncoding="UTF-8"></c:import>
${message1}<br>
<form action="fileUpload.do" enctype="multipart/form-data" method="post">
    <table>
        <tr><td colspan="2" align="center">班级文件上传</td></tr>
        <tr>
            <td>序号：</td>
            <td><input type="text" name="number" size="30"></td>
        </tr>
        <tr>
            <td>文件名：</td>
            <td><input type="file" name="filename" size="30"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="提交"></td>
            <td align="left"><input type="reset" value="重置"></td>
        </tr>
    </table>

    <a href="FileDownLoadServlet.do" style="color: blue">点击下载班级文件</a>
</form>

</body>
</html>
