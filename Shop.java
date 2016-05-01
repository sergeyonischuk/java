package shop;

import java.sql.Date;

public class Shop {
	
	private int positions = 100;
	private int customers = 100;
	private int realization = 100;
	private int indexInst = 12;
	private int indexCust = 3;
	private int indexJour = 4;
	
	private Instrument[] storage = new Instrument[positions];
	private Customer[] customer = new Customer[customers];
	private Realization[] journal = new Realization[realization];
	
	
	public Shop(){
		
		storage[0] = new Guitar(Color.BLACK, "Fender", "Les Paul", 25000, GuitarType.ELECTRIC, 1, 0);
		storage[1] = new Guitar(Color.BLUE, "Cort", "X6", 7100, GuitarType.ELECTRIC, 3, 2);
		storage[2] = new Guitar(Color.BLACK, "Fender", "A55", 8000, GuitarType.ACOUSTIC, 5, 3);
		storage[3] = new Guitar(Color.RED, "Ibanez", "BV44A", 8500, GuitarType.ELECTRIC, 6, 1);
		storage[4] = new Guitar(Color.YELLOW, "Phill Pro", "StartBass", 3400, GuitarType.BASS, 5, 4);
		storage[5] = new Guitar(Color.BLACK, "Cort", "XB2", 4500, GuitarType.BASS, 2, 4);
		storage[6] = new Guitar(Color.WHITE, "Fender", "New model", 4251, GuitarType.CLASSICAL, 2, 1);
		storage[7] = new Guitar(Color.WHITE, "Line6", "Rock star", 5670, GuitarType.ELECTRIC, 1, 1);
		storage[8] = new Guitar(Color.BLACK, "Yamaha", "C40", 3330, GuitarType.CLASSICAL, 2, 3);
		storage[9] = new Piano(Color.BLACK, "Ukraine", "new", 4000, 88, 2, 2);
		storage[10] = new Piano(Color.WHITE, "Yamaha", "new2", 8000, 88, 1, 2);
		storage[11] = new Piano(Color.BLACK, "Yamaha", "new3", 10000, 84, 1, 0);
		
		customer[0] = new Customer("Sergey", "0638888888", "sergey.onischuk@ukr.net");
		customer[1] = new Customer("Yaroslav", "044*333*22*11", "mail@ukr.net");
		customer[2] = new Customer("Anastasiya", "096-368-58-21", "mail@ukr.net");
		
		journal[0] = new Realization(storage[1], customer[1], 7100, 1, "2016-03-03");
		journal[1] = new Realization(storage[6], customer[0], 4251, 1, "2016-03-03");
		journal[2] = new Realization(storage[4], customer[2], 4500, 1, "2016-03-05");
		journal[3] = new Realization(storage[8], customer[1], 3330, 1, "2016-03-08");
		

	}
	
	public void getPrices(){
		System.out.println("***** Prices *****");
		for(int i = 0; i < storage.length && storage[i] != null; i++){
			System.out.println(storage[i].getModel() + ". Price: " + storage[i].getPrice());
		}
	}
	
	public void availStor(){
		System.out.println("***** Available in storage *****");
		for(int i = 0; i < storage.length && storage[i] != null; i++){
			System.out.println(storage[i].getModel() + ". In storage: " + storage[i].getQuantity());
		}
	}
	
	public void get7daysRealization(){
	
 		String dateString = getDate().replaceAll("-", "");
		Date date = new Date(System.currentTimeMillis());
		int lastD = Integer.parseInt(dateString.substring(7, 8));
		for(int i = 0; i < 7; i++){

			date.setDate(lastD - i);
			int totalSum = 0;
			System.out.println(date);
				for(int j = indexJour - 1; j >= 0; j--){
					if(date.toString().equals(journal[j].getData())){

						totalSum += journal[j].getSum();
						System.out.println("Instrument: " + journal[j].getInstrument().getBrand() + " " 
								+ journal[j].getInstrument().getModel() + "(" + journal[j].getAmount() + ")" + ". Customer: " + 
									journal[j].getCustomer().getName() + ". Sum: " + journal[j].getSum());
						System.out.println();
						
					}
					
				}			
				System.out.println("Total day sum: " + totalSum);
				System.out.println("**********");
		}
	}
	
	public void getTodayRealization(){
		System.out.println("Today is " + getDate() + ":");
			for(int i = indexJour - 1; journal[i].getData().equals(getDate()); i--){
				System.out.println("Instrument: " + journal[i].getInstrument().getBrand() + " " 
				+ journal[i].getInstrument().getModel() + "(" + journal[i].getAmount() + ")" + ". Customer: " + 
						journal[i].getCustomer().getName() + ". Sum: " + journal[i].getSum());
		}
	}
	
	public String getDate(){
		return new Date(System.currentTimeMillis()).toString();
	}
	

	
	//сделать дополнительно, если будет время
	
	public void addRealiz(Instrument instrument, Customer customer, int sum, int amount){
		journal[indexJour] = new Realization(instrument, customer, sum, amount, getDate());
		
	}
	
	public int addGuitar(){
		return indexInst;
	}
	public void deleteGuitar(){
		
	}
	
	public int addPiano(){
		return indexInst;
	}
	public void deletePiano(){
		
	}
	
	public void addCustomer(){
		
	}
	

}