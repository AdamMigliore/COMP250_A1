
public class HotelReservation extends Reservation{
	private Hotel hotel;
	private String roomType;
	private int numOfNights;
	private int pricePerNight;
	
	public HotelReservation(String name, Hotel hotel, String roomType, int numOfNights) {
		super(name);
		this.hotel = hotel;
		this.roomType = roomType;
		try {
		pricePerNight = hotel.reserveRoom(roomType);
		}catch (IllegalArgumentException e) {
			throw e;
		}
		this.numOfNights = numOfNights;
		
	}
	
	public int getNumOfNights() {
		return numOfNights;
	}
	

	@Override
	public int getCost() {
		return pricePerNight * numOfNights;
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof HotelReservation 
				&& ((HotelReservation) object).reservationName().equals(this.reservationName())
				&& ((HotelReservation) object).hotel.equals(this.hotel)
				&& ((HotelReservation) object).numOfNights==this.numOfNights
				&& ((HotelReservation) object).getCost()==this.getCost() 
				&& ((HotelReservation) object).roomType.equals(this.roomType)) {
			return true;
		}
		return false;
	}
}
