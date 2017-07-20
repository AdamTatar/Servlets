

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/z4")
public class ZadMVC4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<form action='z4' method='post'> Tytul: <input type='text' name='title'><br>");
		response.getWriter().append("Autor: <input type='text' name='author'><br>");
		response.getWriter().append("ISBN: <input type='text' name='isbn'><br>");
		response.getWriter().append("<form action='z3' method='post'> Tytul: <input type='text' name='title'><br>");
		response.getWriter().append("Autor: <input type='text' name='author'><br>");
		response.getWriter().append("ISBN: <input type='text' name='isbn'><br>");response.getWriter().append("<form action='z3' method='post'> Tytul: <input type='text' name='title'><br>");
		response.getWriter().append("Autor: <input type='text' name='author'><br>");
		response.getWriter().append("ISBN: <input type='text' name='isbn'><br>");
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

//		JOptionPane.showMessageDialog(null, "Komunikat");					// żeby wyświetlić sobie okno z messydżem
		
		
		ArrayList<String> tytuly = new ArrayList<>();
		tytuly.addAll(Arrays.asList(request.getParameterValues("title")));
		
		System.out.println(tytuly.toString());
		
		ArrayList<String> autorzy = new ArrayList<>();
		autorzy.addAll(Arrays.asList(request.getParameterValues("author")));
		
		ArrayList<String> isbny = new ArrayList<>();
		isbny.addAll(Arrays.asList(request.getParameterValues("isbn")));
		
		ZadMVC3Klasa[] tablica = new ZadMVC3Klasa[tytuly.size()];
		for (int i = 0; i < tytuly.size(); i++) {
			tablica[i] = new ZadMVC3Klasa(tytuly.get(i), autorzy.get(i), isbny.get(i));
			System.out.println(tablica[i]);
		}
		
		request.setAttribute("book", tablica);
		getServletContext().getRequestDispatcher("/ZadMVC4.jsp").forward(request, response);
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