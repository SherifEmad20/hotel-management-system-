package Rooms;

import java.util.*;

import Users.GuestController;

public class RoomModel {

	private ArrayList<GuestController> guestsInRoom; // number of guests in the current room

	private int numberOfRooms = 0; // number of rooms of each type in the hotel
	private int roomNumber; // room number
	private double price; // price of the room
	private boolean reserved; // check if room is reserved or not

	private String view; // Sea view or garden view
	private String type; // type of each room

	public RoomModel() {
		this.roomNumber = numberOfRooms;
		this.guestsInRoom = new ArrayList<>();
		this.reserved = false;
	}

	public ArrayList<GuestController> getGuestsInRoom() {
		return guestsInRoom;
	}

	public void setGuestsInRoom(GuestController guestsInRoom) {
		this.guestsInRoom.add(guestsInRoom);
	}

	public void removeGuestFromRoom(GuestController guestsInRoom) {
		this.guestsInRoom.remove(guestsInRoom);

	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfRooms() {
		return this.numberOfRooms;
	}

	public void setView(String view) {

		this.view = view;
	}

	public String getView() {
		return view;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public double getPrice() {

		return price;
	}

	public boolean getReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
