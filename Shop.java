package shop;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

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
		
		storage[0] = new Guitar(Color.BLACK, "Fender", "Les Paul", 25000, GuitarType.ELECTRIC);
		storage[1] = new Guitar(Color.BLUE, "Cort", "X6", 7100, GuitarType.ELECTRIC);
		storage[2] = new Guitar(Color.BLACK, "Fender", "A55", 8000, GuitarType.ACOUSTIC);
		storage[3] = new Guitar(Color.RED, "Ibanez", "BV44A", 8500, GuitarType.ELECTRIC);
		storage[4] = new Guitar(Color.YELLOW, "Phill Pro", "StartBass", 3400, GuitarType.BASS);
		storage[5] = new Guitar(Color.BLACK, "Cort", "XB2", 4500, GuitarType.BASS);
		storage[6] = new Guitar(Color.WHITE, "Fender", "New model", 4251, GuitarType.CLASSICAL);
		storage[7] = new Guitar(Color.WHITE, "Line6", "Rock star", 5670, GuitarType.ELECTRIC);
		storage[8] = new Guitar(Color.BLACK, "Yamaha", "C40", 3330, GuitarType.CLASSICAL);
		storage[9] = new Piano(Color.BLACK, "Ukraine", "For noobs", 4000, 88);
		storage[10] = new Piano(Color.WHITE, "Yamaha", "Piano", 8000, 88);
		storage[11] = new Piano(Color.BLACK, "Yamaha", "MegaPiano", 10000, 84);

		
		customer[0] = new Customer("Sergey", "0638888888", "sergey.onischuk@ukr.net");
		customer[1] = new Customer("Yaroslav", "044*333*22*11", "mail@ukr.net");
		customer[2] = new Customer("Anastasiya", "096-368-58-21", "mail333@ukr.net");
		customer[3] = null;
		
		journal[0] = new Realization(storage[1], customer[1], 7100, 1, "01.05.2016");
		journal[1] = new Realization(storage[6], customer[0], 4251, 1, "08.05.2016");
		journal[2] = new Realization(storage[4], customer[2], 4500, 1, "12.05.2016");
		journal[3] = new Realization(storage[8], customer[1], 3330, 1, "13.05.2016");
		

	}
	
	
	public ArrayList<Instrument> getProducts(){
		ArrayList<Instrument> list = new ArrayList<Instrument>();
		for(int i = 0; i < storage.length; i++){
			list.add(storage[i]);
		}
		list.removeAll(Collections.singleton(null));
		return list;
	}
	
	public void getPrices(){
		System.out.println("***** Prices *****");
		for(int i = 0; i < storage.length && storage[i] != null; i++){
			System.out.println(storage[i].getModel() + ". Price: " + storage[i].getPrice());
		}
		System.out.println("*******");
		
	}
	
	public void availStor(){
		System.out.println("***** Available in storage *****");
		for(int i = 0; i < storage.length && storage[i] != null; i++){
			System.out.println(storage[i].getModel() + ". In storage: " + storage[i].getQuantity());
		}
	}
	
	public void get7daysRealization(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar c1 = Calendar.getInstance();
		String today = sdf.format(c1.getTime()).toString();
		int kostyl = 1;
		
		for(int j = 1; j <= 7; j++){

			System.out.println("Today is " + today + ":");
				
			for(int i = indexJour - kostyl; journal[i].getData().equals(today); i--){
					System.out.println("Instrument: " + journal[i].getInstrument().getBrand() + " " 
					+ journal[i].getInstrument().getModel() + "(" + journal[i].getAmount() + ")" + ". Customer: " + 
							journal[i].getCustomer().getName() + ". Sum: " + journal[i].getSum());
					kostyl++;
				}
			
				
			System.out.println("******");
			c1.add(Calendar.DATE, -1);
			today = sdf.format(c1.getTime()).toString();

		}
		
	}
	
	public void getTodayRealization(){

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar c1 = Calendar.getInstance();
//		c1.add(Calendar.DATE, -1);
		String today = sdf.format(c1.getTime()).toString();
		System.out.println(today);
		
		
		
		System.out.println("Today is " + today + ":");
			for(int i = indexJour - 1; journal[i].getData().equals(today); i--){
				System.out.println("Instrument: " + journal[i].getInstrument().getBrand() + " " 
				+ journal[i].getInstrument().getModel() + "(" + journal[i].getAmount() + ")" + ". Customer: " + 
						journal[i].getCustomer().getName() + ". Sum: " + journal[i].getSum());
		}
			System.out.println("******");
	}
	
	public String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(new Date());
	}
	

	
	
	//сделать дополнительно, если будет время
	
	public void addRealiz(Instrument instrument, Customer customer, int sum, int amount){
		journal[indexJour] = new Realization(instrument, customer, sum, amount, getDate());
		System.out.println("***new realization***");
		System.out.println("customer: " + customer.getName() + ", tel: " + customer.getPhone());
		System.out.println(instrument.getModel() + " " + sum + "$ " + amount + "шт");
		
	}
	
	public void addGuitar(Color color, String brand, String model, int price, GuitarType gType){

			storage[findStorPlace()] = new Guitar(color, brand, model, price, gType);
			indexInst ++;
		
		
	}
	
	
	public int findStorPlace(){
		for(int i = 0; i < storage.length; i++){
			if(storage[i] == null){
				return i;
			}

		}
		throw new NullPointerException("нет свободного места на складе");
	}
	
	public void deleteGuitar(){
		
	}
	
	public int addPiano(){
		return indexInst;
	}
	public void deletePiano(){
		
	}
	
	public void addCustomer(String name, String phone, String mail){
		customer[3] = new Customer(name, phone, mail);
	}
	
	
	

}