// Rooms controller

package Rooms;

import java.util.*;

import Users.GuestController;

public class Hotel {

	private RoomModel roomModel;

	public Hotel(RoomModel roomModel) {
		this.roomModel = roomModel;
	}

	public ArrayList<GuestController> getGuestsInRoom() {
		return roomModel.getGuestsInRoom();
	}

	public void setGuestsInRoom(GuestController guestsInRoom) {
		roomModel.setGuestsInRoom(guestsInRoom);
	}

	public int getNumberOfRooms() {
		return roomModel.getNumberOfRooms();
	}

	public void setNumberOfRooms(int numberOfRooms) {
		roomModel.setNumberOfRooms(numberOfRooms);
	}

	public int getRoomNumber() {
		return roomModel.getRoomNumber();
	}

	public void setRoomNumber(int roomNumber) {
		roomModel.setRoomNumber(roomNumber);
	}

	public String getView() {
		return roomModel.getView();
	}

	public void setView(String view) {
		roomModel.setView(view);
	}

	public double getPrice() {
		return roomModel.getPrice();
	}

	public void setPrice(double price) {
		roomModel.setPrice(price);
	}

	public void setType(String type) {
		roomModel.setType(type);
	}

	public String getType() {
		return roomModel.getType();
	}

	public boolean isReserved() {

		if (roomModel.getGuestsInRoom().isEmpty()) {
			roomModel.setReserved(false);
		}

		else {
			roomModel.setReserved(true);
		}

		return roomModel.getReserved();
	}

	public void addGuestToRoom(GuestController guest) {
		roomModel.setGuestsInRoom(guest);
		roomModel.setReserved(true);
	}

	public void removeGuestFromRoom(GuestController guest) {
		roomModel.removeGuestFromRoom(guest);
		roomModel.setReserved(false);
	}

}
