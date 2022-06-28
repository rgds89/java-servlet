<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="updateCompany" var="updateCompany" />


<!DOCTYPE html>
<html>
<body>
	<form action="${updateCompany}" method="post">
		Id: <input type="text" name="id" value="${company.id}" readonly/>
		Name: <input type="text" name="nameCompany" value="${company.name}"/>
		Open Date: <input type="text" name="openDate" value="<fmt:formatDate value="${company.openDate}" pattern="dd/MM/yyyy" />" />
		           <input type="submit" />
	</form>
</body>
</html>