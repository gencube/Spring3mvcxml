<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<% pageContext.setAttribute( "name", "user"); %>
<h2>Hello ${name} from JSTL!</h2>
<h2>List: <A href='./api/persons/init'>Init Persons</A></h2>
<h2>List: <A href='./api/persons'>List Persons</A></h2>
</body>
</html>
