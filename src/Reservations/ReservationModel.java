package Reservations;

import Packages.PackageContext;
import Rooms.Hotel;
import Users.GuestController;

public class ReservationModel {

	private String dateFrom;
	private String dateTo;

	private double totalPrice;

	private PackageContext packageContext;
	private Hotel room;
	private GuestController guest;

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public PackageContext getPackageContext() {
		return packageContext;
	}

	public void setPackageContext(PackageContext packageContext) {
		this.packageContext = packageContext;
	}

	public Hotel getRoomController() {
		return room;
	}

	public void setRoomController(Hotel rooms) {
		this.room = rooms;
	}

	public GuestController getGuestController() {
		return guest;
	}

	public void setGuestController(GuestController guest) {
		this.guest = guest;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
