<%@ page import="com.liuyuhang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/13
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<table>
    <tr>
        <td>id:</td><td><%=user.getId()%></td>
        <td>Username:</td><td><%=user.getUsername()%></td>
        <td>password:</td><td><%=user.getPassword()%></td>
        <td>email:</td><td><%=user.getEmail()%></td>
        <td>gender:</td><td><%=user.getGender()%></td>
        <td>birthdate:</td><td><%=user.getBirthdate()%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>