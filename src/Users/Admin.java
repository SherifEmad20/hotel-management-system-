package Users;

import java.util.*;

import Packages.PackageContext;
import Rooms.Hotel;
import Rooms.RoomModel;

public class Admin {

	private ArrayList<Hotel> rooms;

	public Admin() {
		this.rooms = new ArrayList<>();
	}

	public ArrayList<Hotel> getRooms() {
		return rooms;
	}

	public void createRoom(Hotel roomType, double price, int numberOfRooms, String roomView, String roomTitle) {
		for (int i = 0; i < numberOfRooms; i++) {
			RoomModel model = new RoomModel();
			roomType = new Hotel(model);
			roomType.setPrice(price);
			roomType.setRoomNumber(i + 1);
			roomType.setNumberOfRooms(numberOfRooms);
			roomType.setType(roomTitle);
			roomType.setView(roomView);
			rooms.add(roomType);
		}
	}

	public void setAllInclusivePrice(PackageContext packageContext, double packagePrice) {
		packageContext.executeStrategy("All Inclusive", packagePrice);

	}

	public void setBreakfastPrice(PackageContext packageContext, double packagePrice) {
		packageContext.executeStrategy("Breakfast only", packagePrice);

	}

	public void setHalfBoardPrice(PackageContext packageContext, double packagePrice) {
		packageContext.executeStrategy("Half board", packagePrice);

	}

}
