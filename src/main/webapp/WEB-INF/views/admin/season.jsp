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
		<h1>List of Season: "${series.name}" </h1>
		<br /> <a href="/Season/addSeason/${series.id}"> Add Season</a>
		<hr />

		<div class="container">
			<table class="table table-striped .table-hover">
			<tr class="info">
			<td>Season Number</td>
			<td>Poster</td>
			<td>Release Date</td>
			<td>Action</td>
			</tr>
				<c:forEach var="season" items="${seasons}">
					<tr>
						<td><a href="showEpisode/${season.id}/">${season.seasonNumber}</td>
						<td>${season.poster}</td>
						<td>${season.releaseDate}</td>
						<td><p data-placement="top" data-toggle="tooltip"
								title="Edit">
								<a class="btn btn-warning btn-xs"
									href="/Season/editSeason/${season.id}"><span
									class="glyphicon glyphicon-pencil"></span> </a>
							</p></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>