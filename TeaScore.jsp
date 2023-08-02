<%@ page import="empty.Score" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/3/30
  Time: 15:22
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
<div class="panel-head" style="height: 40px;background-color: #a8a5a5;padding-left: 240px;line-height: 40px;"><strong class="icon-reorder">成绩列表</strong></div>
<form method="post" action="FindScoreServlet">
    <div class="search" style="padding: 10px;">
        <input type="text" name="Sno" value="输入学号查询" style="height: 30px;width: 230px;"> <button style="font-size: 16px;">查询</button>
    </div>
</form>
<div class="button-group" style="margin: 10px"><button class="buttonForm" style="margin-left: 30px;font-size: 20px">修改成绩</button>
<a href="displayScoreServlet" style="color: #2578b5">点击查看所有成绩</a>
</div>
    <div id="modal" class="modal">
        <div class="modal-content">
            <%--                    关闭标签--%>
            <span class="close">&times;</span>
            <h2>修改学生成绩</h2>
            <form method="post" action="UpdateScoreServlet">
                <label for="Sno">学号:</label>
                <input type="text" id="Sno" name="Sno"><br><br>
                <label for="Cno">课程号:</label>
                <input type="text" id="Cno" name="Cno"><br><br>
                <label for="Score">成绩:</label>
                <input type="text" id="Score" name="Score"><br><br>
                <input type="submit" value="提交">
                <%--                        <button class="close">关闭</button>--%>
            </form>
        </div>
    </div>

</body>
</html>
<script>
    // 获取需要用到的元素
    const buttonForm = document.getElementsByClassName("buttonForm");
    //console.log(buttonForm)
    const modal = document.getElementById("modal");
    const closeModalBtn = document.getElementsByClassName("close")[0];
    const overlay = document.createElement("div");
    //添加元素(修改框)
    overlay.classList.add("overlay");
    // 打开修改框
    function openForm() {
        modal.style.display = "block";
        document.body.appendChild(overlay);
    }
    // 关闭修改框
    function closeModal() {
        modal.style.display = "none";
        document.body.removeChild(overlay);
    }

    // 为按钮绑定点击事件，getElementsByClassName得到的是一个数组，addEventListener只能监听一个元素，
    for (i=0;i<buttonForm.length;i++){
        console.log(buttonForm[i])
        buttonForm[i].addEventListener("click", openForm)
    }
    // 为关闭按钮绑定点击事件
    closeModalBtn.addEventListener("click", closeModal);
    // 为遮罩层绑定点击事件，点击到遮罩层也关闭窗口
    overlay.addEventListener("click", closeModal);

    // 防止点击修改框里面的内容也触发遮罩层事件冒泡
    modal.addEventListener("click", function (event) {
        event.stopPropagation();
    });
</script>