
public class BnBReservation extends HotelReservation{
	
	public BnBReservation(String name, Hotel hotel, String roomType, int numOfNights) {
		super(name,hotel,roomType,numOfNights);
	}
	
	//idk if this works
	public int getCost() {
		return super.getCost() + 10 * 100;
	}
}
