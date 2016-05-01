package shop;

public class Launcher {
	

	public static void main(String[] args) {
		Shop shop = new Shop();
		setUpProducts(shop);
		
		ShopUI ui = new ShopUI(shop);

	}
	
	private static void setUpProducts(Shop shop){
		Instrument inst = new Guitar();
		inst.setModel("dadad");
		inst.setPrice(3000);
		inst.setBrand("YAMAHA");
		inst.setColor(Color.BLACK);
		inst.setQuantity(30);
		shop.addGuitar();
		
		inst = new Guitar();
		inst.setModel("dadad2");
		inst.setPrice(30003);
		shop.addGuitar();
		
		inst = new Guitar();
		inst.setModel("dadad3");
		inst.setPrice(5000);
		shop.addGuitar();
		
	}

}
