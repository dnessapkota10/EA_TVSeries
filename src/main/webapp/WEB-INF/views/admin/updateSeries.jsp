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
		<h3>Update Series : ${series.name}</h3> <hr/>
		<form action="../updateSeries/${series.id}" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						value="${series.name}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Description:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="description"
						name="description" value="${series.description}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Date:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="releaseDate"
						name="releaseDate" value="${series.releaseDate}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Rating:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="rating" name="rating"
						value="${series.rating}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Studio:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="studio" name="studio"
						value="${series.studio}">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-info">Submit</button>
				</div>
			</div>
	</div>
	</form>
	</div>
</body>
</html>