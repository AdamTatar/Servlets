
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// zrobić metodę która nam wybierze ciasteczko z tablicy

// spring getcookie jakie metody

@WebServlet("/Cookie01")
public class Cookie01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
//#### Zadanie 1 - rozwiązywane z wykładowcą
//
//W projekcie stwórz trzy servlety `Servlet_01_Set`, `Servlet_01_Get`, `Servlet_01_Del`. Następnie:
//1. Servlet `Servlet_01_Set ma być dostępny pod adresem `/setCookie`. Ma nastawiać ciasteczko o nazwie 
//```User``` na `Coders Lab`, z ważnością `24h`.
//2. Servlet `Servlet_01_Get` ma być dostępny pod adresem `/showCookie`. Ma wyświetlać zawartość
//ciasteczka ```User```. Jeżeli nie ma takiego ciasteczka, to powinna się  wyświetlić odpowiednia informacje.
//3. Servlet `Servlet_01_Del` ma być dostępny pod adresem  `/deleteCookie` ma kasować ciasteczko 
//o nazwie ```User```. Jeżeli nie ma takiego ciasteczka, to powinna się  wyświetlić odpowiednia informacje.
//  