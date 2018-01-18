import java.util.Scanner;

/**
 * This class tests the recursive methods on random strings.
 * Created by Brandon Fifield on 2016-10-24. STUDENT ID: 201238730
 */
public class RecursiveMethodTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        //Testing the reverse method implemented using recursion. Question 1(a).
        System.out.print("Input the string to be reversed by recursion: ");
        String stringRecursion = in.nextLine();
        String reversed = RecursiveMethods.reverse(stringRecursion);
        System.out.println("The reversed text for question 1 part A: " + reversed);

        //Testing the reverse method implemented using iteration. Question 1(b).
        System.out.print("Enter the string to be reversed by iteration: ");
        String stringIteration = in.nextLine();
        String reversed2 = RecursiveMethods.iterationReverse(stringIteration);
        System.out.println("The reversed text for question 1 part B: " + reversed2);

        //Testing the base converter method. Question 1(c).
        System.out.print("Input decimal to be converted: ");
        int d = in.nextInt();
        System.out.print("Input the base it is to be converted to: ");
        int b = in.nextInt();
        String converted = RecursiveMethods.recursiveBaseConverter(d, b);
        System.out.println("The number " + d + " converted to base " + b + " is " + converted);

        //Testing the is string reversed method. Question 1(d).
		
        System.out.print("Input first string to be compared: ");
		//Next line of code fires a blank line so that it consumes the '/n' from the last input from nextInt().
		in.nextLine();
        String s1 = in.nextLine();
		System.out.print("Input second string to be compared: ");
        String s2 = in.nextLine();
        boolean isReversed = RecursiveMethods.isStringReversed(s1, s2);
        System.out.println("Are the strings reversed? " + isReversed);
    }
}
