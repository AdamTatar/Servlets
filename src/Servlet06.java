

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet06")
public class Servlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName=((request.getParameter("firstName")!=null) ? request.getParameter("firstName"):"");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<h1>Form</h1><form method='post'>")
		.append("Podaj imię: <input type='text' value='"+firstName+"' name='firstName' />")
		.append("Zaakceptuj regulamin: <input id='acceptRules' type='checkbox' name = 'acceptRules'/>")
		.append("<input type='submit'/>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acceptRules = request.getParameter("acceptRules");
		if(acceptRules != null){
			response.sendRedirect("Servlet07");
		}
		doGet(request, response);
	}

}
