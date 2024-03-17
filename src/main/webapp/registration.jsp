<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2024/3/10
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>
<form method="post" action="register">
    New User Registration! <br>
    <input type="text" placeholder="Username" name="username"><br>
    <input type="password" placeholder="Password" name="password"><br>
    <input type="email" placeholder="Email" name="email"><br>
    <b>Gender:</b> <input type="radio" checked="checked" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br>
    <input type="text" placeholder="Date of Birth (yyyy-mm-dd)" id="dateInput" name="birthDate"><br>
    <input style="background-color: orange" type="submit"  value="Register" >
</form>







</body>

</html>
