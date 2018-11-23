<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>LogIn</h1>
Today is: <%= new java.util.Date()%>
<br><br>
<form action="ActionLogin" method="post">
<br><br>
Login: <input name="login" type="text" placeholder="enter login" size="20" maxlength="32">
Password: <input name="password" type="password" placeholder="enter password" size="20" maxlength="32">
<br><br>
<input name="submit" type="submit" value="ok">
</form>
</body>
</html>