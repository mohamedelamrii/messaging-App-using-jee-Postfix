<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body >
<%@ include file = "header.jsp" %>



<div style = "text-align : center;">
 <h1>Hello <%=email.split("@")[0]%> </h1>
 <h2>Welcome To Mail Application  </h2>
 
 </div>

</body>
</html>