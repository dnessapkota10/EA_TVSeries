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
		
		<h4>EPISODES</h4>
		<h5>Series: ${series.name} Season: ${season.seasonNumber} </h5>
		<br /> <a href="/Episode/addEpisode/${season.id}"> Add Episode</a>
		<hr />

		<div class="container">
			<table class="table table-striped .table-hover">
			<tr class="info">
			<td>Episode Number</td>
			<td>Name</td>
			<td>Description</td>
			<td>Rating</td>
			<td>Release Date</td>
			<td>Poster</td>
			<td>Director</td>
			</tr>
				<c:forEach var="episode" items="${episodes}">
					<tr>
						<td>${episode.episodeNumber}</td>
						<td>${episode.name}</td>
						<td>${episode.description}</td>
						<td>${episode.rating}</td>						
						<td>${episode.releaseDate}</td>
						<td>${episode.poster}</td>
						<td>${episode.director}</td>
						<td><p data-placement="top" data-toggle="tooltip"
								title="Edit">
								<a class="btn btn-warning btn-xs"
									href="/Episode/editEpisode/${episode.id}"><span
									class="glyphicon glyphicon-pencil"></span> </a>
							</p></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>