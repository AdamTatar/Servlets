

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ZadMVC1")
public class ZadMVC1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double exchangeValue = Double.parseDouble(request.getParameter("value"));
		double exchangeRate = Double.parseDouble(getServletContext().getInitParameter("exchangeRate"));
		request.setAttribute("newValue", exchangeRate * exchangeValue);
		request.setAttribute("exchangeValue", exchangeValue);
		getServletContext().getRequestDispatcher("/ZadMVC1.jsp").forward(request, response);
		
	}

}
