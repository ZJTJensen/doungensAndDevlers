<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<a href="/logout">logout</a>
		<h1>Welcome ${user.username}.</h1>


		<div id = "CharBuilder">
			<form:form method="POST" action="/buildChar" madelAttribute="Charecter">
				<form:label path="name">name:
					<form:errors path="name"></form:errors>
				</form:label>
				<form:input path="name"/>

				<!-- Stat block -->
				<form:label path="level">level:
					<form:errors path="level"></form:errors>
				</form:label>
				<form:input value ="1" id="level" min ="1" max="100" path="level" type="number"/>
				<p>Total Stat Points: <span id="points"></span></p>


				<input type="submit" value="Build!"/>
			</form:form>
			

		</div>
	</body>
</html>