<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/control?action=NewCompany" var="newCompany" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${newCompany}" method="post">
	Name: <input type="text" name="nameCompany"/>
	Open Date: <input type="date" name="openDate"/>
	<input type="submit"/>
	</form>

</body>
</html>