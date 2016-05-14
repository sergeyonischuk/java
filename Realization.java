package shop;



public class Realization {
	
	private Instrument instrument;
	private Customer customer;
	private int sum;
	private String date;
	private int amount;
	
	public Realization(Instrument instrument, Customer customer, int sum, int amount, String date){
		this.instrument = instrument;
		this.customer = customer;
		this.sum = sum;
		this.amount = amount;
		this.date = date;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getData() {
		return date;
	}

	public int getSum() {
		return sum;
	}

	public String getDate() {
		return date;
	}

	public int getAmount() {
		return amount;
	}
	
	

}
