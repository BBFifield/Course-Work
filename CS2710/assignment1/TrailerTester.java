import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class tests the Trailer class by creating trailer objects and invoking its methods on them.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class TrailerTester {
    public static void main(String[] args) throws FileNotFoundException {
        
        File inFile = new File("trailerInfo.txt");
        Scanner in = new Scanner(inFile);
        
        //Declare an array of 10 trailer objects.
        Trailer[] trailers = new Trailer[10];
        
        int trailersLonger30Feet = 0;
        double totalIncome = 0;
        
        int trailersBuilding1 = 0;
        int trailersBuilding2 = 0;
        int trailersBuilding3 = 0;
        int trailersBuilding4 = 0;
        
		//Constructs new trailer objects by taking input from a text file and using it in parameter variables.
        for (int i = 0; i < trailers.length; i++) {
            boolean empty = true;
            while (empty) {
                String currentLine = in.nextLine();
                if (!currentLine.isEmpty()) {
                    //Had to use parseDouble method to convert string, using nextDouble method wouldn't have consumed enter input.
                    trailers[i] = new Trailer(currentLine, in.nextLine(), in.nextLine(),
                              Double.parseDouble(in.nextLine()), in.nextLine(), in.nextLine(), in.nextLine());
                    empty = false;
                }
            }
        }
        
		//Sorts the trailers objects by name in alphabetical order.
		for (int i = 0; i < trailers.length; i++ ) {
			for (int j = 0; j < trailers.length - 1; j++) {
				int k = j;  
				if (trailers[j].getName().compareTo(trailers[++k].getName()) > 0) {
					Trailer temporaryTrailer = trailers[j];
					trailers[j] = trailers[k];
					trailers[k] = temporaryTrailer;
				}
			}
		}
		
		//Iterate over the trailers array to do computations relating to trailers.
		for (Trailer trailer: trailers) {
			//Compute the total number of trailers longer than 30 feet.
            if (trailer.getLength() > 30) {
                trailersLonger30Feet++;
            }
            //Compute the total number of trailers in each building.
            switch (trailer.getBuildingNum()) {
                case "1": trailersBuilding1++; break;
                case "2": trailersBuilding2++; break;
                case "3": trailersBuilding3++; break;
                case "4": trailersBuilding4++; break;
            }
            //Compute the total income for the facility from all trailers.
            totalIncome += trailer.costOfStorage();
            //Print out each trailer's information.
            System.out.println(trailer.toString());
		}

        //Print out number of trailers greater than 30 feet in length.
        System.out.println("Number of trailers greater than 30 feet in length: " + trailersLonger30Feet);
        
        //Print out the number of trailers in each building.
        System.out.printf("Number of trailers in each building: %n"+ 
                           "Building 1: " + trailersBuilding1 + "%n" +
                           "Building 2: " + trailersBuilding2 + "%n" +
                           "Building 3: " + trailersBuilding3 + "%n" +
                           "Building 4: " + trailersBuilding4 + "%n");
        
        //Print out the total income for the facility from all trailers.
        System.out.printf("Total income for the facility for all trailers: %-8.2f%n", totalIncome);
        
        //Get the user to input three dates to see if they match any trailers on record which are to be removed on that date.
        Scanner commandIn = new Scanner(System.in);
        System.out.println("In the form MONTH DD, YYYY. Input three dates to see if they match any records of dates"
                            + " trailers are to be removed: (Ex: SEPTEMBER 30TH, 2016)");
        
		//Declare an array of 3 dates and get input to initialize them.
		String[] dates = new String[3];
        dates[0] = commandIn.nextLine();
        dates[1] = commandIn.nextLine();
        dates[2] = commandIn.nextLine();
        
		boolean matchFound = false;

		//Iterate over trailers array again to see if the dates match any dates on record.
        for (Trailer trailer : trailers) {
            for (String date : dates) {
                if (trailer.getDateRemoval().equalsIgnoreCase(date)) {
                    System.out.printf("%s matches the removal date of %s's trailer. %n", date, trailer.getName());
					matchFound = true;
                } 
            }
        }
		if (!matchFound) System.out.println("No matches were found for the dates you entered.");
	}
}

