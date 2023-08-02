<%@ page import="java.util.ArrayList" %>
<%@ page import="empty.Work" %><%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/3/30
  Time: 15:45
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
<%--新增作业弹窗--%>
<div id="modal" class="modal">
    <div class="modal-content">
        <%--                    关闭标签--%>
        <span class="close">&times;</span>
        <h2>新增作业</h2>
        <form method="post" action="addWorkServlet.do">
            <label for="Cno">课程号:</label>
            <input type="text" id="Cno" name="Cno"><br><br>
<%--            <label for="Tno">教师ID:</label>--%>
<%--            <input type="text" id="Tno" name="Tno"><br><br>--%>
            <label for="pushDate">发布日期:</label>
            <input type="text" id="pushDate" name="publishDate"><br><br>
            <label for="deadline">截止日期:</label>
            <input type="text" id="deadline" name="deadline"><br><br>
            <label for="content">作业内容:</label>
            <input type="text" id="content" name="content"><br><br>
            <input type="submit" value="完成">
        </form>
    </div>
</div>
<div class="button-group" style="margin: 10px"><button class="buttonForm" style="margin-left: 30px;font-size: 20px">新增作业</button>&nbsp;&nbsp;
    <a href="displayWorkServlet.do" style="color: #2578b5">点击查看所有作业</a>
</div>
<form action="deleteWorkServlet.do" method="post">
    <input name="deleteId" size="20" style="margin: 10px" value="输入课程号删除作业">
    <button>确定</button>
</form>
<table class="table" id="tbl">
    <tr>
        <td>课程号</td>
<%--        <td>教师ID</td>--%>
        <td>发布日期</td>
        <td>截止日期</td>
        <td>作业内容</td>
    </tr>
    <%--    从应用作用域中取出workList对象--%>
    <% ArrayList<Work> workList=(ArrayList<Work>) application.getAttribute("workList");%>
    <%
        for (Work work:workList){
    %>
    <tr>
        <td><%=work.getCno() %></td>
<%--        <td><%=work.getTno() %></td>--%>
        <td><%=work.getPublishDate() %></td>
        <td><%=work.getDeadline() %></td>
        <td><%=work.getMessage() %></td>
    </tr>
    <%} %>

</table>
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
        // console.log(buttonForm[i])
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

    function deleteItem(){
        let tbl=document.getElementById("tbl");
        let rows=tbl.rows;
        let tr;
        for (let i=1;i<rows.length;i++){
            tr=rows[i];
        }
        tbl.deleteRow(tr.rowIndex);
    }
</script>