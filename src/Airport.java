
public class Airport {
	//class variables
	private int xCoordinate;//scale: 1 unit = 1 km
	private int yCoordinate;//scale: 1 unit = 1 km
	private int airportFees;//in cents
	
	//constructor taking in 3 integers as parameters
	//initializes each parameter
	public Airport(int xCoordinate, int yCoordinate, int airportFees) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.airportFees = airportFees;
	}
	
	//getter for airportFees
	public int getFees() {
		return this.airportFees;
	}
	
	//returns an int: the distance between airportA and airportB
	//calculates x and y coordinate and plugs it into the distance formula
	public static int getDistance(Airport airportA, Airport airportB) {
		int x = airportA.xCoordinate - airportB.xCoordinate;
		int y = airportA.yCoordinate - airportB.yCoordinate;
		double distance = Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2));
		return (int) Math.ceil(distance);
	}
}
