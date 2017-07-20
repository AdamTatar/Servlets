
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet03
 */
@WebServlet("/Servlet03")
public class Servlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String kwadrat(int a, int b, int c) throws NumberFormatException, IOException 
    {
        int delta;
        double pdelta,x0,x1,x2;
        delta=(b*b-4*a*c);
        pdelta = Math.sqrt(delta);
        if(delta>0)
        {
            x1=(-b-pdelta)/(2*a);
            x2=(-b+pdelta)/(2*a);
            return "Pierwiastki równania wynosza: "+x1+" oraz "+x2;
        }
        else if(delta==0)
        {
            x0=-b/(2*a);
            return "Jest jeden pierwiastek: "+x0;
        }
        else
        {
            return ("Delta jest ujemna i wynosi: "+delta+". Funkcja nie posiada miejsc zerowych");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int c = Integer.parseInt(request.getParameter("c"));
		String result = kwadrat(a,b,c);
		response.getWriter().append(result);
		

	}

}
