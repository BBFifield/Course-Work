/**
 * This class creates a trailer which is to be put in storage for a period of time, detailing the owner's name
 * and cost associated with storing it.
 * @author Brandon Fifield - 2012730
 */
public class Trailer {

    private String name;
    private String telephoneNum;
    private String licenseNum;
    private String buildingNum;
    private String datePut;
    private String dateRemoval;
    private double lengthOfTrailer;

    public static final double COST_PER_FOOT = 30;
    public static final double TAX_RATE = 0.15;

    /**
     * Constructs a trailer to be stored.
     * @param name - this is the name of the trailer.
     * @param telephoneNum - the telephone number.
     * @param licenseNum - the license plate number.
     * @param lengthOfTrailer - the length of the trailer itself.
     * @param buildingNum - the building number.
     * @param datePut - the date it was put into storage.
     * @param dateRemoval - date it is to be removed.
     */
    public Trailer(String name, String telephoneNum, String licenseNum,
                   double lengthOfTrailer, String buildingNum, String datePut, String dateRemoval) {

        this.name = name;
        this.telephoneNum = telephoneNum;
        this.licenseNum = licenseNum;
        this.lengthOfTrailer = lengthOfTrailer;
        this.buildingNum = buildingNum;
        this.datePut = datePut;
        this.dateRemoval = dateRemoval;
    }

    /**
     * Accesses the name of the trailer.
     * @return the name of the trailer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the trailer.
     * @param name - name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accesses the telephone number of the trailer.
     * @return the telephone number.
     */
    public String getTelephoneNum() {
        return telephoneNum;
    }

    /**
     * Sets the telephone number of the trailer to be stored.
     * @param telephoneNum - the telephone number to be recorded.
     */
    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    /**
     * Accesses the license plate number of the trailer.
     * @return - the license plate number.
     */
    public String getLicensePlateNum() {
        return licenseNum;
    }

    /**
     * Sets the license plate number of the trailer to be stored.
     * @param licenseNum - the license plate number to be set.
     */
    public void setLicensePlateNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    /**
     * Accesses the length of the trailer.
     * @return the length of the trailer.
     */
    public Double getLength() {
        return lengthOfTrailer;
    }

    /**
     * Sets the length of the trailer in feet.
     * @param length - the length of the trailer.
     */
    public void setLengthOfTrailer(double length) {
        this.lengthOfTrailer = length;
    }

    /**
     * Accesses the building number which the trailer is to be stored in.
     * @return the building number.
     */
    public String getBuildingNum() {
        return buildingNum;
    }

    /**
     * Sets the building number the trailer is to be stored in.
     * @param buildingNum - the building number to be set.
     */
    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    /**
     * Accesses the date the trailer was put in storage.
     * @return the date the trailer was put in storage.
     */
    public String getDatePut() {
        return datePut;
    }

    /**
     * Sets the date the trailer was put in storage.
     * @param datePut - the date to be set.
     */
    public void setDatePut(String datePut) {
        this.datePut = datePut;
    }

    /**
     * Accesses the date the trailer is to be taken out.
     * @return the date the trailer is to be taken out.
     */
    public String getDateRemoval() {
        return dateRemoval;
    }

    /**
     * Sets the date the trailer is to be taken out.
     * @param dateRemoval - the date the trailer is to be taken out.
     */
    public void setDateRemoval(String dateRemoval) {
        this.dateRemoval = dateRemoval;
    }

    /**
     * Calculates the cost of storage to store the trailer.
     * @return the seasonal charge for storing the trailer.
     */
    public double costOfStorage() {
        double seasonalCharge = COST_PER_FOOT*lengthOfTrailer + COST_PER_FOOT*lengthOfTrailer*TAX_RATE;
        return seasonalCharge;
    }

    /**
     * Converts all the info of the trailer storage to one big string.
     * @return the string converted into.
     */
    public String toString() {
        return String.format("Name: " + name + "%n" +
                "Telephone number: " + telephoneNum + "%n" +
                "license plate number: " + licenseNum + "%n" +
                "Length of trailer: " + lengthOfTrailer + "%n" +
                "Building number: " + buildingNum + "%n" +
                "Date put in storage: " + datePut + "%n" +
                "Date to be removed: " + dateRemoval + "%n" +
                "Seasonal charge: $%-8.2f%n", costOfStorage());
    }
}

