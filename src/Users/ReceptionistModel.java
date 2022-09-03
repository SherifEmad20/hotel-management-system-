package Users;

import java.util.*;

import Reservations.ReservationController;

public class ReceptionistModel {

	private ReservationController reservationController;
	private GuestController guestController;

	private Admin admin;

	private ArrayList<GuestController> recordedGuests = new ArrayList<GuestController>();

	public ArrayList<GuestController> getRecordedGuests() {
		return recordedGuests;
	}

	public void setRecordedGuests(GuestController recordedGuests) {
		this.recordedGuests.add(recordedGuests);
	}

	public ReservationController getReservationController() {
		return reservationController;
	}

	public void setReservationController(ReservationController reservationController) {
		this.reservationController = reservationController;
	}

	public GuestController getGuestController() {
		return guestController;
	}

	public void setGuestController(GuestController guestController) {
		this.guestController = guestController;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
