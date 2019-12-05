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
    <title>Feedback</title>
    <link href="
					<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
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
										<a class="nav-item nav-link" href="
											<c:url value="/main/index.htm"/>">HOME
										
											
											<span class="sr-only">(current)</span>
										</a>
										<a class="nav-item nav-link" href="
											<c:url value="/main/login.htm"/>">SIGN IN</a>
										<!-- Hết Dropdown  -->
									</div>
								</div>
							</nav>
  <!-- Thanks you  -->
   <div class="container-fluid container-feedback-page">
		<img src="/DoAn/resources/images/feedback/feedback_background.jpg" id="account_background_index">
		<div class="jumbotron">
  <h1 class="display-4">Our sincere thanks !</h1>
  <p class="lead">Thank you for choosing our website as your streaming movies website. Our teams are working harder everyday to satisfy your movie experience.</p>
  <hr class="my-4">
  
</div>
	</div>	
	<!-- Form feedback -->		
		<div class="container-fluid">
				<form action="main/feedback.htm" method="POST" id="login-form" class="border border-primary form-feedback">
								<!-- Class này để form có border -->
								 <div class="form-group">
								${message}
									<h2 style="text-align: center;"></h2>
									<label for="exampleInputEmail1">Email</label>
									<p><input name="email" class="form-control border border-primary" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Your Email"/></p>
									${email_error}
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Name</label>
									<p><input name="name" type="text" class="form-control border border-primary" id="exampleInputEmail1" placeholder="Your Name"/></p>
									
									${name_error}
								</div>
								<div class="form-group">
    <label for="exampleFormControlTextarea1">Your Feedback</label>
    <p><textarea name="feedback" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Your Feedback goes here"></textarea></p>
  	${feedback_error}
  </div>
								
									<button type="submit" class="btn btn-primary btn-login">Send</button>
									
								</form>
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