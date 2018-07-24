<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>
</head>
<body>

	<div id="main">

		<div data-role="header" data-theme="b" role="banner"
			class="ui-header ui-bar-b">
			<h1 class="ui-title" role="heading" aria-level="1">Customers
				List</h1>


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

		<table data-role="table" id="accounts-table" data-mode="reflow"
			class="ui-responsive">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Contact #</th>
					<th>Email Id</th>
					<th>Birth Date</th>
					<th>action</th>
				</tr>
			</thead>
			<c:forEach var="customer" items="${customers}" varStatus="rowNum">
				<tr class="${rowNum.index % 2 == 0 ? 'even' : 'odd'}">
					<td><c:out value="${customer.cid}" /></td>
					<td><c:out value="${customer.cname}" /></td>
					<td><c:out value="${customer.contactno}" /></td>
					<td><c:out value="${customer.birthdate}" /></td>
					<td><c:out value="${customer.emailid}" /></td>
					<td>

						<div data-role="controlgroup" data-type="horizontal"
							data-mini="true"
							class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all ui-mini">
							<div class="ui-controlgroup-controls ">

								<a
									href="${pageContext.request.contextPath}/customer/editCustomer?cid=${customer.cid}"
									class="ui-btn ui-corner-all ui-icon-edit ui-btn-icon-left">Edit</a>
								<a
									href="${pageContext.request.contextPath}/customer/deleteCustomer?cid=${customer.cid}"
									class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-right ui-last-child">Delete</a>

							</div>
						</div>
				</tr>
			</c:forEach>
		</table>
		<a data-role="button"
			href="${pageContext.request.contextPath}/customer/addCustomer">Add
			New Customer</a>

		<div data-role="footer" style="text-align: center; top: 20px">Company
			&copy; All Rights Reserved</div>

	</div>
</body>
</html>