package shop;

public class Instrument {
	

	private Color color;
	private String brand;
	private String model;
	private int price;
	private int quantity;
	private int sold;
	
	public Instrument(){
		
	}
	
	public Instrument(Color color, String brand, String model, int price, int quantity, int sold){
		this.color = color;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
		this.sold = sold;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}
	
	
	
}
