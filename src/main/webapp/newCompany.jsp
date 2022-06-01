<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<c:if test="${not empty nameCompany}">
		Empresa ${nameCompany} cadastrada com sucesso.
	</c:if>

	<c:if test="${empty nameCompany }">
		Nenhuma Empresa cadastrada.
	</c:if>

</body>
</html>