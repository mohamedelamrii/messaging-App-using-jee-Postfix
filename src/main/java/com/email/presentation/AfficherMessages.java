package com.email.presentation;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;  

import javax.mail.*;  

/**
 * Servlet implementation class AfficherMessages
 */
@WebServlet("/AfficherMessages")
public class AfficherMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherMessages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email="";
	    String pwd="";
	    HttpSession session = request.getSession();
	if (session.getAttribute("email") != null){
		email = session.getAttribute("email").toString();
		pwd = session.getAttribute("pwd").toString();
		
		
		
	}else{
		response.sendRedirect("loginForm.jsp");
	}
		
		
		
		
		
		
		
		String pop3Host="192.168.112.142";
		
		Properties props = new Properties();
		props.put("mail.pop3.host", pop3Host);
		props.put("mail.pop3.port", "110");
		props.put("mail.pop3.starttls.enable", "true");
		props.put("mail.store.protocol", "pop3");
	 
	Session session2 = Session.getInstance(props);	
	try {  
		 
		String storeType = "pop3";
		Store mailStore = session2.getStore(storeType);
		mailStore.connect(pop3Host, email, pwd);
	 
		Folder folder = mailStore.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
	 
		Message[] emailMessages = folder.getMessages();
	    request.setAttribute("emailMessages", emailMessages);
		this.getServletContext().getRequestDispatcher("/inbox.jsp").forward(request, response);
     	
	/*	response.setContentType("text/html");
		PrintWriter printWriter =response.getWriter();
		 printWriter.print("Total Message - " 
				+ emailMessages.length);
	    
	   	 

	   	     printWriter.print(" <br> Affichage des messages        !" + "- <br>");
 
	   
	  for (int i = 0; i < emailMessages.length; i++) {
       Message message = emailMessages[i];
       Address[] toAddress = 
	   message.getRecipients(Message.RecipientType.TO);
	    
	   printWriter.print("Email " + (i+1) + "- <br>");  
	   printWriter.print("Subject - " + message.getSubject()+ "- <br>");  
	   printWriter.print("From - " + message.getFrom()[0]+ "- <br>"); 
	   
	  

  	   
	 
  	   printWriter.print("To - "); 
	   for(int j = 0; j < toAddress.length; j++){
		   printWriter.print(toAddress[j].toString()+ "- <br>");
	   }
	   printWriter.print("Text - " + 
			   message.getContent().toString()+ "- <br>");  
	  }
	 
	  folder.close(false);
	  mailStore.close();
	*/} catch (Exception e) {
		e.printStackTrace();
	    System.err.println("Error in receiving email.");
	    }        
	}
	 
		
		
	}

	


