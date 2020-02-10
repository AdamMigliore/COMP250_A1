
public class Basket {
	private Reservation[] reservations;

	public Basket() {
		// idk
		reservations = new Reservation[0];
	}

	public Reservation[] getProducts() {
		return reservations;
	}

	// maybe works
	public int add(Reservation reservation) {
		Reservation[] temp = new Reservation[reservations.length + 1];
		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = reservations[i];
		}
		temp[temp.length - 1] = reservation;
		reservations = new Reservation[reservations.length + 1];
		for (int i = 0; i < temp.length; i++) {
			this.reservations[i] = temp[i];
		}

		return reservations.length;
	}

	public boolean remove(Reservation reservation) {
		Reservation[] temp = new Reservation[reservations.length];
		int tempIndex = 0;
		boolean instanceDeleted = false;

		// copies all of the reservations that arent the same in subsequent order in
		// temp
		for (int i = 0; i < reservations.length; i++) {
			if (instanceDeleted || !reservation.equals(reservations[i])) {
				temp[tempIndex] = reservations[i];
				tempIndex++;
			} else {
				instanceDeleted = true;
			}
		}

		// if the last element of temp is not null that means all of the objects have
		// been copied
		if (temp[temp.length - 1] != null) {
			return false;
		}

		// we remake reservations to the new size
		reservations = new Reservation[temp.length - 1];

		for (int i = 0; i < reservations.length; i++) {
			reservations[i] = temp[i];
		}

		return true;
	}

	public void clear() {
		this.reservations = new Reservation[0];
	}

	public int getNumOfReservations() {
		return reservations.length;
	}

	public int getTotalCost() {
		int totalCost = 0;
		for (int i = 0; i < reservations.length; i++) {
			totalCost += reservations[i].getCost();
		}
		return totalCost;
	}

}
