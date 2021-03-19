<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/17
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    function checkpassword(){
        var x=document.getElementById("password");
        var y=document.getElementById("passworderror");
        if(x.value.length<8){
            y.innerHTML="error";
            return false;
        }else {
            y.innerHTML = "ok";
            return true;
        }
    }
    function checkemial(){
        var x=document.getElementById("email").value;
        var y=document.getElementById("emialerror");
        var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
        if(reg.test(x)===false){
            y.innerHTML="error";
            return false;
        }else{
            y.innerHTML="ok";
            return true;
        }
    }
    function check(){
        var x=document.getElementById("emialerror");
        var y=document.getElementById("passworderror");
        if(x.innerHTML==="ok"&&y.innerHTML==="ok"){
            alert("Login was successful");
            return true;
        }else{
            alert("Please fill in the password and email correctly");
            return false;
        }
    }
</script>
<form method="post" action="register.jsp" onsubmit="check()">
    New User Registration<br/>
    <input type="text" name="Username" placeholder="Username" size="20" required><br/>
    <input type="password" name="password" id="password" placeholder="Password" size="20" onblur="checkpassword()" required>
    <span id="passworderror">least 8 characters</span><br/>
    <input type="text" name="Email" placeholder="Email" id="email" size="20" onblur="checkemial()" required>
    <span id="emialerror">vaild email</span><br/>
    Gender
    <input type="radio" name="mycheck" value="Male" checked>Male
    <input type="radio" name="mycheck" value="Female">Female<br/>
    <input type="date" name="Birthdate" placeholder="Date of Birth(yyyy-mm-dd)" required><br/>
    <input type="submit"  value="Register">
</form>
</body>
</html>
