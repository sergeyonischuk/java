package shop;

public class Piano extends Instrument{
	
	private int keys;
	
	public Piano(){
	}
	
	public Piano(Color color, String brand, String model, int price, int keys){
		super(color, brand, model, price);
		this.keys = keys;
	}

	public int getKeys() {
		return keys;
	}

	public void setKeys(int keys) {
		this.keys = keys;
	}

}
