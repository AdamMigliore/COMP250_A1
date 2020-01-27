
public class Customer {
	private String name;
	private int balance;
	private Basket myBasket;// might be wrong

	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
		myBasket = new Basket();// change if not good
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	// IDK if well implemented
	public Basket getBasket() {
		return myBasket;
	}

	public int addFunds(int balanceAdded) {
		if (balanceAdded > 0) {
			balance = balance + balanceAdded;
			return balance;
		}
		throw new IllegalArgumentException("You must enter a positive amount to be added.");
	}

	public int addToBasket(Reservation reservation) {
		if (reservation.reservationName().equalsIgnoreCase(name)) {
			return myBasket.add(reservation);
		}
		throw new IllegalArgumentException();
	}

	public int addToBasket(Hotel hotel, String roomType, int numOfNights, boolean breakfastIncluded) {
		int basketSize;
		if (breakfastIncluded) {
			basketSize = myBasket.add(new BnBReservation(name, hotel, roomType, numOfNights));
		} else {
			basketSize = myBasket.add(new HotelReservation(name, hotel, roomType, numOfNights));
		}
		return basketSize;
	}

	public int addToBasket(Airport departure, Airport arrival) {
		return myBasket.add(new FlightReservation(name, departure, arrival));
	}

	public boolean removeFromBasket(Reservation reservation) {
		return myBasket.remove(reservation);
	}

	public int checkOut() {
		if (balance < myBasket.getTotalCost()) {
			throw new IllegalStateException();
		}else {
			balance = balance - myBasket.getTotalCost();
			myBasket.clear();
		}
		return balance;
	}

}
