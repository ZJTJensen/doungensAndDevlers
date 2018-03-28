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
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>

			<form method="POST" action="/login">
				<p>
					<label for="email">Username/Email</label>
					<input id="email" name="email"/>
					
				</p>
				<p>
					<label for="password">Password</label>
					<input type="password" id="password" name="password"/>
				</p>
				<input type="submit" value="Login!"/>
			</form>


		<form:form method="POST" action="/register" modelAttribute="user">
        <p>
            <form:label path="username">Username:
				<form:errors path="username"></form:errors>
			</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="email">Email:
			<form:errors path="Email"></form:errors>
			</form:label>
            <form:input path="email"/>
		</p>
		<p>
		<form:select path="admin">
			<form:option value="3" label="Player"/>
			<form:option value="2" label="Game MAster"/>
			
		</form:select>
		</p>

        <p>
			<form:label path="password">Password:
				<form:errors path="password"></form:errors>
			</form:label>
			
            <form:password path="password"/>
		</p>
		
        <p>
            <form:label path="confirm">Password Confirmation:</form:label>
			<form:password path="confirm"/>
			<form:errors path="confirm"></form:errors>
		</p>
		<p><form:errors path="user.*"/></p>
        <input type="submit" value="Register!"/>
    </form:form>
	</body>
</html>