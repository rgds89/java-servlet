<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nameCompany = (String) request.getAttribute("nameCompany");
%>
<html>
<body>
Empresa <%=nameCompany %> cadastrada com sucesso
</body>
</html>