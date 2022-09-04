<%@page import="javax.mail.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inbox</title>
</head>
<body>
<%
    Message[] emailMessages= (Message[]) request.getAttribute("emailMessages");
	%>
<%@include file ="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
             
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade active show" id="inbox" aria-labelledby="inbox-tab" role="tabpanel">
                        <div>
                            <div class="row p-4 no-gutters align-items-center">
                                <div class="col-sm-12 col-md-6">
                                    <h3 class="font-light mb-0"><i class="ti-email mr-2"></i>Total Emails : <%= emailMessages.length %></h3>
                                </div>
                               









<div class="table-responsive">
<table class="table email-table no-wrap table-hover v-middle mb-0 font-14">
	                                 <tr>
                                            <!-- label -->
                                            <td class="pl-3">
                                               
                                            </td>
                                            <!-- star -->
                                            <td><i class="fa fa-star text-warning"></i></td>
                                            <td>
                                                <span class="mb-0 text-muted">From :</span>
                                            </td>
                                            <!-- Message -->
                                            <td>
                                               
                                                    <span class="">Subject:</span>
                                                    
                                                </a>
                                            </td>
                                            <td>
                                                <a class="link" href="javascript: void(0)">
                                                   
                                                    <span class="text-dark">Message:</span>
                                                </a>
                                            </td>
                                            <!-- Attachment -->
                                            
                                            <!-- Time -->
                                            <td class="text-muted">Date :</td>
                                            <td class="text-muted"></td>
                                        </tr>
		<% 
		for (int i = 0; i < emailMessages.length; i++) {
			   Message message = emailMessages[i];
			   %>

                                    <tbody>
                                        <!-- row -->
                                        <tr>
                                            <!-- label -->
                                            <td class="pl-3">
                                               
                                            </td>
                                            <!-- star -->
                                            <td><i class="fa fa-star text-warning"></i></td>
                                            <td>
                                                <span class="mb-0 text-muted"><%=message.getFrom()[0] %></span>
                                            </td>
                                            <!-- Message -->
                                            <td>
                                                <a class="link" href="javascript: void(0)">
                                                    <span class="badge badge-pill text-white font-medium badge-danger mr-2"><%= message.getSubject()%></span>
                                                    
                                                </a>
                                            </td>
                                            <td>
                                           
                                                <a class="link" href=" AfficherMessage?num=<%=message.getMessageNumber() %>">
                                                   
                                                    <span class="text-dark"><%= message.getContent().toString().substring(0,6) + "  ...." %></span>
                                                </a>
                                            </td>
                                            <!-- Attachment -->
                                            
                                            <!-- Time -->
                                            <td class="text-muted"><%= message.getReceivedDate()%></td>
                                            <td>
			<a href="reply.jsp?sub=<%=message.getSubject() %>&from=<%=message.getFrom()[0] %>" class="btn btn-success">reply</a>
			<a href="DeleteMail?num=<%=message.getMessageNumber() %>" class="btn btn-danger">Supprimer</a>
		</td>
                                        </tr>
                                      </tbody>
                                      <%                                
		                               }
		                               %>
                                      </table>
                                      </div>
                                      
       
                                      

</body>
</html>