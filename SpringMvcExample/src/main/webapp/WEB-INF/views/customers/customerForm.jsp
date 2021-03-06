<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Customer's Form</title>
</head>
<body>
	<div id="main">


		<div data-role="header" data-theme="b" role="banner"
			class="ui-header ui-bar-b">
			<h1 class="ui-title" role="heading" aria-level="1">Create/Edit
				Customer</h1>


			<div data-demo-html="true">
				<div data-role="footer" role="contentinfo"
					class="ui-footer ui-bar-inherit">
					<div data-role="navbar" data-iconpos="left" class="ui-navbar"
						role="navigation">
						<ul class="ui-grid-b">
							<li class="ui-block-a"><a
								href="${pageContext.request.contextPath}/account/list"
								data-icon="grid"
								class=" ui-link ui-btn ui-icon-grid ui-btn-icon-left">Accounts</a></li>
							<li class="ui-block-b"><a
								href="${pageContext.request.contextPath}/customer/list"
								data-icon="star"
								class="ui-btn-active ui-link ui-btn ui-icon-star ui-btn-icon-left">Customers</a></li>
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

		</div>

		<div id="custForm">
			<form:form
				action="${pageContext.request.contextPath}/customer/saveCustomer"
				method="POST" modelAttribute="customer">

				<table>
					<form:hidden path="cid" />
					<form:hidden path="accno.accno" />
					<tr>
						<td>Customer's Name:</td>
						<td><form:input path="cname" /></td>
						<td><form:errors path="cname" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Contact #:</td>
						<td><form:input path="contactno" /></td>
						<td><form:errors path="contactno" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Birth Date:</td>
						<td><form:input path="birthdate" type="date" data-role="date" /></td>
						<td><form:errors path="birthdate" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td><form:input path="emailid" /></td>
						<td><form:errors path="emailid" cssClass="error" /></td>
					</tr>
					<tr>
						<td><input data-role="button" type="submit" value="Save"></td>
					</tr>
				</table>

			</form:form>

		</div>

		<div data-role="footer" style="text-align: center; top: 20px">Company
			&copy; All Rights Reserved</div>

	</div>
</body>
</html>