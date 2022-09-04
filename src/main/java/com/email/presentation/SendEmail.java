package com.email.presentation;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(name = "SendEmail", urlPatterns = {"/SendEmail"})
public class SendEmail extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email="";
	    String pwd="";
	    HttpSession session = request.getSession();
	if (session.getAttribute("email") != null){
		email = session.getAttribute("email").toString();
		pwd = session.getAttribute("pwd").toString();
		
		
		
	}else{
		response.sendRedirect("loginForm.jsp");
	}
    	
    	
    	
    	String email2 = request.getParameter("email");
		String subject= request.getParameter("subject");
		String message1 = request.getParameter("message");
	   
	    
	   
   	String to = email2;
   	 String from = email;
   	 final String username = email; // somemail does the same
   	 final String password = pwd;

   	 String host = "192.168.112.142";

   	 Properties props = new Properties();
   	 props.put("mail.smtp.auth", "true");
   	 props.put("mail.smtp.starttls.enable","true"); // same output with mail.smtp.ssl.enable
   	 props.put("mail.smtp.host", host);
   	 props.put("mail.smtp.port", 25);
   	 props.put("mail.smtp.user", username);
   	 props.put("mail.smtp.password", password);

   	 Session session2 = Session.getInstance(props, new javax.mail.Authenticator() {
   	     protected PasswordAuthentication getPasswordAuthentication() {
   	     return new PasswordAuthentication(username, password);
   	     }
   	 });

   	 session2.setDebug(true);
   	 try {
   		 System.out.println("sending ......");
   		 Message message = new MimeMessage(session2);

   	     message.setFrom(new InternetAddress(from));

   	     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

   	     message.setSubject(subject);

   	     message.setText(message1);
   	     Transport.send(message);
   	  response.setContentType("text/html");
   	 response.setContentType("text/html");
     PrintWriter out = response.getWriter() ;
		out.println("<script type=\"text/javascript\">");
      out.println("alert(' Sent message successfully....');");
      out.println("window.location.href = 'compose.jsp';");
      out.println("</script>");
   	   

   	 } catch (MessagingException e) {
   	     throw new RuntimeException(e);
   	 }
   }
}