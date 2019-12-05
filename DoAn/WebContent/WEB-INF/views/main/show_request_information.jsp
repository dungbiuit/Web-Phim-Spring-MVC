<%@page pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en" dir="ltr" style="height: 100%;">
  <head>
  <base href="${pageContext.servletContext.contextPath}/">
  <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
				<meta charset="utf-8">
    <title>Request Movie</title>
    <link href="
					<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
  </head>
<body style="height:100%;">
	<div class="container-show-request-information">
		<h3 style="text-align: center;font-size: 3vw;">Your Request Information !!!</h3>
			<p>Movie's name: ${request.movie_name}</p>
			<p>Category: ${request.category.category_name}</p>
			<p>Introduction: ${request.introduction}</p>
			<p>Movie's Avatar</p>
			
			<img alt="" src="/DoAn/resources/images/avatar_request/${photo_name}" id="avatar-show-request-information">
			<br>
			<a href="/DoAn/main/request_movie/${user.username}.htm"><button type="button" class="btn btn-primary btn-back-request-movie">Back for more requests</button></a>
			
	</div>
</body>
</html>