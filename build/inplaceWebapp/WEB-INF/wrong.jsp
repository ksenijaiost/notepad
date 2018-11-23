<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>Отметьте заметку для редактирования.</h1>
Today is: <%= new java.util.Date()%>
<br>
<form action="ActionOk">
<input name="action" type="submit" value="cancel" >
</body>
</html>