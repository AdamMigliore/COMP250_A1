
public class HotelReservation extends Reservation{
	private Hotel hotel;
	private String type;
	private int numberOfNights;
	private int pricePerNight;
	
	public HotelReservation(String name, Hotel hotel, String type, int numberOfNights) {
		super(name);
		this.hotel = hotel;
		this.type = type;
		this.numberOfNights = numberOfNights;
		throw new IllegalArgumentException();
	}
}
