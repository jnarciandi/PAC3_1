package medAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		String medicamentID = request.getParameter("medicamentID");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String producer  = request.getParameter("producer");
		String category =request.getParameter("category");
		String stockQuantity =request.getParameter("stockQuantity");
		String stockInOrder = request.getParameter("stockInOrder");
		String active = request.getParameter("active");

		Medicament med = new Medicament();
		
		med.setMedicamentID(medicamentID);
		med.setName(name);
		med.setPrice(Double.parseDouble(price));
		med.setDescription(description);
		med.setProducer(producer);
		med.setCategory(category);
		med.setStockQuantity(Long.parseLong(stockQuantity));
		med.setStockInOrder(Long.parseLong(stockInOrder));
		med.setActive(Boolean.parseBoolean(active));
		

		int status = MedicamentDao.save(med);

		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}
	

}
