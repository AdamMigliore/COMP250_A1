
public class Room {
	// class variables
	private String type;// double, queen, king
	private int price;// in cents
	private boolean available;

	public Room(String type) {
		if (type.equalsIgnoreCase("Double") || type.equalsIgnoreCase("Queen") || type.equalsIgnoreCase("King")) {
			this.type = type.toLowerCase();
			this.available = true;

			switch (type.toLowerCase()) {
			case "double":
				this.price = 90 * 100;
				break;
			case "queen":
				this.price = 110 * 100;
				break;
			case "king":
				this.price = 150 * 100;
				break;
			}

		} else {
			throw new IllegalArgumentException("No room of that type can be created.");
		}
	}

	public Room(Room room) {
		this.type = room.type;
		this.available = room.available;
		this.price = room.price;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	public void changeAvailability() {
		available = !available;
	}

	// Legal for private method but idk if it will work
	private boolean isAvailable() {
		return available;
	}

	public static Room findAvailableRoom(Room[] rooms, String type) {
		for (int i = 0; i < rooms.length; i++) {
			// IDK if it will work with isAvailable
			if (type.equalsIgnoreCase(rooms[i].getType()) && rooms[i].isAvailable()) {
				return rooms[i];
			}
		}
		return null;
	}

	public static boolean makeRoomAvailable(Room[] rooms, String type) {
		for (int i = 0; i < rooms.length; i++) {
			if (type.equalsIgnoreCase(rooms[i].getType()) && !rooms[i].isAvailable()) {
				rooms[i].changeAvailability();
				return true;
			}
		}
		return false;

	}

}
