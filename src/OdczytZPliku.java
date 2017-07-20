
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OdczytZPliku")
public class OdczytZPliku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String absoluteDiskPath = getServletContext().getRealPath("oop.txt");
		Path path = Paths.get(absoluteDiskPath);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(absoluteDiskPath).append("<br>");
		for (String line : Files.readAllLines(path)) {
			response.getWriter().append(line).append("<br>");
		}
	}
}
