
public class Hotel {
	private String name;
	private Room[] rooms;
	
	//IDK if this works for the deep copy
	public Hotel(String name, Room[] rooms) {
		//initializes the array of correct length
		this.rooms = new Room[rooms.length];
		this.name=name;
		for (int i=0; i<rooms.length;i++) {
			//IDK if this works for the deep copy
			this.rooms[i] = new Room(rooms[i]);
		}
	}
	
	public int reserveRoom(String type) {
		Room room = Room.findAvailableRoom(rooms, type);
		if(room!=null) {
			room.changeAvailability();
			return room.getPrice();
		}
		throw new IllegalArgumentException();
	}
	
	public boolean cancelRoom(String type) {
		return Room.makeRoomAvailable(rooms, type);
	}
}
