package com.email.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.email.dao.UserDao;
import com.email.entities.User;
import com.email.metier.IUser;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = IUser.getsh(request.getParameter("password"));
		response.setContentType("text/html");
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPassword(password);
		

		
		
		IUser service = new UserDao();
		
		if (service.findOne(email) == true) {
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('this account is already exists !');");
            out.println("window.location.href = 'RegistrationForm.jsp';");
            out.println("</script>");
		}else {
			service.RegisterUser(user);
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
			
            out.println("alert('This account is successfully created!');");
            out.println("window.location.href = 'loginForm.jsp';");
            out.println("</script>");
		}

		
		
		
    }

}

