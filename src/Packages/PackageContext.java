// Package Controller

package Packages;

public class PackageContext {

	private PackageStrategy packageStrategy; // type of package

	public PackageContext(PackageStrategy packageStrategy) {
		this.packageStrategy = packageStrategy;
	}

	public void executeStrategy(String packageType, double price) {

		packageStrategy.setPackageType(packageType);
		packageStrategy.setPrice(price);

	}

	public double getPrice() {
		return packageStrategy.getPrice();
	}

	public String getPackageType() {
		return packageStrategy.getPackageType();
	}

}
