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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeValue="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cusername")){
                username=c.getValue();
            }
            if(c.getName().equals("cpassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeValue=c.getValue();
            }
        }
    }
%>
<form method="post" action="Login">
    Username:<input type="text" name="username" value="<%=username%>"><br>
    Password:<input type="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeValue.equals("1")?"checked":""%> />RememberMe<br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
