/**
 * This class creates a serviced campsite which extends class Front Country. 
 * @author Brandon Fifield, Student ID: 201238730
 */

public class Serviced extends FrontCountry {

	private int ampService;
	private String waterService;

	/**
	 * Constructs Serviced campsite object.
	 * @param parkName - the name of the park.
	 * @param province - the province the park is in.
	 * @param costPerNight - the cost per night to stay at the park.
	 * @param campgroundName - the name of the camp ground.
	 * @param siteNumber - the number of the site at the campground.
	 * @param firepit - "Yes" or "No" to whether the campGround has a firepit.
	 * @param ampService - 15, 30 or 50 amps.
	 * @param waterService - Yes or No to whether the campsite has water service.
	 */
	public Serviced(String parkName, String province, double costPerNight, String campgroundName, String siteNumber, String firepit, int ampService, String waterService) {
		super(parkName, province, costPerNight, campgroundName, siteNumber, firepit);
		this.ampService = ampService;
		this.waterService = waterService;
	}

	/**
	 * Gets the amp service for the camp site.
	 * @return the integer value of the amp service.
	 */
	public int getAmpService() {
		return ampService;
	}

	/**
	 * Sets the amp service for the camp site.
	 * @param ampService the integer value of the amp service to be set.
	 */
	public void setAmpService(int ampService) {
		this.ampService = ampService;
	}	
	
	/**
	 * Gets whether or not the camp site has water service.
	 * @return the string value of yes or no for whether the camp site has water service.
	 */
	public String getWaterService() {
		return waterService;
	}

	/**
	 * Sets whether or not the serviced camp site has water service.
	 * @param waterService - Yes or no to water service..
	 */
	public void setWaterService(String waterService) {
		this.waterService = waterService;
	}

	/**
	 * Converts all the info of the serviced campsite into a neat big string.
	 * @return the string representation of the serviced object.
	 */
	public String toString() {
		return super.toString() + String.format("Amp Service: %d%nWater Service: %s%n", ampService, waterService);
	}
}
