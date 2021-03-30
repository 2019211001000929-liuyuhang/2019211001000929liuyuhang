<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/22
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="register" >
    id<input type="text" name="id" /><br/>
    username<input type="text" name="username" /><br/>
    password<input type="password" name="password" /><br/>
    Email<input type="text" name="email" /><br/>
    Gender:<input type="radio" name="gender" value="Male">Male<input type="radio" name="Female" value="Female"/>Female<br/>
    Date of Birth :<input type="text" name="birthdate" ><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
