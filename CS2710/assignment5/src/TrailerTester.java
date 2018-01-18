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

        //Sorts the trailers objects by name in alphabetical order using selection sort.
        for (int i = 0; i < trailers.length; i++ ) {
            int least = i;
            for (int j = i; j < trailers.length; j++) {
                if (trailers[j].getName().compareTo(trailers[least].getName()) < 0) {
                    least = j;
                }
            }
            Trailer temporary = trailers[i];
            trailers[i] = trailers[least];
            trailers[least] = temporary;
        }

        //Iterate over the trailers array to do computations relating to trailers.
        for (Trailer trailer: trailers) {
            //Print out each trailer's information.
            System.out.println(trailer.toString());
        }

        //Get the user to input three names to see if they match any owner's names.
        Scanner commandIn = new Scanner(System.in);
        System.out.println("Input threes names to see if they match any on record for trailer owners.");

        //Declare an array of 3 names and get input to initialize them.
        String[] names = new String[3];
        names[0] = commandIn.nextLine();
        names[1] = commandIn.nextLine();
        names[2] = commandIn.nextLine();

        boolean matchFound = false;
        //Use binary search on the trailers array to see if there are any matches.
        for(String name: names) {
            int upperRange = trailers.length - 1;
            int lowerRange = 0;
            matchFound = false;
            while(lowerRange <= upperRange && matchFound == false) {
                int mid = (lowerRange + upperRange)/2;
                if(trailers[mid].getName().equalsIgnoreCase(name)) matchFound = true;
                else if (trailers[mid].getName().compareToIgnoreCase(name) < 0) lowerRange = mid + 1;
                else upperRange = mid - 1;
                if(matchFound == true) {
                    System.out.printf("%s matches the names of %s's trailer.%n%nThe corresponding trailer's" +
                            " information is:%n%n%s", name, trailers[mid].getName(), trailers[mid].toString());
                }
            }
        }
        if (!matchFound) System.out.println("No matches were found for the names you entered.");

        //Sort the array into numerical order by building number, using Insertion Sort.
        for(int i = 1; i < trailers.length; i++) {
            int nextBuildingNum = Integer.parseInt(trailers[i].getBuildingNum());
            Trailer nextTrailer = trailers[i];
            int j = i;
            while(j > 0 && Integer.parseInt(trailers[j-1].getBuildingNum()) > nextBuildingNum) {
                trailers[j] = trailers[j-1];
                j--;
            }
            trailers[j] = nextTrailer;
        }

        //Output the array which was sorted by insertion sort.
        for(int i = 0; i < trailers.length; i++) {
            System.out.printf(trailers[i].toString() + "%n");
        }
    }
}

