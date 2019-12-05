<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="utf-8">
<title>Detail Page</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
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
					<c:choose>
					
						<c:when test="${user.administrator==true }">
							<a class="nav-item nav-link" href="<c:url value="/main/index_admin.htm"/>">HOME
								<span class="sr-only">(current)</span>
								</a>
						</c:when>
						<c:otherwise>
							<c:choose>
							
							<c:when test="${user.user_type.type_id == 't01' }">
								<a class="nav-item nav-link" href="<c:url value="/main/index_standard.htm"/>">HOME
									<span class="sr-only">(current)</span>
									</a>
							</c:when>
							
								<c:otherwise>
									<a class="nav-item nav-link" href="<c:url value="/main/index_vip.htm"/>">HOME
									<span class="sr-only">(current)</span>
									</a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					
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
				<div class="container-detail-page">
				<!-- Image + Play -->
						<img alt="" src="${movie.slider_image_1}" id="slider-image-detail-page">
				<!-- Avatar + Information -->
					<div class="container-avatar-and-information">
						<!-- Play In Full HD or 2K -->
						<iframe width="100%" height="300px" src="${movie.trailer_link}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				<!-- Avatar -->
					<img alt="" src="${movie.movie_avatar_image}" id="avatar-movie-detail-page">
				<!-- Information -->
					<!-- Movie name -->
					<div class="show-name-on-right-detail-page">
					${movie.movie_name}
						<!-- Movie Category &Genre &year -->
						<div class="category-genre-year-movie-detail-page">
							${movie.category.category_name}
							${movie.genre.genre_name}
							${movie.publish_year}
						<!-- Introduction -->
							<div class="introduction-detail-page">
							${movie.introduction}
						</div>
						</div>
						  
					</div>
						
					</div>
					<!-- References -->
					<div class="container-references">
						<p id="more-like-this">More like this </p>
						<c:forEach items="${list_movies}" var="l"  >
							
							<c:if test="${l.movie_id != movie.movie_id}">
							
									<a href="<c:url value="/main/detail_page/${l.movie_id}.htm"/>"><img alt="" src="${l.slider_image_1}" class="more-like-this-image"></a>
									
				
							</c:if>
						
						</c:forEach>
					</div>
					<!-- Comments Section -->
					<div class="container-comment">
						<p id="comment-header-detail-page">Comments</p>
						${message}
						<form:form action="/DoAn/main/detail_page/${movie.movie_id}.htm" method="POST" modelAttribute="comment">
							<div class="media">
							  <img src="${user.image_avatar}" class="mr-3" alt="...">
							  <div class="media-body">
							    <h5 class="mt-0">${user.username}</h5>
							   
							   <form:textarea path="content" rows="3" placeholder="Your comment goes here!"/>
							 	<form:errors path="content"></form:errors>
							   <button type="submit" class="btn btn-info">Send</button>
							   
							   
							  </div>
							</div>
						</form:form>
						<!-- List Comments-->
							<c:forEach items="${list_comments}" var="l">
									<div class="media">
							  <img src="${l.user.image_avatar}" class="mr-3" alt="...">
							  <div class="media-body">
							    <h5 class="mt-0">${l.user.username}</h5>
							   <p style="font-size: 1.5vw;">${l.content}</p>
							   
							  </div>
							</div>
							</c:forEach>
					</div>
				</div>
				
	<!-- Footer -->
															<div class="container-fluid container-footer">
																<h2>Contact us </h2>
						
																<p>Phone:123456789 </p>
																<p>Email:abc@gmail.com</p>
																<p>Address:195 Ham Tu Street, District 5, Ho Chi Minh City</p>
																<p>Copyright @2019:All Right Reserve</p>
															</div>
</body>
</html>