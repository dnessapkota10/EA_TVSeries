<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TV Series</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/bootstrap-min.js" type="text/javascript"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/tvseries.css" />
</head>
<body>
	
	<div class="container">
		
			<form class="form-horizontal" action="/Search">
		<div class="search_by">
			<div class="search-field">
				<label>Search By</label> <select class="form-control selectpicker"
					name="searchBy">
					
					<option value="ByName">Show Name</option>
					<option value="ByGenre">Genre</option>
					<option value="ByRating">Rating</option>
					<option value="ByArtist">Artist</option>
					<option value="ByCharacter">Character</option>
					<option value="ByDirector">Director</option>
				</select>

			</div>
			<div class="search-field">
				<label>Keyword</label> <input type="text"
					placeholder="Please enter "
					class="form-control search_by_keyword" name="searchValue">
			</div>
		</div>
</form>
		<h4>Popular TV Series</h4>
		<br /> <a href="/html/addSeries.html"> Add a Series</a>
		<hr />

		<table class="table table-striped .table-hover">
			<tr class="info">
				<td>NAME</td>
				<td>DESCRIPTION</td>
				<td>RATING</td>
				<td>RElEASE</td>
				<td>STUDIO</td>
				<td>ACTION</td>
			</tr>
			<c:forEach var="series" items="${tvseries}">
				<tr>
					<td><a href="showSeason/${series.id}/">${series.name}</a></td>
					<td>${series.description}</td>
					<td>${series.rating}</td>
					<td>${series.releaseDate}</td>
					<td>${series.studio}</td>

					<td><p data-placement="top" data-toggle="tooltip" title="Edit">
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