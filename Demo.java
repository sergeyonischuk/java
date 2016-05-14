package shop;



public class Demo {

	public static void main(String[] args) {
		Shop shop = new Shop();
		ShopUI sui = new ShopUI(shop);
		
		shop.getPrices();
		shop.getTodayRealization();
		shop.get7daysRealization();

		shop.getPrices();
		
		
	



	}

}