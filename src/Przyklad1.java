
//UWAGA: jak się robi nowy projekt to do lib trzeba dorzucić biblioteki taglibs impl i taglibs spec.
//nie działa przez bildpath do projektu, trzeba je wrzucić do WEB-INF/lib
//to jest po to żeby korzystać z tego c:out

// tutaj robię tak, że z tego servletu wysyłam informację do pliku jsp i tam je wyświetlam
// to jest przykład ze slajdów
//adres jest z servletu, ale treść na stronie z JSP


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Przyklad1")
public class Przyklad1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Przyklad1Klasa pk = new Przyklad1Klasa("PK", 700, "black");	//tu sobie własny obiekt tworze
		
		request.setAttribute("pk", pk);	//a tutaj przekazuje obiekt do requestu
		request.setAttribute("myAttribute",	"paramValue");

		Przyklad1Klasa pk2 = new Przyklad1Klasa("pe ka 2", 100, "blue");	//tu sobie własny obiekt tworze
		Przyklad1Klasa pk3 = new Przyklad1Klasa("pe ka 3", 200, "red");	//tu sobie własny obiekt tworze
		
		Przyklad1Klasa[] pkTab = {pk2, pk3};
		
		request.setAttribute("pkTab", pkTab);	//a tutaj przekazuje tablicę obiektów do requestu
		
		
		getServletContext().getRequestDispatcher("/Przyklad1.jsp").forward(request,	response);	//tu musi być / bo bez niego nie działa
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
