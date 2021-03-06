<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.domain.Company"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/control?action=RemoveCompany&id=" var="removeCompany" />
<c:url value="/control?action=GetCompany&id=" var="getCompany" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>
	Usuario Logado: ${user.login}
	<br />

	<c:import url="logout.jsp"></c:import>

	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>

	<h4>Lista de sempresas:</h4>
	<br />
	<ul>
		<c:forEach items="${companies}" var="company">
			<li>${company.name} <fmt:formatDate value="${company.openDate}"
					pattern="dd/MM/yyyy" /> <a href="${removeCompany}${company.id}">remove</a>
				<a href="${getCompany}${company.id}">edita</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>