package Users;

public class GuestController {

	private GuestModel guestModel;

	public GuestController(GuestModel guestModel) {
		this.guestModel = guestModel;
		this.guestModel.setCheckInRequest(true);
	}

	public String getName() {
		return guestModel.getName();
	}

	public int getNationalId() {
		return guestModel.getNationalId();
	}

	public int getNumberOfVisits() {
		return guestModel.getNumberOfVisits();
	}

	public void setName(String name) {
		guestModel.setName(name);
	}

	public void setNationalId(int nationalId) {
		guestModel.setNationalId(nationalId);
	}

	public void setNumberOfVisits(int numberOfVisits) {
		guestModel.setNumberOfVisits(numberOfVisits);
	}

	public boolean isCheckInRequest() {
		return guestModel.isCheckInRequest();
	}

	public void setCheckInRequest(boolean checkInRequest) {
		guestModel.setCheckInRequest(checkInRequest);
	}

}
