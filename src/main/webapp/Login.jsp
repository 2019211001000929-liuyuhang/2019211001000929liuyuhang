<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/6
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 Style="font-size:20px">Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="Login">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
