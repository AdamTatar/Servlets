
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet02
 */
@WebServlet("/Servlet02")
public class Servlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text;
		text = request.getParameter("text");
		response.getWriter().append("Wpisany tekst: ").append(text);
		String[] cenzura = { "cholera", "kurcze", "pieprze" };
		for (String s : cenzura) {
			if (text.contains(s)) {
				String gwiazdki = "";
				for (int i = 0; i < s.length(); i++) {
					gwiazdki += "*";
				}
				text = text.replaceFirst(s, gwiazdki);
			}
		}
		response.getWriter().append("\n\nTekst po cenzurze: ").append(text);
	}

}
// #### Zadanie 2 - rozwiązywane z wykładowcą
//
// W projekcie stwórz servlet `Servlet_02`, oraz stronę HTML `index_2.html`.
// Następnie:
// 1. Dodaj do strony jest formularz, wysyłany metodą `POST`. Formularz powinien
// zawierać jedno pole
// tekstowe i jeden checkbox z opisem `Jestem świadomy konsekwencji`.
// 3. Dopisz funkcjonalność która po przesłaniu formularza sprawdzi, czy wpisany
// przez użytkownika
// tekst zawiera wulgaryzmy. Jeżeli tak, to nasz kod powinien zastąpić wulgarne
// słowo znakami. `****`
//
// Na przykład frazę `cholera, znowu ta JAVA ` powinien zastąpić frazą `*******,
// znów ta JAVA `.
// Jeżeli użytkownik zaznaczy checkbox `Jestem świadomy konsekwencji`, to
// program nie sprawdzi
// wulgaryzmów i wyświetli wpisany tekst.
// Liczba gwiazdek ma odpowiadać liczbie znaków w cenzurowanym słowie.
//
//
// Hint: listę wulgaryzmów możesz stworzyć samodzielnie w postaci tablicy, lub
// poszukać gotowych
// tablic w internecie.
//
