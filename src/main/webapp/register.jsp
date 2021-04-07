<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/6
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form action="register" method="post">
    id<input type="text" name="id" /><br/>
    username<input type="text" name="username" /><br/>
    password<input type="password" name="password" /><br/>
    email<input type="text" name="email" /><br/>
    gender<input type="radio" name="gender" value="Male">Male<input type="radio" name="gender" value="Female">Female<br/>
    birthdate<input type="text" name="birthdate"/><br/>
    <input type="submit" value="register">
</form>
<%@include file="footer.jsp"%>
