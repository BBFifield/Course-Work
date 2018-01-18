/**
 * This class creates a campsite.
 * @author Brandon Fifield, Student ID: 201238730
 */

public class Campsite {
	
	private String parkName;
	private String province;
	private double costPerNight;
	
	/**
	 * Constructs a Campsite object.
	 * @param parkName - the name of the park.
	 * @param province - the name of the province the park is in.
	 * @param costPerNight - the cost for each night to stay in the park.
	 */
	public Campsite(String parkName, String province, double costPerNight) {
		this.parkName = parkName;
		this.province = province;
		this.costPerNight = costPerNight;
	}

    /**
	 * Gets the name of the park.
	 * @return the name of the park.
	 */
	public String getParkName() {
		return parkName;
	}
	
	/**
	 * Sets the name of the park.
	 * @param parkName - the name of the park to be set.
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	/**
	 * Gets the province the park is in.
	 * @return the province the park is in.
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Sets the province the park is in.
	 * @param province - the province the park is to be in.
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Gets the cost per night to stay in the park.
	 * @return the cost per night to stay in the park.
	 */
	public Double getCostPerNight() {
		return costPerNight;
	}

	/**
	 * Sets the cost per night to stay in the park.
	 * @param costPerNight - the cost to stay at the park for one night.
	 */
	public void setCostPerNight(double costPerNight) {
		this.costPerNight = costPerNight;
	}

	/**
	 * Convert all the info of the campsite into one big string.
	 * @return the string.
	 */
	public String toString() {
		return String.format("Park name: %s%nProvince: %s%nCost per night: $%1.2f%n", parkName, province, costPerNight);
	}
}
