

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Zadanie2SredniaOcen
 */
@WebServlet("/z2")
public class Zadanie2SredniaOcen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		
		String[] grades = request.getParameterValues("grade");	//pobranie całej tablicy
		double avg;
		if(ses.getAttribute("grades")==null){
			ses.setAttribute("grades", grades);
		}else{
			String[] tmpArray = (String[]) ses.getAttribute("grades");

		}
		
		
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			try {
				sum += Integer.parseInt(grades[i]);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		avg = sum / grades.length;
		
		response.getWriter().append("Srednia: "+avg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
