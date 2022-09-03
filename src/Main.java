import java.util.*;

import Packages.AllInclusive;
import Packages.Breakfast;
import Packages.HalfBoard;
import Packages.PackageContext;
import Reservations.ReservationController;
import Reservations.ReservationModel;
import Rooms.King;
import Rooms.Hotel;
import Rooms.RoomModel;
import Rooms.Single;
import Rooms.Suite;
import Rooms.TwinBed;
import Users.Admin;
import Users.GuestController;
import Users.GuestModel;
import Users.ReceptionistController;
import Users.ReceptionistModel;
import Users.ReceptionistView;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Admin admin = new Admin();

		ReceptionistModel receptionistModel = retriveReceptionistFromDatabase();
		ReceptionistView receptionistViewer = new ReceptionistView();
		ReceptionistController receptionistController = new ReceptionistController(receptionistModel,
				receptionistViewer);

		GuestModel guestModel = retriveGuestFromDatabase();
		GuestController guestController = new GuestController(guestModel);

		RoomModel kingModel = retriveKingRoomFromDatabase();
		RoomModel suiteModel = retriveSuiteFromDatabase();
		RoomModel twinBedModel = retriveTwinBedRoomFromDatabase();
		RoomModel singleModel = retriveSingleRoomFromDatabase();

		Hotel king = new King(kingModel);
		Hotel suite = new Suite(suiteModel);
		Hotel twinBed = new TwinBed(twinBedModel);
		Hotel single = new Single(singleModel);

		ReservationModel reservationModel = new ReservationModel();
		ReservationController reservationController = new ReservationController(reservationModel);

		PackageContext allInclusive = new PackageContext(new AllInclusive());
		PackageContext breakfast = new PackageContext(new Breakfast());
		PackageContext halfBoard = new PackageContext(new HalfBoard());

		while (true) {

			System.out.println("1. Admin");
			System.out.println("2. Receptionist");
			System.out.println("3. Exit");
			System.out.print("Enter choice: ");
			int systemChoice = scanner.nextInt();

			// Admin
			if (systemChoice == 1) {

				System.out.println("Welcome Admin");
				System.out.println("1. Rooms");
				System.out.println("2. Packages");
				System.out.print("Enter choice: ");
				int actionChoice = scanner.nextInt();

				// Rooms
				if (actionChoice == 1) {
					System.out.println("1. Create king rooms");
					System.out.println("2. Create suites");
					System.out.println("3. Create twin bed rooms");
					System.out.println("4. Create single rooms");
					System.out.print("Enter choice: ");
					int roomChoice = scanner.nextInt();

					// King room
					if (roomChoice == 1) {
						System.out.print("Enter room price: ");
						double roomPrice = scanner.nextDouble();
						System.out.print("Enter number of rooms: ");
						int numberOfRooms = scanner.nextInt();
						king.setNumberOfRooms(numberOfRooms);
						System.out.print("Enter room view sea or garden: ");
						String roomView = scanner.next();

						admin.createRoom(king, roomPrice, numberOfRooms, roomView, "King room");

						System.out.println(king.getNumberOfRooms() + " King rooms has been created.");
					}

					// Suite
					else if (roomChoice == 2) {
						System.out.print("Enter room price: ");
						double roomPrice = scanner.nextDouble();
						System.out.print("Enter number of rooms: ");
						int numberOfRooms = scanner.nextInt();
						suite.setNumberOfRooms(numberOfRooms);
						System.out.print("Enter room view sea or garden: ");
						String roomView = scanner.next();

						admin.createRoom(suite, roomPrice, numberOfRooms, roomView, "Suite");

						System.out.println(suite.getNumberOfRooms() + " Suites has been created.");

					}

					// Twin bed
					else if (roomChoice == 3) {

						System.out.print("Enter room price: ");
						double roomPrice = scanner.nextDouble();
						System.out.print("Enter number of rooms: ");
						int numberOfRooms = scanner.nextInt();
						twinBed.setNumberOfRooms(numberOfRooms);
						System.out.print("Enter room view sea or garden: ");
						String roomView = scanner.next();

						admin.createRoom(twinBed, roomPrice, numberOfRooms, roomView, "Twin bed room");

						System.out.println(twinBed.getNumberOfRooms() + " Twin bed rooms has been created.");

					}

					// Single
					else if (roomChoice == 4) {
						System.out.print("Enter room price: ");
						double roomPrice = scanner.nextDouble();
						System.out.print("Enter number of rooms: ");
						int numberOfRooms = scanner.nextInt();
						single.setNumberOfRooms(numberOfRooms);
						System.out.print("Enter room view sea or garden: ");
						String roomView = scanner.next();

						admin.createRoom(single, roomPrice, numberOfRooms, roomView, "Single room");

						System.out.println(single.getNumberOfRooms() + " Single rooms has been created.");

					}

				}

				// Packages
				else if (actionChoice == 2) {
					System.out.print("Enter all inclusive price: ");
					double allInclusivePackagePrice = scanner.nextDouble();
					admin.setAllInclusivePrice(allInclusive, allInclusivePackagePrice);
					System.out.println("Price is added.");

					System.out.print("Enter breakfast only price: ");
					double breakfastPackagePrice = scanner.nextDouble();
					admin.setBreakfastPrice(breakfast, breakfastPackagePrice);
					System.out.println("Price is added.");

					System.out.print("Enter half board price: ");
					double halfBoardPackagePrice = scanner.nextDouble();
					admin.setHalfBoardPrice(halfBoard, halfBoardPackagePrice);
					System.out.println("Price is added.");
				}
			}

			// Receptionist
			else if (systemChoice == 2) {

				System.out.println("1. Create new guest record");
				System.out.println("2. Print recorded guests");
				System.out.println("3. Make reservation");
				System.out.println("4. Release reservation");
				System.out.println("5. Display available rooms");
				System.out.println("6. Display room details");
				System.out.print("Enter choice: ");
				int actionChoice = scanner.nextInt();

				// Create guest record
				if (actionChoice == 1) {
					receptionistController.setGuestController(guestController);
					System.out.print("Enter guest name: ");
					String guestName = scanner.next();
					System.out.print("Enter guest national id: ");
					int nationalId = scanner.nextInt();
					receptionistController.createGuestRecord(guestName, nationalId);
					System.out.println("New guest Record created");

				}

				// print recorded guests
				else if (actionChoice == 2) {
					receptionistController.updateGuestsDetails();

				}

				// Make reservation
				else if (actionChoice == 3) {
					System.out.println("choose a room:");
					System.out.println("1. King room");
					System.out.println("2. Suite");
					System.out.println("3. Twin bed room");
					System.out.println("4. Single room");
					System.out.print("Enter choice: ");
					int roomChoice = scanner.nextInt();

					// King room
					if (roomChoice == 1) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							admin.getRooms().get(i).setType("King room");
							if (receptionistController.getRecordedGuests().isEmpty()) {
								System.out.println("No guest to occupy.");
							}

							else if (admin.getRooms().get(i).isReserved()) {
								System.out.println("All king rooms are reserved.");
							} else {
								receptionistController.setReservationController(reservationController);
								System.out.print("Enter guest name: ");
								String guestName = scanner.next();

								System.out.print("Enter room number: ");
								int roomNumber = scanner.nextInt();
								for (int j = 0; j < receptionistController.getRecordedGuests().size();) {
									if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {

										System.out.println("choose view: ");
										System.out.println("Sea or Garden view? ");
										String roomView = scanner.next();
										admin.getRooms().get(roomNumber - 1).setView(roomView);
										System.out.print("Enter from date: ");
										String dateFrom = scanner.next();
										System.out.print("Enter date to: ");
										String dateTo = scanner.next();
										System.out.println("Select package:");
										System.out.println("1. All inclusive");
										System.out.println("2. Breakfast only");
										System.out.println("3. Half board");
										System.out.print("Enter choice: ");
										int packageChoice = scanner.nextInt();
										if (packageChoice == 1) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo,
													allInclusive);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved king room");
											break;
										}

										else if (packageChoice == 2) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, breakfast);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved king room");
											break;

										}

										else if (packageChoice == 3) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, halfBoard);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved king room");
											break;

										}

									} else {
										System.out.println("No guest has this name.");
										break;
									}
									break;
								}
								break;
							}
						}
					}

					// Suite
					else if (roomChoice == 2) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							admin.getRooms().get(i).setType("Suite");
							if (receptionistController.getRecordedGuests().isEmpty()) {
								System.out.println("No guest to occupy.");
							}

							else if (admin.getRooms().get(i).isReserved()) {
								System.out.println("All suites are reserved.");
							} else {
								receptionistController.setReservationController(reservationController);
								System.out.print("Enter guest name: ");
								String guestName = scanner.next();

								System.out.print("Enter room number: ");
								int roomNumber = scanner.nextInt();
								for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
									if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {

										System.out.println("choose view: ");
										System.out.println("Sea or Garden view? ");
										String roomView = scanner.next();
										admin.getRooms().get(roomNumber - 1).setView(roomView);
										System.out.print("Enter from date: ");
										String dateFrom = scanner.next();
										System.out.print("Enter date to: ");
										String dateTo = scanner.next();
										System.out.println("Select package:");
										System.out.println("1. All inclusive");
										System.out.println("2. Breakfast only");
										System.out.println("3. Half board");
										System.out.print("Enter choice: ");
										int packageChoice = scanner.nextInt();
										if (packageChoice == 1) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo,
													allInclusive);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved suite");
											break;
										}

										else if (packageChoice == 2) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, breakfast);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved suite");
											break;

										}

										else if (packageChoice == 3) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, halfBoard);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved suite");
											break;

										}

									} else {
										System.out.println("No guest has this name.");
									}
								}
							}
						}

					}

					// TwinBed
					else if (roomChoice == 3) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							admin.getRooms().get(i).setType("Twin bed room");
							if (receptionistController.getRecordedGuests().isEmpty()) {
								System.out.println("No guest to occupy.");
							}

							else if (admin.getRooms().get(i).isReserved()) {
								System.out.println("All Twin bed rooms are reserved.");
							} else {
								receptionistController.setReservationController(reservationController);
								System.out.print("Enter guest name: ");
								String guestName = scanner.next();

								System.out.print("Enter room number: ");
								int roomNumber = scanner.nextInt();
								for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
									if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {

										System.out.println("choose view: ");
										System.out.println("Sea or Garden view? ");
										String roomView = scanner.next();
										admin.getRooms().get(roomNumber - 1).setView(roomView);
										System.out.print("Enter from date: ");
										String dateFrom = scanner.next();
										System.out.print("Enter date to: ");
										String dateTo = scanner.next();
										System.out.println("Select package:");
										System.out.println("1. All inclusive");
										System.out.println("2. Breakfast only");
										System.out.println("3. Half board");
										System.out.print("Enter choice: ");
										int packageChoice = scanner.nextInt();
										if (packageChoice == 1) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo,
													allInclusive);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved twin bed room");
											break;
										}

										else if (packageChoice == 2) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, breakfast);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved twin bed room");
											break;

										}

										else if (packageChoice == 3) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, halfBoard);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved twin bed room");
											break;

										}

									} else {
										System.out.println("No guest has this name.");
									}
								}
							}
						}

					}

					// Single
					else if (roomChoice == 4) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							admin.getRooms().get(i).setType("Single room");
							if (receptionistController.getRecordedGuests().isEmpty()) {
								System.out.println("No guest to occupy.");
							}

							else if (admin.getRooms().get(i).isReserved()) {
								System.out.println("All single rooms are reserved.");
							} else {
								receptionistController.setReservationController(reservationController);
								System.out.print("Enter guest name: ");
								String guestName = scanner.next();

								System.out.print("Enter room number: ");
								int roomNumber = scanner.nextInt();
								for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
									if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {

										System.out.println("choose view: ");
										System.out.println("Sea or Garden view? ");
										String roomView = scanner.next();
										admin.getRooms().get(roomNumber - 1).setView(roomView);
										System.out.print("Enter from date: ");
										String dateFrom = scanner.next();
										System.out.print("Enter date to: ");
										String dateTo = scanner.next();
										System.out.println("Select package:");
										System.out.println("1. All inclusive");
										System.out.println("2. Breakfast only");
										System.out.println("3. Half board");
										System.out.print("Enter choice: ");
										int packageChoice = scanner.nextInt();
										if (packageChoice == 1) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo,
													allInclusive);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved single room");
											break;
										}

										else if (packageChoice == 2) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, breakfast);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved single room");
											break;

										}

										else if (packageChoice == 3) {
											receptionistController.makeReservation(
													receptionistController.getRecordedGuests().get(j),
													admin.getRooms().get(roomNumber - 1), dateFrom, dateTo, halfBoard);
											receptionistController.updateReceiptDetails();
											System.out.println("Guest "
													+ receptionistController.getRecordedGuests().get(i).getName()
													+ " has reserved single room");
											break;

										}

									} else {
										System.out.println("No guest has this name.");
									}
								}
							}
						}
					}
				}

				// release guest
				else if (actionChoice == 4) {
					System.out.println("choose a room:");
					System.out.println("1. King room");
					System.out.println("2. Suite");
					System.out.println("3. Twin bed room");
					System.out.println("4. Single room");
					System.out.print("Enter choice: ");

					int roomChoice = scanner.nextInt();

					if (roomChoice == 1) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							System.out.print("Enter guest name: ");
							String guestName = scanner.next();
							for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
								if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {
									receptionistController.release(admin.getRooms().get(j),
											receptionistController.getRecordedGuests().get(j));
									System.out.println(
											"Guest " + receptionistController.getRecordedGuests().get(j).getName()
													+ " is released");
									break;
								}
							}
							break;
						}

					}

					// suite
					else if (roomChoice == 2) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							System.out.print("Enter guest name: ");
							String guestName = scanner.next();
							for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
								if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {
									receptionistController.release(admin.getRooms().get(j),
											receptionistController.getRecordedGuests().get(j));
									System.out.println(
											"Guest " + receptionistController.getRecordedGuests().get(j).getName()
													+ " is released");
									break;
								}
							}
							break;
						}

					}

					// twin bed
					else if (roomChoice == 3) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							System.out.print("Enter guest name: ");
							String guestName = scanner.next();
							for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
								if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {
									receptionistController.release(admin.getRooms().get(j),
											receptionistController.getRecordedGuests().get(j));
									System.out.println(
											"Guest " + receptionistController.getRecordedGuests().get(j).getName()
													+ " is released");
									break;
								}
							}
							break;
						}

					}

					// single
					else if (roomChoice == 4) {
						for (int i = 0; i < admin.getRooms().size(); i++) {
							System.out.print("Enter guest name: ");
							String guestName = scanner.next();
							for (int j = 0; j < receptionistController.getRecordedGuests().size(); j++) {
								if (receptionistController.getRecordedGuests().get(j).getName().equals(guestName)) {
									receptionistController.release(admin.getRooms().get(j),
											receptionistController.getRecordedGuests().get(j));
									System.out.println(
											"Guest " + receptionistController.getRecordedGuests().get(j).getName()
													+ " is released");
									break;
								}
							}
							break;
						}

					}

				}

				// available rooms
				else if (actionChoice == 5) {
					for (int i = 0; i < admin.getRooms().size(); i++) {
						if (admin.getRooms().get(i).getType().equals("King room")) {
							System.out.println("Number of king rooms: " + admin.getRooms().get(i).getNumberOfRooms());
							break;
						} else if (admin.getRooms().get(i).getType().equals("Suite")) {
							System.out.println("Number of suite rooms: " + admin.getRooms().get(i).getNumberOfRooms());
							break;
						} else if (admin.getRooms().get(i).getType().equals("Twin bed room")) {
							System.out
									.println("Number of twin bed rooms: " + admin.getRooms().get(i).getNumberOfRooms());
							break;
						} else if (admin.getRooms().get(i).getType().equals("Single room")) {
							System.out.println("Number of single rooms: " + admin.getRooms().get(i).getNumberOfRooms());
							break;
						}
					}

				}

				// room details
				else if (actionChoice == 6) {
					receptionistController.setAdmin(admin);
					System.out.print("Enter room number: ");
					int roomNumber = scanner.nextInt();

					for (int i = 0; i < admin.getRooms().size(); i++) {
						if (admin.getRooms().get(i).getRoomNumber() == roomNumber) {
							receptionistController.updateRoomDetails(admin.getRooms().get(i));
							break;
						}

						else if (receptionistController.getReservationController().getRoomController()
								.getRoomNumber() == roomNumber) {
							receptionistController.updateReservationDetails();
							break;
						}
					}
				}

			}

			else if (systemChoice == 3) {
				System.exit(0);
			}

		}

	}

	private static RoomModel retriveKingRoomFromDatabase() {
		RoomModel king = new RoomModel();
		king.setNumberOfRooms(1000);
		king.setPrice(300);
		king.setReserved(false);
		king.setRoomNumber(1);
		king.setType("King Room");
		king.setView(null);
		return king;
	}

	private static RoomModel retriveSuiteFromDatabase() {
		RoomModel suite = new RoomModel();
		suite.setNumberOfRooms(1000);
		suite.setPrice(250);
		suite.setReserved(false);
		suite.setRoomNumber(1);
		suite.setType("Suite");
		suite.setView(null);
		return suite;
	}

	private static RoomModel retriveTwinBedRoomFromDatabase() {
		RoomModel twinBed = new RoomModel();
		twinBed.setNumberOfRooms(1000);
		twinBed.setPrice(200);
		twinBed.setReserved(false);
		twinBed.setRoomNumber(1);
		twinBed.setType("Twin Bed Room");
		twinBed.setView(null);
		return twinBed;
	}

	private static RoomModel retriveSingleRoomFromDatabase() {
		RoomModel single = new RoomModel();
		single.setNumberOfRooms(1000);
		single.setPrice(150);
		single.setReserved(false);
		single.setRoomNumber(1);
		single.setType("Single");
		single.setView(null);
		return single;
	}

	private static GuestModel retriveGuestFromDatabase() {
		GuestModel guest = new GuestModel();
		guest.setName(null);
		guest.setNationalId(0);
		guest.setNumberOfVisits(0);
		return guest;
	}

	private static ReceptionistModel retriveReceptionistFromDatabase() {
		ReceptionistModel receptionist = new ReceptionistModel();
		receptionist.setReservationController(null);
		return receptionist;
	}

}