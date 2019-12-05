<%@page pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en" dir="ltr">
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
  <body>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		
		<p class="navbar-text">Whenever, wherever</p>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav ml-auto mx-auto ">
					
					
						
							<a class="nav-item nav-link" href="<c:url value="/main/index_admin.htm"/>">HOME
								<span class="sr-only">(current)</span>
								</a>
						
							
							
					
				 <a class="nav-item nav-link" href="<c:url value="/main/tv_show.htm"/>">TV SHOWS</a> <a
					class="nav-item nav-link" href="<c:url value="/main/phim_le.htm"/>">FEATURES</a>
					<!-- Dropdown theo tên người dùng để update -->
										<div class="dropdown">
											<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
												      Hi ${username} 
												  </button>
											<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
												<a class="dropdown-item" href="
													<c:url value="/main/show_information_user/${username}.htm"/>">Update
												</a>
												
												<a class="dropdown-item" href="<c:url value="/main/index.htm"/>">Sign Out</a>
											</div>
										</div>
										<!-- Hết Dropdown  -->
			</div>
		</div>
	</nav>
  		<!-- Form request -->
    	<div class="container-request-movie">
    	${message}
    		<h3 style="text-align: center">Add movie</h3>	
    			<form:form action="/DoAn/main/insert_movie.htm" method="POST" modelAttribute="movie" enctype="multipart/form-data">
    					
  						<!-- Movie's Name -->
    				  <div class="form-group">
    					<label for="exampleInputEmail1">Movie's Name</label>
    						
    						<form:input path="movie_name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Input movie's name"/>
    							<form:errors path="movie_name"></form:errors>
  					</div>
  						<!-- Category -->
					  <div class="form-group">
						<label>Category</label>
								<form:select path="category.category_id" items="${categories}" itemValue="category_id" itemLabel="category_name" class="form-control border border-primary"></form:select>
						</div>
						
  						<!-- Movie's avatar -->
  					 <div class="form-group">
  					<label for="exampleFormControlTextarea1">Movie's Avatar</label>
  						<input type="file" name="avatar">
  						<form:errors path="movie_avatar_image"></form:errors>
  					</div>  
  						
  					
  						<!-- Publish Year -->
    				  <div class="form-group">
    					<label for="exampleInputEmail1">Publish Year</label>
    						<form:input path="publish_year" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Input movie's year"/>
    							<form:errors path="publish_year"></form:errors>
  					</div> 
  					<!-- Introduction -->
					  <div class="form-group">
    					<label for="exampleFormControlTextarea1">Introduction</label>
    						<form:textarea path="introduction" class="form-control" id="exampleFormControlTextarea1" rows="3"/>
    						<form:errors path="introduction"></form:errors>
  					</div>  
  					<!-- Genre -->
					  <div class="form-group">
						<label>Genre</label>
								<form:select path="genre.genre_id" items="${genres}" itemValue="genre_id" itemLabel="genre_name" class="form-control border border-primary"></form:select>
						</div>
					<!-- Slider Image 1 -->
					<div class="form-group">
  					<label for="exampleFormControlTextarea1">Movie's Slider Image 1</label>
  						<input type="file" name="slider_image"/>
  						<form:errors path="slider_image_1"></form:errors>
  					</div>
  					 <div class="form-group">
    					<label for="exampleInputEmail1">Trailer Link </label>
    						
    						<form:input path="trailer_link" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Input movie's link"/>
    							<form:errors path="trailer_link"></form:errors>
  					</div>
  					
  					<button type="submit" class="btn btn-primary">Insert!</button>
  								
    			</form:form>
    		
    	</div>
  </body>
</html>