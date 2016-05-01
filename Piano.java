package shop;

public class Piano extends Instrument{
	
	private int keys;
	
	public Piano(){
	}
	
	public Piano(Color color, String brand, String model, int price, int keys, int quantity, int sold){
		super(color, brand, model, price, quantity, sold);
		this.keys = keys;
	}

	public int getKeys() {
		return keys;
	}

	public void setKeys(int keys) {
		this.keys = keys;
	}

}
