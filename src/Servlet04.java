
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter()
				.append("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Porzadkowanie</title></head><body>");
		response.getWriter().append("<form action='Servlet04' method='post'>");
		int ile = 5 + new Random().nextInt(6);;
		for (int i = 0; i < ile; i++) {
			response.getWriter().append("<input name='numbers'/><br/>");
		}
		response.getWriter().append("<input type='submit'/></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] input = request.getParameterValues("numbers");
		double tab[] = new double[input.length];
		for (int i = 0; i < input.length; i++) {
			tab[i] = Integer.parseInt(input[i]);
		}
		response.getWriter().append("Wprowadzono wartosci: "+Arrays.toString(tab));
		Arrays.sort(tab);
		response.getWriter().append("\n\nPosortowano liczby: "+Arrays.toString(tab));
		
		
	}

}
//W projekcie stwórz servlet `Servlet_04`. Następnie:
//1. w metodzie `doGet`, będzie wyświetlał formularz z losową ilością parametrów (w zakresie od 5 do 10) o takiej samej nazwie `numbers`.
//2. W metodzie `doPost` pobierz wszystkie parametry - te z nich, które reprezentują wartość liczbową, wyświetl posortowane od najmniejszego do największego.
