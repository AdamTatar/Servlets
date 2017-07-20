
// http://localhost:8080/ServletsDay4/z2?start=3&end=12

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/z3")
public class ZadMVC3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<form action='z3' method='post'> Tytul: <input type='text' name='title'><br>");
		response.getWriter().append("Autor: <input type='text' name='author'><br>");
		response.getWriter().append("ISBN: <input type='text' name='isbn'><br>");
		response.getWriter().append("<input type='submit' value='Wyślij'><br></form>");

	}

	
	// UWAGA - jak chcę przesłać request w kodowaniu UTF-8 to muszę wpisać request.setCharacterEncoding("UTF-8");
	// a nie response....
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			// UWAGA
		
		ZadMVC3Klasa book = new ZadMVC3Klasa(request.getParameter("title"), request.getParameter("author"), request.getParameter("isbn"));
		request.setAttribute("book", book);
		getServletContext().getRequestDispatcher("/ZadMVC3.jsp").forward(request, response);
	}
}

//
// W projekcie stwórz servlet `Servlet_03`. Następnie:
// 1. W widoku stwórz formularz zawierający pola o nazwach (title, author,
// isbn).
// Formularz ma przesłać dane metodą POST do tego samego servletu (do metody
// `doPost`).
// 2. Stwórz Klasę `Book` zawierającą pola zgodne z polami wcześniej utworzonego
// formularza.
// 3. Odbierz dane na ich podstawie stwórz obiekt klasy Book.
// 4. Przekaż obiekt do widoku `result.jsp`.
// 5. Wyświetl właściwości nowo dodanego obiektu `title`, `author`.