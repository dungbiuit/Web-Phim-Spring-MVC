<%@page pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en" dir="ltr">
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
			<meta charset="utf-8">
				<title>Register</title>
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
									<a class="nav-item nav-link" href="index.htm">HOME
										<span class="sr-only">(current)</span>
									</a>
									
									<a class="nav-item nav-link" href="login.htm">LOGIN</a>
								</div>
							</div>
						</nav>
						<!-- Form -->
		
	
						<div class="container-fluid">
							<img alt="background-register" src="/DoAn/resources/images/Login/login_background.JPG" id="login-register-background">
							<form:form action="register.htm" modelAttribute="user" method="POST" id="login-form" class="border border-primary">
								<!-- Class này để form có border -->
								<div class="form-group">
									<h2 style="text-align: center;">Let's get started.</h2>
									<label for="exampleInputEmail1">Email</label>
									<form:input path="username" class="form-control border border-primary" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Input Email"/>
									<form:errors path="username"/>
									
								</div>
								
								<div class="form-group">
									<label for="exampleInputPassword1">Full Name</label>
									<form:input path="name_of_user" type="text" class="form-control border border-primary" id="exampleInputName1" placeholder="Input Full Name"/>
									<form:errors path="name_of_user"/>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label>
									<form:input path="password" type="password" class="form-control border border-primary" id="exampleInputPassword1" placeholder="Input Password"/>
									<form:errors path="password"/>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Confirm Password </label>
									<input name="retype_password" type="password" class="form-control border border-primary" id="exampleInputPassword1" placeholder="Input Password"/>
									
								</div>
								<!-- Check loại user -->
								<div class="form-group">
									<label>Type of User</label>
									<form:select path="user_type.type_id" items="${user_types}" itemValue="type_id" itemLabel="type_name" class="form-control border border-primary"></form:select>
								</div>
								<div class="form-group form-check">
									<input type="checkbox" class="form-check-input" id="exampleCheck1">
										<label class="form-check-label" for="exampleCheck1">When you check this box, it's also means that you have agreed with our terms.</label>
									</div>
									<div class="form-group">
									<button type="submit" class="btn btn-primary btn-dang-ky">Register</button>
									</div>
								</form:form>
								<!-- Kết thúc Class này để form có border -->
							</div>
							
						</body>
					</html>