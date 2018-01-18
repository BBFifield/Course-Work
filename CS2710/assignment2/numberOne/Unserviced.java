/**
 * This class creates an unserviced camp site which extends the Front Country class.
 * @author Brandon Fifield, Student ID: 201238730.
 */
public class Unserviced extends FrontCountry {

	private String generatorUsage;

	/**
	 * Constructs Unserviced campsite object.
	 * @param parkName - the name of the park.
	 * @param province - the province the park is in.
	 * @param costPerNight - the cost per night to stay at the park.
	 * @param campgroundName - the name of the camp ground.
	 * @param siteNumber - the number of the site at the campground.
	 * @param firepit - "Yes" or "No" to whether the campGround has a firepit.
	 * @param generatorUsage - Yes or No to whether the campsite uses generator power.
	 */
	public Unserviced(String parkName, String province, double costPerNight, String campgroundName, String siteNumber, String firepit, String generatorUsage) {
		super(parkName, province, costPerNight, campgroundName, siteNumber, firepit);
		this.generatorUsage = generatorUsage;
	}

	/**
	 * Gets whether or not the campsite uses generator power.
 	 * @return the string value "Yes" or "No" for generator powered.
	 */
	public String getGeneratorUsage() {
		return generatorUsage;
	}

	/**
	 * Sets whether or not the campsite uses generator power.
 	 * @param generatorUsage - set the generator powered to be "Yes" or "No".
	 */
	public void setGeneratorUsage(String generatorUsage) {
		this.generatorUsage = generatorUsage;
	}

	/**
	 * Gets all the info of the unserviced campsite object and converts it into a big string.
 	 * @return the string representation of the unserviced campsite object.
	 */
	public String toString() {
		return super.toString() + String.format("Generator Usage: %s%n", generatorUsage);
	}
}
