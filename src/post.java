
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class post
 */
@WebServlet("/post")
public class post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String myName = request.getParameter("myName");
//
//		response.getWriter().append("my name: ").append(myName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String myName = request.getParameter("myName");

		response.getWriter().append("my name: ").append(myName);
//		doGet(request, response);
	}

}
