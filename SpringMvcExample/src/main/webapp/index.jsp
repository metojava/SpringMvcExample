<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://localhost:8080<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="http://localhost:8080<%=request.getContextPath()%>/resources/css/jquery.mobile-1.4.5.min.css" />
<script
	src="http://localhost:8080<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
<script
	src="http://localhost:8080<%=request.getContextPath()%>/resources/js/jquery.mobile-1.4.5.min.js"></script>

<script
	src="http://localhost:8080<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://localhost:8080<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://localhost:8080<%=request.getContextPath()%>/resources/css/carousel.css" />

<title>Our Company</title>
</head>
<body>


	<div id="main">

		<div data-role="header" data-theme="b" role="banner"
			class="ui-header ui-bar-b">
			<h1 class="ui-title" role="heading" aria-level="1">Our Company</h1>
			for logging : admin/admin | someuser/userpass

			<div data-demo-html="true">
				<div data-role="footer" role="contentinfo"
					class="ui-footer ui-bar-inherit">
					<div data-role="navbar" data-iconpos="left" class="ui-navbar"
						role="navigation">
						<ul class="ui-grid-b">
							<li class="ui-block-a"><a
								href="${pageContext.request.contextPath}/account/list"
								data-icon="grid"
								class="ui-link ui-btn ui-icon-grid ui-btn-icon-left">Accounts</a></li>
							<li class="ui-block-b"><a
								href="${pageContext.request.contextPath}/customer/list"
								data-icon="star"
								class="ui-link ui-btn ui-icon-star ui-btn-icon-left">Customers</a></li>
							<li class="ui-block-c"><a
								href="${pageContext.request.contextPath}/employee/list"
								data-icon="gear"
								class="ui-link ui-btn ui-icon-gear ui-btn-icon-left">Employees</a></li>
						</ul>
					</div>
					<!-- /navbar -->
				</div>
				<!-- /footer -->
			</div>


			<!-- Carousel -->

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="first-slide"
							src="http://localhost:8080<%=request.getContextPath()%>/resources/img/adult-business-chairs-1181304.jpg"
							alt="First slide">
						<div class="container">
							<div class="carousel-caption text-left">
								<h1>We Are Together</h1>
								<p>joining with us you get active team on your side</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Contact
										Us</a>
								</p>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<img class="second-slide"
							src="http://localhost:8080<%=request.getContextPath()%>/resources/img/achievement-agreement-arms-1068523.jpg"
							alt="Second slide">
						<div class="container">
							<div class="carousel-caption">
								<h1>Solving Together</h1>
								<p>solving problems together gives strength and empowers</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Learn
										more</a>
								</p>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<img class="third-slide"
							src="http://localhost:8080<%=request.getContextPath()%>/resources/img/20-fenchurch-street-architecture-business-34092.jpg"
							alt="Third slide">
						<div class="container">
							<div class="carousel-caption text-right">
								<h1>Be With Us</h1>
								<p>discover power of relations, be active</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Contact
										Us</a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#myCarousel" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#myCarousel" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>

			<!-- Carousel end -->



		</div>

	</div>

</body>
</html>
