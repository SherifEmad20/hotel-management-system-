package Users;

import java.util.*;

import Reservations.ReservationController;
import Rooms.Hotel;

public class ReceptionistView {

	public void printGuestsDetails(ArrayList<GuestController> guest) {
		System.out.println("Guest details:");
		for (int i = 0; i < guest.size(); i++) {
			System.out.println("Guest name: " + guest.get(i).getName());
			System.out.println("Guest national id: " + guest.get(i).getNationalId());
			System.out.println("Guest number of visits: " + guest.get(i).getNumberOfVisits());
		}
	}

	public void printRoomDetails(Hotel room) {
		System.out.println("Room details: ");
		System.out.println("Room type: " + room.getType());
		System.out.println("Room price: " + room.getPrice());
		System.out.println("Room view: " + room.getView());
		System.out.println("Room number: " + room.getRoomNumber());
		if (room.isReserved()) {
			System.out.println("Room status: Reserved");
		} else
			System.out.println("Room status: Not reserved");

	}

	public void printReservationDetails(ReservationController reservation) {
		System.out.println("Guest details:");
		System.out.println("Guest name: " + reservation.getGuestController().getName());
		System.out.println("Guest national id: " + reservation.getGuestController().getNationalId());
		System.out.println("Guest number of visits: " + reservation.getGuestController().getNumberOfVisits());
		System.out.println();
		System.out.println("Room details: ");
		System.out.println("Room type: " + reservation.getRoomController().getType());
		System.out.println("Room price: " + reservation.getRoomController().getPrice());
		System.out.println("Room view: " + reservation.getRoomController().getView());
		System.out.println("Room number: " + reservation.getRoomController().getRoomNumber());
	}

	public void printReceipt(ReservationController reservation) {
		System.out.println("Receipt:");
		System.out.println("Guest name: " + reservation.getGuestController().getName());
		System.out.println("Guest national id: " + reservation.getGuestController().getNationalId());
		System.out.println("Guest number of visits: " + reservation.getGuestController().getNumberOfVisits());

		System.out.println("Room type: " + reservation.getRoomController().getType());
		System.out.println("Room price: " + reservation.getRoomController().getPrice());
		System.out.println("Room view: " + reservation.getRoomController().getView());
		System.out.println("Room number: " + reservation.getRoomController().getRoomNumber());

		System.out.println("Package chosen: " + reservation.getPackageContext().getPackageType());
		System.out.println("Package price: " + reservation.getPackageContext().getPrice());

		System.out.println("Date from: " + reservation.getDateFrom());
		System.out.println("Date to: " + reservation.getDateTo());
		System.out.println("Total price: " + reservation.getTotalPrice());

	}

}
