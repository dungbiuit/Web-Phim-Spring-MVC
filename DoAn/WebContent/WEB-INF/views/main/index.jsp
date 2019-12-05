<%@page pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
				<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
				<meta charset="utf-8">
					<title>Index</title>
					<link href=" 
						<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
					</head>
					<body>
						<!-- Menu -->
						<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
							
								<p class="navbar-text">Whenever, wherever</p>
								<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
									<div class="navbar-nav ml-auto mx-auto ">
										<a class="nav-item nav-link" href="index.htm">HOME
										
											<span class="sr-only">(current)</span>
										</a>
									
										<a class="nav-item nav-link" href="login.htm">SIGN IN</a>
									</div>
								</div>
							</nav>
							<!-- Welcome image with text -->
							<div class="container-fluid container_hello_guest">
								<img src="/DoAn/resources/images/index/hello_image.JPG" id="hello_guest_index">
									<h3 class="movie_quote_index">"Oh how Shakespeare would have loved cinema!"</h3>
									<h4 class="movie_quote_author">― Derek Jarman, Dancing Ledge</h4>
								</div>
								<!-- Introduction -->
								<div class="container-fluid container-introduction">
									<img alt="admin_manager" src="/DoAn/resources/images/index/admin_avatar.png" id="admin_avatar_round_image">
										<p id="admin_name_index">CEO Nguyễn Trí Dũng</p>
										<p id="admin_quote_index">"Watching movie is ours favorite hobby.</p>
										<p id="admin_quote_index">And now we want to share it with you!" </p>
										<div class="text-center">
											<!-- About us Button -->
											
										</div>
									</div>
									<div class="container-fluid container-account-present">
										<img src="/DoAn/resources/images/account_background_index.JPG" id="account_background_index">
											<!-- Account thường  -->
											<div class="card standard_information-show-left">
												<img class="card-img-top" src="/DoAn/resources/images/price1.jpg" >
													<div class="card-body">
														<h5 class="card-title">Standard</h5>
														<p class="card-text">Watch in FullHD Resolution</p>
														<p class="card-text"> Broadcast 2 devices at the same time </p>
														<p class="card-text">Cannot suggest movie to admin</p>
														<!-- Price -->
														<div class="container-price">
															<br>
																<p class="card-text " style="font-size:80%; ">50.000đ</p>
															</div>
														</div>
													</div>
													<!-- Hết Account thường -->
													<!-- Acount VIP -->
													<div class="card standard_information-show-right">
														<img class="card-img-top" src="/DoAn/resources/images/price1.jpg" >
															<div class="card-body">
																<h5 class="card-title">VIP</h5>
																<p class="card-text">Watch in FullHD Resolution</p>
																<p class="card-text"> Broadcast 4 devices at the same time </p>
																<p class="card-text"> Can suggest movie to admin</p>
																<!-- Price -->
																<div class="container-price">
																	<br>
																		<p class="card-text " style="font-size:80%; ">80.000đ</p>
																	</div>
																</div>
															</div>
															<!-- Hết Account VIP -->
															<p id="check-out-quote">Come check out now !</p>
															<a href="<c:url value="/main/login.htm"/>"><button type="button" class="btn btn-primary btn-lg btn-sign-in">Sign In</button></a>
														</div>
														
														<hr>
														<!-- Feedback -->
															<div class="container-fluid container-feedback">
																<img alt="" src="/DoAn/resources/images/feedback/feedback_background_index.jpg" id="feedback-left-picture">
																	<div id="text-right-feedback">
																<h3 id="feedback-title">Feedback</h3>
																<p id="feedback-index">Your contribution will make our web better</p>
																<a href="<c:url value="/main/feedback.htm"/>"><button type="button" class="btn btn-primary btn-feedback">Write Feedback</button></a>
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