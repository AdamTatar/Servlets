
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ses")
public class SessionCwiczenia extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sess = request.getSession();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		if (sess.isNew()) {
			response.getWriter().append("Pierwsze sprawdzenie - sesja jest nowa!\n<br><br>");
			sess.setAttribute("counter", 0);
			sess.setAttribute("mojAtrybut", "jajko");
		} else {
			response.getWriter()
					.append("Sesja nie jest nowa a counter ma wartosc " + (Integer) sess.getAttribute("counter") + "\n");
			sess.setAttribute("counter", (int) sess.getAttribute("counter") + 1);
			response.getWriter().append(
					"Wartosc counter zostala zwiekszona i wynosi obecnie " + (int) sess.getAttribute("counter") + "\n\n\n");
		}

		sess.setMaxInactiveInterval(30);
		response.getWriter().append("<html><body><form action='ses' method = 'post'><br> <input type='submit' value='Usun sesje'></form></body></html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sess = request.getSession();
		sess.invalidate();
		
		doGet(request, response);
	}

}
