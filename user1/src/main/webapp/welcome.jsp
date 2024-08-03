<%@page import="models.student"%>
<%@page import="java.util.List"%>
<%@page import="dbconnections.studentdb"%>
<%@page import="service.studentservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Branch</th>
      <th scope="col">Email</th>
      <th scope="col">phoneno</th>
      <th scope="col">ACTIONS</th>
    </tr>
  </thead>
  <tbody>
  <%
  studentservice std = new studentservice(studentdb.getconnection());
  List<student> stu = std.fetchall();
  for(student st:stu){
  %>
    <tr>
      <th scope="row"><%=st.getId() %></th>
      <td><%=st.getName() %></td>
      <td><%=st.getBranch() %></td>
      <td><%=st.getEmail() %></td>
      <td><%=st.getPhoneno() %></td>
      <td>
      <button class="btn btn=outline-warning">update</button>
      <a href="delete?id=<%=st.getId()%>">
      <button class="btn btn=outline-danger">delete</button>
      </a>
      </td>
    </tr>
    <%} %>
  </tbody>
</table>
</body>
</html>