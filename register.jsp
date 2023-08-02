<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2023/5/12
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>班级管理系统——注册</title>
</head>
<body>
<form method="post" onsubmit="return checkForm()">
    <p>
        <label>账号：<input type="text" name="username" id="username" onblur="check(this.value)"/></label>
    </p>
    <p>
        <label>密码：<input type="password" name="password" id="password"/></label>
    </p>
    <input type="button" value="完成">
    <div id="result"></div>
</form>

</body>
</html>
<script>
    var xmlHttp;
    var flag=false;
    function createXmlHttp(){
        if (window.XMLHttpRequest){
            xmlHttp=new XMLHttpRequest();
        }else {
            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    function check(username){
        createXmlHttp();
        var url="validationServlet?username="+username
        xmlHttp.open("get",url)
        xmlHttp.onreadystatechange=handleStateChange
        xmlHttp.send(null)
    }
    function handleStateChange(){
        if (xmlHttp.readyState==4){
            if (xmlHttp.status==200){
                var message=xmlHttp.responseText;
                if(message=="true"){
                    document.getElementById("result").innerHTML="账号已存在"
                    flag=false
                }else {
                    document.getElementById("result").innerHTML="账号可以使用"
                    flag=true
                }
            }
        }
    }
    function checkForm(){
        return flag
    }
</script>
