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
		<h3>Add a season: ${series.name}</h3><hr/>
		<form action="/Season/addNewSeason/${series.id}" method="post">
			<table>
				<tr>
					<td>Season Number:</td>
					<td><input type="text" name="seasonNumber" /></td>
				</tr>
				<tr>
					<td>Poster:</td>
					<td><input type="text" name="poster" /></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="releaseDate" /></td>
				</tr>

			</table>
			<input type="submit" />
		</form>
	</div>
</body>
</html>