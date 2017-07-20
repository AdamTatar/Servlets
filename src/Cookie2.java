
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie2
 */
@WebServlet("/addToCookie")
public class Cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String klucz = request.getParameter("key");
		String wartosc = request.getParameter("value");

		Cookie c = new Cookie(klucz, wartosc);
		c.setMaxAge(24 * 60 * 60);
		response.addCookie(c);
		response.getWriter().append("Dodano ciasteczko " + klucz + ": " + wartosc);
		response.getWriter().append("\n\nSprawdzenie czy istnieje ciasteczko " + klucz + " z wartoscia " + wartosc);
		String cookieValue = "";
		Cookie[] cookies = request.getCookies();
		try {
			for (Cookie cookie : cookies) {
				if (klucz.equals(cookie.getName())) {
					cookieValue = cookie.getValue();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}										//tu coś nie działa :(

		if (cookieValue != null) {
			response.getWriter().append("\n\nInfo from cookie: ").append(klucz +" "+ cookieValue);

		} else

			response.getWriter().append("Brak cookie");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

// #### Zadanie 2 - rozwiązywane z wykładowcą.
// W projekcie stwórz servlet `Servlet_08`, dostępny pod adresem `/addToCookie`,
// który wyświetli następujący formularz:
// ```html
// <form action="" method="POST">
// <label>
// Klucz:
// <input type="text" name="key">
// </label>
// <label>
// Wartość:
// <input type="text" name="value">
// </label>
// <input type="submit">
//
// </form>
// ```
// Po zatwierdzeniu formularza metodą POST dodajemy nowe ciasteczko o podanej
// nazwie i wartości.
