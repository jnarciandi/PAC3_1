package medAdmin;
import java.util.*;
import java.sql.*;

public class MedicamentDao {
	public static Connection getConnection() {

		Connection conection = null;
		try {

			Class.forName("org.h2.Driver");
			conection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/curso", "sa", "a");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conection;
	}

	public static int save(Medicament med) {
		int status = 0;

		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection.prepareStatement("insert into MEDICAMENT (medicamentId,name,price,description,producer,category,stockQuantity,stockInOrder,active) values (?,?,?,?,?,?,?,?,?)");
			preparedStatment.setString(1, med.getMedicamentID());
			preparedStatment.setString(2, med.getName());
			preparedStatment.setString(3, String.valueOf(med.getPrice()));
			preparedStatment.setString(4, med.getDescription());
			preparedStatment.setString(5, med.getProducer());
			preparedStatment.setString(6, med.getCategory());
			preparedStatment.setString(7, String.valueOf(med.getStockQuantity()));
			preparedStatment.setString(8, String.valueOf(med.getStockInOrder()));
			preparedStatment.setString(9, String.valueOf(med.isActive()));

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Medicament med) {

		int status = 0;
		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("update MEDICAMENT set name=?,price=?,description=?,producer=?,category=?,stockQuantity=?,stockInOrder=?,active=? where medicamentId=?");
			
			
			preparedStatment.setString(9, med.getMedicamentID());
			preparedStatment.setString(1, med.getName());
			preparedStatment.setString(2, String.valueOf(med.getPrice()));
			preparedStatment.setString(3, med.getDescription());
			preparedStatment.setString(4, med.getProducer());
			preparedStatment.setString(5, med.getCategory());
			preparedStatment.setString(6, String.valueOf(med.getStockQuantity()));
			preparedStatment.setString(7, String.valueOf(med.getStockInOrder()));
			preparedStatment.setString(8, String.valueOf(med.isActive()));

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	public static void addStock(int id) {

		int status = 0;
		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("update MEDICAMENT set stockQuantity=? where medicamentId=?");
			
			Medicament med=MedicamentDao.getMedicamentById(id);
			
			preparedStatment.setInt(2, id);
			preparedStatment.setString(1, String.valueOf(med.getStockQuantity()+1));


			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}


	}
	
	public static void soldStock(int id) {

		int status = 0;
		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("update MEDICAMENT set stockQuantity=? where medicamentId=?");
			
			Medicament med=MedicamentDao.getMedicamentById(id);
			
			preparedStatment.setInt(2, id);
			if (med.getStockQuantity() > 0) {
			preparedStatment.setString(1, String.valueOf(med.getStockQuantity()-1));
			}else {
				preparedStatment.setString(1, "0");
			}


			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}


	}

	public static int delete(int id) {
		int status = 0;

		try {

			Connection connection = MedicamentDao.getConnection();
			PreparedStatement prepareStatment = connection.prepareStatement("delete from MEDICAMENT where medicamentId=?");

			prepareStatment.setInt(1, id);
			status = prepareStatment.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Medicament getMedicamentById(int id) {

		Medicament med = new Medicament();

		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("select * from MEDICAMENT where medicamentId=?");
			preparedStatment.setInt(1, id);

			ResultSet rs = preparedStatment.executeQuery();
			if (rs.next()) {
				med.setMedicamentID(rs.getString(1));
				med.setName(rs.getString(2));
				med.setPrice(rs.getDouble(3));
				med.setDescription(rs.getString(4));
				med.setProducer(rs.getString(5));
				med.setCategory(rs.getString(6));
				med.setStockQuantity(rs.getLong(7));
				med.setStockInOrder(rs.getLong(8));
				med.setActive(rs.getBoolean(9));
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return med;
	}

	public static List<Medicament> getAllMedicaments() {
		List<Medicament> list = new ArrayList<Medicament>();

		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection.prepareStatement("select * from MEDICAMENT");
			ResultSet rs = preparedStatment.executeQuery();
			while (rs.next()) {
				Medicament med = new Medicament();
				med.setMedicamentID(rs.getString(1));
				med.setName(rs.getString(2));
				med.setPrice(rs.getDouble(3));
				med.setDescription(rs.getString(4));
				med.setProducer(rs.getString(5));
				med.setCategory(rs.getString(6));
				med.setStockQuantity(rs.getLong(7));
				med.setStockInOrder(rs.getLong(8));
				med.setActive(rs.getBoolean(9));
				list.add(med);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
