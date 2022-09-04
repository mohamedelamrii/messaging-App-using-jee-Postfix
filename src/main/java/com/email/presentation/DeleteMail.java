package com.email.presentation;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.imap.protocol.FLAGS;
 
  

/**
 * Servlet implementation class DeleteMail
 */
@WebServlet("/DeleteMail")
public class DeleteMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMail() {
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
	     
		
		
		
		
		 
		 String num= request.getParameter("num");
		 String pop3Host= "192.168.112.142";
		 
		  
		 Properties props = new Properties();
			props.put("mail.pop3.host", pop3Host);
		 
			Session session2 = Session.getInstance(props);
		 
			try {
			 Store store = session2.getStore("pop3");
			 store.connect(pop3Host, email, pwd);
		 
			 Folder folder = store.getFolder("INBOX");
			 folder.open(Folder.READ_WRITE);
		 
		         Message[] emailMessages = folder.getMessages();
		         
		 
		       
		       String emailNo = num;
		       emailMessages[Integer.parseInt(emailNo) - 1].
		       setFlag(Flags.Flag.DELETED, true);
		 
		       folder.close(true);	       
		       store.close();
		       response.setContentType("text/html");
		       PrintWriter out = response.getWriter() ;
				out.println("<script type=\"text/javascript\">");
	            out.println("alert(' email deleted successfully....');");
	            out.println("window.location.href = 'AfficherMessages';");
	            
	            out.println("</script>");
				
				

		   	    
		       
		      
			} catch (Exception e) {
		        e.printStackTrace();
		        System.err.println("Error in deleting email.");
		    }           
		}
	

}

