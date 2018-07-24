<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
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

<script>
	
</script>

<title>Account Create/Edit</title>
</head>
<body>


	<div id="main">


		<div data-role="header" data-theme="b" role="banner"
			class="ui-header ui-bar-b">
			<h1 class="ui-title" role="heading" aria-level="1">Edit Account</h1>


			<div data-demo-html="true">
				<div data-role="footer" role="contentinfo"
					class="ui-footer ui-bar-inherit">
					<div data-role="navbar" data-iconpos="left" class="ui-navbar"
						role="navigation">
						<ul class="ui-grid-b">
							<li class="ui-block-a"><a
								href="${pageContext.request.contextPath}/account/list"
								data-icon="grid"
								class="ui-btn-active ui-link ui-btn ui-icon-grid ui-btn-icon-left">Accounts</a></li>
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

		</div>
		
		<div id="accForm">
		<form:form
			action="${pageContext.request.contextPath}/account/saveAccount"
			method="POST" modelAttribute="account">

			<table>
				<form:hidden path="accno" />
				<tr>
					<td>Account Type:</td>
					<td><form:input path="acctype" /></td>
					<td><form:errors path="acctype" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Account Opening Date #:</td>
					<td><form:input path="accopeningdt" type="date"
							data-role="date" /></td>
					<td><form:errors path="accopeningdt" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Current Balance:</td>
					<td><form:input path="currbalance" /></td>
					<td><form:errors path="currbalance" cssClass="error" /></td>
				</tr>

			</table>

			<div data-role="collapsible">
				<legend>Customer</legend>
				<form:hidden path="customerList[0].cid" />
				<form:input path="customerList[0].cname" placeholder="Name" />
				<form:errors path="customerList[0].cname" cssClass="error" />
				<form:input path="customerList[0].contactno" placeholder="Contact #"
					pattern="[0-9]{9}" title="0-9 numbers only , must be 9 digits" />
				<form:errors path="customerList[0].contactno" cssClass="error" />
				<form:input path="customerList[0].birthdate" type="date"
					data-role="date" />
				<form:errors path="customerList[0].birthdate" cssClass="error" />
				<form:input path="customerList[0].emailid" placeholder="E-Mail" />
				<form:errors path="customerList[0].emailid" cssClass="error" />



			</div>

			<input type="submit" value="Save">

		</form:form>

</div>

		<div data-role="footer" style="text-align: center; top: 20px">Company
			&copy; All Rights Reserved</div>
	</div>

</body>
</html>