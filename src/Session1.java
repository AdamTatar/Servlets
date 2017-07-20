
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session1")
public class Session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sess = request.getSession();
		sess.setAttribute("counter", 0);
		response.getWriter().append("Ustawiono wartosc sesji na 0");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// W projekcie stwórz trzy servlety `Servlet_01_Set`, `Servlet_01_Get`,
// `Servlet_03_Del`. Następnie:
// 1. Pierwszy ma nastawiać informacje w sesji pod kluczem ```counter``` na `0`.
// 2. Drugi ma wyświetlać zawartość sesji pod kluczem ```counter``` i zwiększać
// ją o `1`. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić
// odpowiednią informacje.
// 3. Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem
// ```counter```).
