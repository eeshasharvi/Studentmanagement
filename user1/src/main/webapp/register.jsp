<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
<form action="register" method="post">

<input type="text" placeholder="Enter name" class="form-control" name="name">
<input type="text" placeholder="Enter branch" class="form-control" name="branch">
<input type="email" placeholder="Enter email" class="form-control" name="email">
<input type="number" placeholder="Enter phoneno" class="form-control" name="phoneno">
<button type="submit">register</button>
</form>
</body>
</html>