<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.mail.Message"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    Message[] emailMessages= (Message[]) request.getAttribute("emailMessages");
    int num = Integer.parseInt(request.getParameter("num") );
    
	%>
 <%@ include file = "header.jsp" %>
        <div class="">
            <div class="">
                <h1> </h1>
             
            </div>
            <br>
           
            
            <form action="SendEmail" method="post">
            <% 
		for (int i = 0; i < emailMessages.length; i++) {
			   Message message = emailMessages[i];
			  int n= message.getMessageNumber();
			   if (n == num ){
			   %>
            
                <table class="table table-hover">
                   
                    <tr>
                        <td>From:</td>
                        <td><input type="email" readonly  name="email" class="form-control" value="<%=message.getFrom()[0] %> "></td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td><input type="text" readonly  name="subject" class="form-control" value="<%= message.getSubject()%>"></td>
                    </tr>
                    <tr>
                        <td>Message:</td>
                        <td><textarea name="message" readonly required="" rows="5" cols="100" placeholder="Your Message" class="form-control"><%= message.getContent().toString()%></textarea></td>
                        
                    </tr>
                   
                     <%                                
                               
			   }
			   }
		                               %>
                </table>
            </form>

        </div>

</body>
</html>