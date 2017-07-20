// http://localhost:8080/ServletsDay4/z2?start=3&end=12

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/z2")
public class ZadMVC2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		request.setAttribute("start", ++start);
		request.setAttribute("end", ++end);
		getServletContext().getRequestDispatcher("/ZadMVC2.jsp").forward(request, response);
		
	}

}
