
public class Customer {
	private String name;
	private int balance;
	private Basket reservations;//might be wrong
	
	public Customer(String name, int balance){
		this.name = name;
		this.balance = balance;
		reservations = new Basket();//change if not good
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	//IDK if well implemented
	public Basket getBasket() {
		return reservations;
	}
	
	public int addFunds(int balanceAdded) {
		if(balanceAdded>0) {
			balance = balance + balanceAdded;
			return balance;
		}
		throw new IllegalArgumentException("You must enter a positive amount to be added.");
	}
	
}
