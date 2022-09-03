package Reservations;

import Packages.PackageContext;
import Rooms.Hotel;
import Users.GuestController;

public class ReservationController {
	private ReservationModel reservationModel;

	public ReservationController(ReservationModel reservationModel) {
		this.reservationModel = reservationModel;
	}

	public String getDateFrom() {
		return reservationModel.getDateFrom();
	}

	public void setDateFrom(String dateFrom) {
		reservationModel.setDateFrom(dateFrom);
	}

	public String getDateTo() {
		return reservationModel.getDateTo();
	}

	public void setDateTo(String dateTo) {
		reservationModel.setDateTo(dateTo);
	}

	public PackageContext getPackageContext() {
		return reservationModel.getPackageContext();
	}

	public void setPackageContext(PackageContext packageContext) {
		reservationModel.setPackageContext(packageContext);
	}

	public Hotel getRoomController() {
		return reservationModel.getRoomController();
	}

	public void setRoomController(Hotel room) {
		reservationModel.setRoomController(room);
	}

	public GuestController getGuestController() {
		return reservationModel.getGuestController();
	}

	public void setGuestController(GuestController guest) {
		reservationModel.setGuestController(guest);
	}

	public void setTotalPrice(double totalPrice) {
		reservationModel.setTotalPrice(totalPrice);
	}

	public double getTotalPrice() {
		return reservationModel.getTotalPrice();
	}
}
