
public class BnBReservation extends HotelReservation{
	
	public BnBReservation(String name, Hotel hotel, String roomType, int numOfNights) {
		super(name,hotel,roomType,numOfNights);
	}
	
	public int getCost() {
		return super.getCost() + this.getNumOfNights() * 10 * 100;
	}
}
