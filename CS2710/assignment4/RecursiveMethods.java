/**
 * This class contains recursive methods which act on strings to form new strings.
 * Created by Brandon Fifield on 2016-10-24. STUDENT ID: 201238730.
 */
public class RecursiveMethods
{
    /**
     * Question 1(a). This recursive method reverses a string entirely.
     * @param text - the text to be reversed
     * @return the reversed string
     */
    public static String reverse(String text)
    {
        if(text.length() == 1) return text;
        char char1 = text.charAt(text.length() - 1);
        return char1 + reverse(text.substring(0, text.length() - 1));
    }

    /**
     * Question 1(b). This implements the method from 1(a) as an iteration.
     * @param text - the text to be reversed.
     * @return the text which was reversed by iteration
     */
    public static String iterationReverse(String text)
    {
        String text2 = "";
        for(int i = 0; i < text.length(); i++)
        {
            char char1 = text.charAt(i);
            text2 = char1 + text2;
        }
        return text2;
    }

    /**
     * Question 1(c). This method uses recursion to convert any decimal number to any base from 2 to 16.
     * @param a - this is decimal number to be converted
     * @param b - this is any base from 2 to 16 that the decimal number is to be converted to
     * @return the converted decimal
     */
    public static String recursiveBaseConverter(int a, int b)
    {
        if(b >= 2 && b <= 16) {
            if (a == 0) return "";
            int quotient = a / b;
            String remainder = Integer.toString(a % b);
            switch (remainder)
            {
                case "10": remainder = "A"; break;
                case "11": remainder = "B"; break;
                case "12": remainder = "C"; break;
                case "13": remainder = "D"; break;
                case "14": remainder = "E"; break;
                case "15": remainder = "F"; break;
            }

            return recursiveBaseConverter(quotient, b) + remainder;
        }
        else {return "Please enter any specified base from 2 to 16 that a decimal will be converted to.";}
    }

    /**
     * Tests whether two strings are reverses of each other.
     * @param s1 - the first string to be compared
     * @param s2 - the second string to be compared
     * @return a boolean value of whether the strings are reversed strings of each other
     */
    public static boolean isStringReversed(String s1, String s2)
    {
        //These are the base cases of the method which allows it to terminate without problems.
        if(s1.length() == 1 && s2.length() == 0 || s1.length() == 0 && s2.length() == 1) return true;
        if(s1.length() == 0 && s2.length() > 1 || s1.length() > 1 && s2.length() == 0) return false;
        if(s1.length() == 0 && s2.length() == 0) return true;

        //This is where the method calls on itself if first character in one string equals the last character in the other.
        if(Character.toLowerCase(s1.charAt(0)) == Character.toLowerCase(s2.charAt(s2.length() - 1)))
        {
            return isStringReversed(s1.substring(1, s1.length()), s2.substring(0, s2.length() - 1));
        }
        else return false;
    }
}
