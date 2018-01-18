/**
 * This class creates a front country campsite which extends class Campsite.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class FrontCountry extends Campsite {

	private String campgroundName;
	private String siteNumber;
	private String firepit;
	
	/**
	 * Constructs FrontCountry object.
	 * @param parkName - the name of the park.
	 * @param province - the province the park is in.
	 * @param costPerNight - the cost per night to stay at the park.
	 * @param campgroundName - the name of the camp ground.
	 * @param siteNumber - the number of the site at the campground.
	 * @param firepit - "Yes" or "No" to whether the campGround has a firepit.
	 */
	public FrontCountry(String parkName, String province, double costPerNight, String campgroundName, String siteNumber, String firepit) {
		super(parkName, province, costPerNight);
		this.campgroundName = campgroundName;
		this.siteNumber = siteNumber;
		this.firepit = firepit;
	}
	
	/**
	 * Gets the name of the campground.
	 * @return the name of the campground.
	 */
	public String getCampgroundName() {
		return campgroundName;
	}

	/**
	 * Sets the campground name.
	 * @param campgroundName - the name to be set for this campground.
	 */
	public void setCampgroundName(String campgroundName) {
		this.campgroundName = campgroundName;
	}

	/**
	 * Gets the site number.
	 * @return the site number.
	 */
	public String getSiteNumber() {
		return siteNumber;
	}

	/**
	 * Sets the site number at the campground.
	 * @param siteNumber - the site number to be set for the campground.
	 */
	public void setSiteNumber(String siteNumber) {
		this.siteNumber = siteNumber;
	}

	/**
	 * Gets whether or not the campground has a firepit.
	 * @return Yes or No to whether the campground has a firepit.
	 */
	public String getFirepit() {
		return firepit; 
	}

	/**
	 * Sets whether or not the campground has a firepit (Yes or No).
	 * @param firepit - Yes or No to whether the campground has a firepit.
	 */
	public void setFirePit(String firepit) {
		this.firepit = firepit;
	}

	/**
	 * Converts all the info about this front country object into a big string.
	 * @return the string representation of this front country object.
	 */
	public String toString() {
		return super.toString() + String.format("Campground name: %s%nSite number: %s%nFirepit: %s%n", campgroundName, siteNumber, firepit);
	}
}
	
