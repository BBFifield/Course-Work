import java.util.ArrayList;

/**
 * This class tests the campsite class and all its subclasses.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class CampTester {
	
	/**
	 * Used to output every campsite's info and to compute whether certain 
	 * campsites are located in various locations.
	 * @param c - an array of type Campsite.
	 */
	static void statistics(Campsite[] c) {
		int numFrontTNNP = 0;
		int numServicedNS = 0;

		//Create two Array lists, first one the locations of all Back Country sites in Gros Morne National Park, Newfoundland and Labrador.
		//The second for all the unserviced sites in Malady Head, Terra Nova National Park, Newfoundland and Labrador. 
		ArrayList<String> bcLocationsGrosMorne = new ArrayList<String>();
		ArrayList<String> unServicedMalHead = new ArrayList<String>();
		
		//A for-loop which runs through an array of campsites to make various computations.
		for(Campsite cSite: c) { 
			//To check and see if this object in this position of the array is a FrontCountry object.
			if (FrontCountry.class == cSite.getClass()) {
				//Use cast notation to convert cSite from type Campsite to type FrontCountry so you can use FrontCountry class methods.
				FrontCountry campsite = (FrontCountry) cSite;
				if (campsite.getParkName().equals("Terra Nova National Park") && campsite.getProvince().equals("NL")) {
					//Add this one to the total number of Front Country sites in Terra Nova National Park, Newfoundland and Labrador.
					numFrontTNNP++;
				} 
			}

			//To check and see if this object in this position of the array is a Serviced object.
			else if (Serviced.class == cSite.getClass()) {
				//Use cast notation to convert cSite from type Campsite to type Serviced so you can use Serviced class methods.
				Serviced campsite = (Serviced) cSite;
				if (campsite.getCampgroundName().equals("Newman Sound") && campsite.getProvince().equals("NL") && (campsite.getAmpService() == 30)) {
					//Add this one to the total number of serviced sites (with 30 amp service) in Newman Sound, Terra Nova National Park, Newfoundland and Labrador. 
					numServicedNS++;
				}
			}
			//To check and see if this object in this position of the array is a BackCountry object.
			else if (BackCountry.class == cSite.getClass()) {
				//Use cast notation to convert cSite from type Campsite to type BackCountry so you can use BackCountry class methods.
				BackCountry campsite = (BackCountry) cSite;
				if (campsite.getParkName().equals("Gros Morne National Park") && campsite.getProvince().equals("NL")) {
					bcLocationsGrosMorne.add(campsite.getLocation());
				}
			}

			//To check and see if this object in this position of the array is an Unserviced object.
			else if (Unserviced.class == cSite.getClass()) {
				//Use cast notation to convert cSite from type Campsite to type Unserviced so you can use Unserviced class methods.
				Unserviced campsite = (Unserviced) cSite;
				if (campsite.getParkName().equals("Terra Nova National Park") && campsite.getProvince().equals("NL") && campsite.getCampgroundName().equals("Malady Head")) {
					unServicedMalHead.add(campsite.getSiteNumber());
				}			
			}
			//Print out all the info for each campsite in a nice a format.
			System.out.println(cSite.toString());		
		}
		//Print out the number of Front Country sites in Terra Nova National Park and the number of serviced sites in Newman Sound.
		System.out.printf("%nThe number of Front Country sites in Terra Nova National Park, NL: %d%nThe number of serviced sites in Newman Sound, Terra Nova National Park: %d%n%n", numFrontTNNP, numServicedNS);

		//Print out all locations of Back Country sites in Gros Morne.
		System.out.println("The locations of all Back Country sites in Gros Morne National Park, NL:");
		for (String location: bcLocationsGrosMorne) {
			 System.out.println(location);
		}
		
		//Print out all site number of unserviced sites which are located in Malady Head.
		System.out.printf("%nBy site number, a list of all the unserviced sites in Malady Head, Terra Nova National Park, Newfoundland and Labrador:%n");
		for (String siteNumber: unServicedMalHead) {
			System.out.println(siteNumber);
		}
	}	

	public static void main(String[] args) {
		Campsite[] campsites = new Campsite[11];
		campsites[0] = new Campsite("Dungeon Provincial Park", "NL", 39.00);
		campsites[1] = new FrontCountry("Terra Nova National Park", "NL", 50.00, "Campground 1", "5", "Yes");
		campsites[2] = new FrontCountry("Terra Nova National Park", "NL", 50.00, "Campground 2", "6", "Yes");
		campsites[3] = new FrontCountry("Blah Park", "NL", 50.00, "Campground 1", "5", "No");
		campsites[4] = new BackCountry("Gros Morne National Park", "NL", 20.00, "Back Yard", "Hike");
		campsites[5] = new BackCountry("Gros Morne National Park", "NL", 20.00, "Back Yard Number 2", "Hike");
		campsites[6] = new Serviced("Terra Nova National Park", "NL", 90.00, "Newman Sound", "3", "Yes", 30, "Yes"); 
		campsites[7] = new Serviced("Terra Nova National Park", "NL", 80.00, "Newman Sound", "4", "Yes", 15, "Yes"); 
		campsites[8] = new Unserviced("Terra Nova National Park", "NL", 25.00, "Malady Head", "22", "Yes", "Yes"); 
		campsites[9] = new Unserviced("Terra Nova National Park", "NL", 25.00, "Malady Head", "44", "Yes", "Yes"); 
		campsites[10] = new Unserviced("Terra Nova National Park", "NL", 25.00, "Catalina", "66", "Yes", "Yes");

		statistics(campsites);
	}

}
