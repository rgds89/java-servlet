<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/control?action=Login" var="login" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="${login}" method="post">
	Login: <input type="text" name="login">
	Password:<input type="password" name="password">
	<input type="submit">
	</form>

</body>
</html>