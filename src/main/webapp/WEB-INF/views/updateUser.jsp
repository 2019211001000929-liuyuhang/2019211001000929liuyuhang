<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/26
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u=(User) session.getAttribute("user");
%>
<form action="updateUser" method="post">
    id<input type="text" name="id" value=<%=u.getId()%>><br/>
    username<input type="text" name="username" value=<%=u.getUsername()%>><br/>
    password<input type="password" name="password" value=<%=u.getPassword()%>><br/>
    email<input type="text" name="email" value=<%=u.getEmail()%>><br/>
    gender<input type="radio" name="gender" value="Male" <%="Male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="Female"<%="Female".equals(u.getGender())?"checked":""%>>Female<br/>
    birthdate<input type="text" name="birthdate" value=<%=u.getBirthdate()%>><br/>
    <input type="submit" value="Save Changes">
</form>
<%@include file="footer.jsp"%>
