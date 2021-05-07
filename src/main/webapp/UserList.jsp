<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/4/13
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %>
<h1>User List</h1>

<table border="1">
    <tr>
       <th>username</th><th>password</th><th>email</th><th>gender</th><th>birthdate</th>
    </tr>
    <%
        ResultSet rs= (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td>No data!!</td>
    </tr>
    <%}else {

            while (rs.next()) {
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                String email1 = rs.getString("email");
                String gender1 = rs.getString("gender");
                Date birthdate1 = rs.getDate("birthdate");
                out.println("<tr><td>" + username1 + "</td>");
                out.println("<td>" + password1 + "</td>");
                out.println("<td>" + email1 + "</td>");
                out.println("<td>" + gender1 + "</td>");
                out.println("<td>" + birthdate1 + "</td></tr>");
            }
    }
%>
</table>

<%@include file="footer.jsp"%>
