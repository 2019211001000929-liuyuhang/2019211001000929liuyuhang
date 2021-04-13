<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/13
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>id:</td><td><%=request.getAttribute("id")%></td>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
        <td>password:</td><td><%=request.getAttribute("password")%></td>
        <td>email:</td><td><%=request.getAttribute("email")%></td>
        <td>gender:</td><td><%=request.getAttribute("gender")%></td>
        <td>birthdate:</td><td><%=request.getAttribute("birthdate")%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>