<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TV Series</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/tvseries.css" />
</head>
<body>
	<div class="container">
		<h1>List of TV Series</h1>
		<br /> <a href="/html/addSeries.html"> Add a Series</a>
		<hr />

		<table class="table table-striped .table-hover">
			<c:forEach var="series" items="${tvseries}">
				<tr>
					<td><a href="showSeason/${series.id}/">${series.name}</a></td>
					<td>${series.description}</td>
					<td>${series.rating}</td>
					<td>${series.releaseDate}</td>
					<td>${series.studio}</td>
					<td>
					<td><p data-placement="top" data-toggle="tooltip"
							title="Edit">
							<a class="btn btn-warning btn-xs"
								href="/Series/editSeries/${series.id}"><span
								class="glyphicon glyphicon-pencil"></span> </a>
						</p></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>