<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2024/3/31
  Time: 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<form method="post" action="login">
    userName:<input type="text" name="userName">
    <br>
    Password:<input type="text" name="Password">
    <br>
    <button>Login</button>
</form>
<%@include file="footer.jsp"%>
