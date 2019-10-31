package medAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditPostServlet")
public class EditPostServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");  
        int id =Integer.parseInt(sid); 

			
		//String medicamentID = request.getParameter("medicamentID");
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		String producer = request.getParameter("producer");
		String category = request.getParameter("category");
		long stockQuantity = Long.parseLong(request.getParameter("stockQuantity"));
		long stockInOrder = Long.parseLong(request.getParameter("stockInOrder"));
		boolean active = Boolean.parseBoolean(request.getParameter("active"));

		Medicament med = new Medicament();
		
		
		med.setMedicamentID(sid);
		med.setName(name);
		med.setPrice(price);
		med.setDescription(description);
		med.setProducer(producer);
		med.setCategory(category);
		med.setStockQuantity(stockQuantity);
		med.setStockInOrder(stockInOrder);
		med.setActive(active);

		int status = MedicamentDao.update(med);

		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}
