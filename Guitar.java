package shop;

public class Guitar extends Instrument{
	
	private GuitarType gType;
	
	public Guitar(){
		
	}
	
	public Guitar(Color color, String brand, String model, int price, GuitarType gType, int quantity, int sold){
		super(color, brand, model, price, quantity, sold);
		this.gType = gType;
	}

	public GuitarType getgType() {
		return gType;
	}

	public void setgType(GuitarType gType) {
		this.gType = gType;
	}
	

}
