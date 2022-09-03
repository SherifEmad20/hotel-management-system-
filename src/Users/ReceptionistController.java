package Users;

import java.util.ArrayList;

import Packages.PackageContext;
import Reservations.ReservationController;
import Rooms.Hotel;

public class ReceptionistController {

	private ReceptionistModel receptionistModel;
	private ReceptionistView receptionistViewer;

	public ReceptionistController(ReceptionistModel receptionistModel, ReceptionistView receptionistViewer) {
		this.receptionistModel = receptionistModel;
		this.receptionistViewer = receptionistViewer;
	}

	public ReservationController getReservationController() {
		return receptionistModel.getReservationController();
	}

	public void setReservationController(ReservationController reservationController) {
		receptionistModel.setReservationController(reservationController);
	}

	public GuestController getGuestController() {
		return receptionistModel.getGuestController();
	}

	public void setGuestController(GuestController guestController) {
		receptionistModel.setGuestController(guestController);
	}

	public ArrayList<GuestController> getRecordedGuests() {
		return receptionistModel.getRecordedGuests();
	}

	public void setGuestsInRoom(GuestController guestsInRoom) {
		receptionistModel.setRecordedGuests(guestsInRoom);
	}

	public Admin getAdmin() {
		return receptionistModel.getAdmin();
	}

	public void setAdmin(Admin admin) {
		receptionistModel.setAdmin(admin);
	}

	public void release(Hotel room, GuestController guest) {
		room.removeGuestFromRoom(guest);
		room.setNumberOfRooms(room.getNumberOfRooms() + 1);
	}

	public void createGuestRecord(String name, int natId) {
		GuestModel model = new GuestModel();
		GuestController guest = new GuestController(model);

		guest.setName(name);
		guest.setNationalId(natId);
		guest.setNumberOfVisits(0);
		guest.setCheckInRequest(true);
		receptionistModel.setRecordedGuests(guest);
	}

	public void makeReservation(GuestController guest, Hotel room, String dateFrom, String dateTo,
			PackageContext packageDeal) {

		receptionistModel.setRecordedGuests(guest);
		room.addGuestToRoom(guest);
		room.setNumberOfRooms(room.getNumberOfRooms() - 1);

		receptionistModel.getReservationController().setGuestController(guest);
		receptionistModel.getReservationController().setRoomController(room);
		receptionistModel.getReservationController().setPackageContext(packageDeal);
		receptionistModel.getReservationController().setDateFrom(dateFrom);
		receptionistModel.getReservationController().setDateTo(dateTo);
		receptionistModel.getReservationController().setTotalPrice(room.getPrice() + packageDeal.getPrice());

	}

	public void updateGuestsDetails() {
		receptionistViewer.printGuestsDetails(receptionistModel.getRecordedGuests());
	}

	public void updateReservationDetails() {
		receptionistViewer.printReservationDetails(receptionistModel.getReservationController());
	}

	public void updateRoomDetails(Hotel room) {
		receptionistViewer.printRoomDetails(room);
	}

	public void updateReceiptDetails() {
		receptionistViewer.printReceipt(receptionistModel.getReservationController());
	}

}
