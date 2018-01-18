/**
 * Created by Brandon on 2017-02-02. Student I.D.: 201238730
 * This class tests the CircularSinglyStack and CircularArrayStack classes.
 */
public class CircularStackTester {
    public static void main(String[] args) {

        CircularArrayStack<String> stackArray = new CircularArrayStack<>(new String[7]);
        //Push everything down the stack.
        stackArray.push("Brandon");
        stackArray.push("Adam");
        stackArray.push("Griffin");
        stackArray.push("Shawn");
        stackArray.push("Michelle");
        stackArray.push("Marvin");
        stackArray.push("Dot");
        stackArray.push("Spencer");
        stackArray.push("Lucas");
        stackArray.push("Hello");
        stackArray.push("Yes");
        //Pop an element.
        String poppedElement = stackArray.pop();
        //Push one more element.
        stackArray.push("Computer");

        //Output the contents of the stack from top to bottom.
        stackArray.outputList();
        //Output the element which was popped.
        System.out.printf("%nThe popped element in the circular stack array was: %s%n%n", poppedElement);

        CircularSinglyStack<String> singlyStack = new CircularSinglyStack<>(9);
        //Push these elements down the stack of the circularsinglylist.
        singlyStack.push("Brandon");
        singlyStack.push("Adam");
        singlyStack.push("Griffin");
        singlyStack.push("Shawn");
        singlyStack.push("Michelle");
        singlyStack.push("Marvin");
        singlyStack.push("Dot");
        singlyStack.push("Spencer");
        singlyStack.push("Lucas");
        singlyStack.push("Hello");
        singlyStack.push("Yes");

        //Pop an element.
        String poppedElement2 = singlyStack.pop();
        //Push one last element.
        singlyStack.push("Computer");
        //Output the contents of the stack from top to bottom.
        singlyStack.outputList();

        //The popped element of the circularSignlyList.
        System.out.printf("%nThe popped element in the circular singly-linked list stack was: %s", poppedElement2);
    }
}
