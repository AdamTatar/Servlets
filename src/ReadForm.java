
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadForm")
public class ReadForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName, lastName, newsletter, java, cplusplus, csharp, python, pora, arek, bank;
		String[] technologies = new String[5];
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		newsletter = request.getParameter("newsletter");
		java = request.getParameter("java");
		cplusplus = request.getParameter("cplusplus");
		csharp = request.getParameter("csharp");
		python = request.getParameter("python");
		pora = request.getParameter("pora");
		arek = request.getParameter("arek");
		bank = request.getParameter("bank");
		technologies = request.getParameterValues("technologies");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");   // polskie znaki

		response.getWriter().append("<html><head><title>Formularz</title><meta charset='utf-8'></head><body>");
		response.getWriter().append("Wprowadzono dane: <br>");
		response.getWriter().append("Imię: <b>").append(firstName).append("</b><br>");
		response.getWriter().append("Nazwisko: <b>").append(lastName).append("</b><br>");
		response.getWriter().append("Czy zapisany na newsletter: <b>").append(newsletter != null ? "Tak" : "Nie")
				.append("</b><br>");
		response.getWriter().append("Czy zna Javę: <b>").append(java != null ? "Tak" : "Nie").append("</b><br>");
		response.getWriter().append("Czy zna C++: <b>").append(cplusplus != null ? "Tak" : "Nie").append("</b><br>");
		response.getWriter().append("Czy zna C#: <b>").append(csharp != null ? "Tak" : "Nie").append("</b><br>");
		response.getWriter().append("Czy zna Pythona: <b>").append(python != null ? "Tak" : "Nie").append("</b><br>");
		response.getWriter().append("Ulubiona pora roku: <b>").append(pora + "</b><br>");
		response.getWriter().append("Co Arek robi dobrze: <b>").append(arek).append("</b><br>");
		response.getWriter().append("Bank: <b>").append(bank).append("</b><br>");
		response.getWriter().append("Technologie do nauki: <b>");

		for (String s : technologies) {
			if (s == null) {
				continue;
			}
			response.getWriter().append(s + ", ");
		}

		response.getWriter().append("</b></body></html>");
	}

}
