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
  User u=(User)session.getAttribute("user");
%>
<table>
    <tr>
        <td>id:</td><td><%=u.getId()%></td>
    <tr/>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    <tr/>
    <tr>
        <td>password:</td><td><%=u.getPassword()%></td>
    <tr/>
    <tr>
        <td>email:</td><td><%=u.getEmail()%></td>
    <tr/>
    <tr>
        <td>gender:</td><td><%=u.getGender()%></td>
    <tr/>
    <tr>
        <td>birthdate:</td><td><%=u.getBirthdate()%></td>
    <tr/>
    <tr>
        <td><a href="updateUser">update</a></td>
    </tr>
</table>

<%@include file="footer.jsp"%>