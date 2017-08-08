<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TV Series</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/tvseries.css" />
</head>
<body>
	<h1>List of TV Series</h1>

	<table>
		<c:forEach var="series" items="${tvseries}">
			<tr>
				<td><img />${series.name}</td>
				<td>${series.description}</td>
				<td>${series.rating}</td>
				<td>${series.date}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>