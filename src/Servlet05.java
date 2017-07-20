

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet05
 */
@WebServlet("/Servlet05")
public class Servlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double temp = Double.parseDouble(request.getParameter("degrees"));
		double temp2 = temp;
		String to = request.getParameter("convertionType");
		if(to.equals("celcToFahr")){
			temp = 32+(9/5.0)*temp;
			response.getWriter().append(temp2 +" w Fahrenheitach to "+temp);
		}
		else if(to.equals("FahrToCelc")){
			temp = (5/9.0)*(temp-32);
			response.getWriter().append(temp2 +" w Celsiuszach to "+temp);
		}
		else{
			response.getWriter().append("Błąd obliczania temperatury");
			
		}
		
	}

}
//#### Zadanie 5
//
//W projekcie stwórz servlet  `Servlet_05`, oraz stronę HTML `index_4.html`. Następnie:
//1. Do strony dodaj formularz zawierający jedno pole liczbowe, oraz dwa przyciski `submit`. 
//Każdy z przycisków niech ma inny atrybut `name` mówiący o sposobie konwersji. 
//3. Po wysłaniu odpowiednich danych servlet ma przeliczać temperaturę w stopniach Celsjusza 
//na temperaturę w stopniach Fahrenheita (i w drugą stronę). Który przycisk został kliknięty 
//przez użytkownika dowiesz się po wartości pola `convertionType` przesyłanego POST-em.
//
//Skorzystaj z poniższego formularza:
//```html
//<form action="" method="POST">
//    <label>
//        Temperatura:
//        <input type="number" min="0.00" step="0.01" name="degrees">
//    </label>
//    <input type="submit" name="convertionType" value="celcToFahr">
//    <input type="submit" name="convertionType" value="FahrToCelc">
//</form>
//``` 
//* Aby przeliczyć jednostki użyj wzorów znajdujących się [tutaj][degrees-convertion].
//
//[degrees-convertion]:https://pl.wikipedia.org/wiki/Skala_Fahrenheita#Spos.C3.B3b_dok.C5.82adny