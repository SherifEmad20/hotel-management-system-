package Users;

public class GuestModel {

	private String name;
	private int nationalId;
	private int numberOfVisits;
	private boolean checkInRequest;

	public String getName() {
		return name;
	}

	public int getNationalId() {
		return nationalId;
	}

	public int getNumberOfVisits() {
		return numberOfVisits;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}

	public void setNumberOfVisits(int numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}

	public boolean isCheckInRequest() {
		return checkInRequest;
	}

	public void setCheckInRequest(boolean checkInRequest) {
		this.checkInRequest = checkInRequest;
	}

}
