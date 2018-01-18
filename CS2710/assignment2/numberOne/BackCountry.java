/**
 * This class creates a back country campsite which extends class Campsite.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class BackCountry extends Campsite {

	private String location;
	private String modeOfTravel;

	/**
	 * Constructs BackCountry object.
	 * @param parkName - the name of the park.
	 * @param province - the province the park is in.
	 * @param costPerNight - the cost per night to stay at the park.
	 * @param location - the location of the back country.
	 * @param modeOfTravel - the method of travel to get to the location.
	 */
	public BackCountry(String parkName, String province, double costPerNight, String location, String modeOfTravel) {
		super(parkName, province, costPerNight);
		this.location = location;
		this.modeOfTravel = modeOfTravel;
	}

	/**
	 * Gets the location of the back country.
	 * @return the location of the back country.
	 */
	public String getLocation() {
		return location;
	}

	/**
     * Sets the location of the back country.
	 * @param location - the location the back country is set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the method of travel to get to the back country.
	 * @return the method of travel to get to the back country.
	 */
	public String getModeOfTravel() {
		return modeOfTravel;
	}

	/**
     * Sets the mode of travel used to get to the location of the back country.
	 * @param modeOfTravel - the method of travel to be set.
	 */
	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}

	/**
     * Converts all the info about the back country object into a string.
	 * @return the string representation of the back country object.
	 */
	public String toString() {
		return super.toString() + String.format("Location: %s%nMode of Travel: %s%n", location, modeOfTravel);
	}

}
