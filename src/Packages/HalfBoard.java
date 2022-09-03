package Packages;

public class HalfBoard implements PackageStrategy {

	private double price;
	private String packageType;
	
	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	@Override
	public String getPackageType() {
		return packageType;
	}

}
