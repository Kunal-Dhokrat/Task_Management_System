<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration or Sign Up form in HTML CSS | CodingLab</title>
<link rel="stylesheet" href="css/registerstyle.css">
</head>
<body>
	<div class="text_design">
		<h1>Task Management System</h1>
	</div>
	<div class="wrapper">
		<h2>Registration</h2>
		<form action="register" method="Post">
			<div class="input-box">
				<input type="text" placeholder="Enter your name" name="name"
					required>
			</div>
			<div class="input-box">
				<input type="text" placeholder="Enter your email" name="email"
					required>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Create password" name="pass"
					required>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Confirm password" name="pass1"
					required>
			</div>
			<div class="policy">
				<input type="checkbox">
				<h3>I accept all terms & condition</h3>
			</div>
			<div class="input-box button">
				<input type="Submit" value="Register Now">
			</div>
			<div class="text">
				<h3>
					Already have an account? <a href="login">Login now</a>
				</h3>
			</div>
		</form>
	</div>
</body>
</html>