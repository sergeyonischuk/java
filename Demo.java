package shop;



public class Demo {

	public static void main(String[] args) {
		Shop shop = new Shop();

		
		shop.getPrices();
		shop.getTodayRealization();
		shop.get7daysRealization();
		
		shop.addGuitar(Color.WHITE, "LOH", "LOH333", 999, GuitarType.ELECTRIC);
		shop.getPrices();
		shop.getPrices();
		
		ShopUI sui = new ShopUI(shop);
	



	}

}