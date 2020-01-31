
public class FlightReservation extends Reservation {
	private Airport departure;
	private Airport arrival;

	public FlightReservation(String name, Airport departure, Airport arrival) {
		super(name);
		if (departure.equals(arrival)) {
			throw new IllegalArgumentException();
		}
		this.departure = departure;
		this.arrival = arrival;
	}

	// =========== ERROR HERE [5] ===========\\
	public int getCost() {
		final double CENTS_PER_GALLON = 1.24 * 100;
		final double KM_PER_GALLON = 167.52;
		final double FIXED_COST = 53.75 * 100;
		double gallons = Airport.getDistance(departure, arrival) / KM_PER_GALLON;
		double fuelCost = gallons * CENTS_PER_GALLON;
		int totalCost = (int) Math.ceil(FIXED_COST + departure.getFees() + arrival.getFees() + fuelCost);

		System.out.println(" Gallons: " + gallons + " fuelCost: " + fuelCost + " departure fee: " + departure.getFees()
				+ " arrival fee: " + arrival.getFees() + " fixed cost: " + FIXED_COST + " = " + totalCost);
		return totalCost;
	}

	public boolean equals(Object object) {
		if (object instanceof FlightReservation && ((FlightReservation) object).arrival.equals(this.arrival)
				&& ((FlightReservation) object).departure.equals(this.departure)
				&& ((FlightReservation) object).reservationName().equals(this.reservationName())) {
			return true;
		}
		return false;
	}

}
