
public class FlightReservation extends Reservation {
	private Airport departure;
	private Airport arrival;

	public FlightReservation(String name, Airport departure, Airport arrival) {
		super(name);
		if (departure != arrival) {
			this.departure = departure;
			this.arrival = arrival;
		}
		throw new IllegalArgumentException();
	}
	
	public int getCost() {
		final double CENTS_PER_GALLON = 1.24 * 100;
		final double KM_PER_GALLON = 167.52;
		final double FIXED_COST = 53.75 * 100;
		return (int) Math.ceil( departure.getFees() + arrival.getFees() + (((Airport.getDistance(departure, arrival) / KM_PER_GALLON) * CENTS_PER_GALLON) + FIXED_COST)) ;
	}
	
	public boolean equals(Object object) {
		if(object.getClass()==this.getClass() 
			&& ( (FlightReservation) object ).arrival == this.arrival
			&& ( (FlightReservation) object).departure == this.departure
			&& ( (FlightReservation) object).reservationName().equalsIgnoreCase(this.reservationName() )){
				return true;
			}
		return false;
	}

}
