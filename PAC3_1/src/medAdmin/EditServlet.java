package medAdmin;

import java.io.IOException;  
import java.io.PrintWriter;   
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException { 
 
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("Update Medicament");
        
        String sid = request.getParameter("id");  
        int id =Integer.parseInt(sid);  
          
        Medicament e=MedicamentDao.getMedicamentById(id);  
          
        out.print("<form action='EditPostServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getMedicamentID()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");
        out.print("<tr><td>Description:</td><td><input type='text' name='description' value='"+e.getDescription()+"'/></td></tr>");
        out.print("<tr><td>Producer:</td><td><input type='text' name='producer' value='"+e.getProducer()+"'/></td></tr>");
        out.print("<tr><td>Category:</td><td><input type='text' name='category' value='"+e.getCategory()+"'/></td></tr>"); 
        out.print("<tr><td>Stock Quantity:</td><td><input type='text' name='stockQuantity' value='"+e.getStockQuantity()+"'/></td></tr>");
        out.print("<tr><td>Stock Order:</td><td><input type='text' name='stockInOrder' value='"+e.getStockInOrder()+"'/></td></tr>"); 
        out.print("<tr><td>Active:</td><td><input type='checkbox' name='active' value='true'/></td></tr>");        
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}