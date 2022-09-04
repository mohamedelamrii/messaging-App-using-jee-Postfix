<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.mail.Message"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reply</title>
</head>
<body>
<%@include file ="header.jsp"%>
 <%
           
            String sub = request.getParameter("sub");
            String from = request.getParameter("from");
            
            %>

<form action="ReplyServlet" method="post">
                <table class="table table-hover">
                   
                    <tr>
                        <td>Email</td>
                        <td><input type="email" required=""  name="email" class="form-control" value="<%=from %>"></td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td><input type="text" required=""  name="subject" class="form-control" value="<%=sub %>"></td>
                    </tr>
                    <tr>
                        <td>Message</td>
                        <td><textarea name="message" required="" rows="5" cols="100" placeholder="Your Message"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="submit" class="btn btn-primary" value="Send"></td>
                    </tr>
                </table>
            </form>


</body>
</html>