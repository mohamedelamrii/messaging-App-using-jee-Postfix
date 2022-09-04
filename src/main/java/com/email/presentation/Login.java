package com.email.presentation;
import java.io.IOException;

import java.io.PrintWriter;

import com.email.dao.Singleton;
import com.email.entities.User;
import com.email.metier.IUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		 
		
			try {
				Connection conn = Singleton.getInstance().getConnection();
				
				
				PreparedStatement pst;
				pst = conn.prepareStatement("SELECT * FROM virtual_users WHERE email=? AND password=?");
			
			pst.setString(1, email);
			pst.setString(2, IUser.getsh(pwd));
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				session.setAttribute("email",email);
				session.setAttribute("pwd",pwd);
				
				
				response.sendRedirect("index.jsp");
			}else {
				PrintWriter out = response.getWriter() ;
				out.println("<script type=\"text/javascript\">");
	            out.println("alert(' email ou mot pass est incorecct !');");
	            out.println("window.location.href = 'loginForm.jsp';");
	            out.println("</script>");
				
				
				
			}
			
	
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
			
			
	
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		

		
		
		
		


		
		

		
		
		
		
		
	



