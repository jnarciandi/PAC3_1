package medAdmin;

public class Medicament {
	

	private String medicamentID;
	private String name;
	private double price;
	private String description;
	private String producer;
	private String category;
	private long stockQuantity;
	private long stockInOrder;
	private boolean active;
	
	public Medicament() {
		
	}
	
	public Medicament(String medicamentID, String name, double price) {
		
		this.name = name;
		this.medicamentID = medicamentID;
		this.price = price;
		
	}

	


	public String getMedicamentID() {
		return medicamentID;
	}

	public void setMedicamentID(String medicamentID) {
		this.medicamentID = medicamentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public long getStockInOrder() {
		return stockInOrder;
	}

	public void setStockInOrder(long stockInOrder) {
		this.stockInOrder = stockInOrder;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	@Override
	public String toString() {
		return "Medicament [medicamentID=" + medicamentID + ", name=" + name + ", price=" + price + ", description="
				+ description + ", producer=" + producer + ", category=" + category + ", stockQuantity=" + stockQuantity
				+ ", stockInOrder=" + stockInOrder + ", active=" + active + "]";
	}
	
	
	
}
