package medAdmin;

import java.io.IOException;  
import java.io.PrintWriter;   
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;



	@WebServlet("/AddServlet") 

	public class AddServlet extends HttpServlet{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException { 

			 
	        String sid = request.getParameter("id");  
	        int id = Integer.parseInt(sid);
	        
	        
	        MedicamentDao.addStock(id);  
	        response.sendRedirect("ViewServlet"); 
	        
	        
	        
	    }  


	}