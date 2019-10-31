package medAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("Medicament List");

		List<Medicament> list = MedicamentDao.getAllMedicaments();

		out.print("<table id='customers'");
		out.print("<br><br>");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>Price</th><th>Description</th><th>Producer</th><th>Category</th><th>Stock</th><th>Add</th><th>Sold</th><th>Stock Order</th><th>Active</th><th>Edit</th><th>Delete</th></tr>");

		for (Medicament med : list) {
			out.print("<tr><td>" + med.getMedicamentID() + "</td><td>" + med.getName() + "</td><td>"+ med.getPrice() + "</td><td>" + med.getDescription() + "</td><td>" + med.getProducer() + "</td><td>" +med.getCategory() + "</td><td>" + med.getStockQuantity() + "</td> <td> <a href='AddServlet?id=" + med.getMedicamentID() + "'>Add</a></td> <td> <a href='SoldStock?id=" + med.getMedicamentID() + "'>Sold</a></td> <td>" +med.getStockInOrder() + "</td><td>" +med.isActive() + "</td> <td><a href='EditServlet?id=" + med.getMedicamentID() + "'>edit</a></td> <td><a href='DeleteServlet?id=" + med.getMedicamentID() + "'>delete</a></td></tr>");

		}
		out.print("</table>");

		out.println("<a href='index.html'>Add New Medicament</a>");

		out.close();
	}
}
