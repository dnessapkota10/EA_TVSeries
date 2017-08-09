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
		<h3>Add a episode: ${series.name} Season: ${season.seasonNumber}</h3>
		<hr />
		<form action="/Season/addNewEpisode/${season.id}"
			method="post">
			<table>
				<tr>
					<td>Episode Number:</td>
					<td><input type="text" name="episodeNumber" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td>Rating:</td>
					<td><input type="text" name="rating" /></td>
				</tr>
				<tr>
					<td>Release Date:</td>
					<td><input type="text" name="releaseDate" /></td>
				</tr>
				<tr>
					<td>Poster:</td>
					<td><input type="text" name="poster" /></td>
				</tr>
				<tr>
					<td>Director:</td>
					<td><input type="text" name="director" /></td>
				</tr>
			</table>
			<input type="submit" />
		</form>
	</div>
</body>
</html>