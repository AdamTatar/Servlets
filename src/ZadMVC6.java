

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/z6")
public class ZadMVC6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<form action='z6' method='post'> Drugi servlet:<br>Tytul: <input type='text' name='title'><br>");
		response.getWriter().append("Autor: <input type='text' name='author'><br>");
		response.getWriter().append("ISBN: <input type='text' name='isbn'><br>");
		response.getWriter().append("<input type='submit' value='Wyślij'><br></form>");

	}

	// UWAGA - jak chcę przesłać request w kodowaniu UTF-8 to muszę wpisać request.setCharacterEncoding("UTF-8");
	// a nie response....
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			// UWAGA
		
		HttpSession ses = request.getSession();
		
		
		ZadMVC3Klasa[] ksiazki = (ZadMVC3Klasa[]) ses.getAttribute("tablica");
		
		ArrayList<String> tytuly = new ArrayList<>();
		tytuly.addAll(Arrays.asList(request.getParameterValues("title")));
		
		ArrayList<String> autorzy = new ArrayList<>();
		autorzy.addAll(Arrays.asList(request.getParameterValues("author")));
		
		ArrayList<String> isbny = new ArrayList<>();
		isbny.addAll(Arrays.asList(request.getParameterValues("isbn")));
		
		ZadMVC3Klasa[] tablica = new ZadMVC3Klasa[tytuly.size()+ksiazki.length];
		for (int i = 0; i < tytuly.size(); i++) {
			tablica[i] = new ZadMVC3Klasa(tytuly.get(i), autorzy.get(i), isbny.get(i));
		}

		ZadMVC3Klasa[] tablicaKsiazek = Arrays.copyOf(ksiazki, ksiazki.length+tablica.length);
		for(int i = ksiazki.length; i<ksiazki.length+tablica.length; i++){
			tablicaKsiazek[i] = tablica[i-ksiazki.length];
			
		}

		
		
		ses.setAttribute("tablicaKsiazek", tablicaKsiazek);
//		request.setAttribute("book", tablica);
		
		
		getServletContext().getRequestDispatcher("/ZadMVC5.jsp").forward(request, response);
	}
}

//#### Zadanie 5
//
//W projekcie stwórz servlet `Servlet_05_1`. Servlet ma udostępniać możliwość dodawania nowej książki
//w sposób pojedynczy (obiekt `Book`), który następnie będzie zapisywany do sesji.    
//Następnie stwórz `Servlet_05_2`, który będzie udostępniał możliwość tworzenia 3 książek na raz 
//- podobnie jak w poprzednim zadaniu, niezależnie od metody dodania książki ma ona zostać zapisana w sesji.
//Utworzone obiekty przechowuj w tablicy.   
//Na końcu stwórz Servlet który będzie wyświetlał w widoku listę wszystkich utworzonych książek.
