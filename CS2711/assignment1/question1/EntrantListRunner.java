/**
 * Created by Brandon on 2017-01-19. Student I.D.: 201238730
 * This program creates a singly-linked list of Entrant objects and does various operations on them.
 */
public class EntrantListRunner {
    public static void main(String[] args) {
        //Declare and initialize the linked list.
        EntrantList entrantList = new EntrantList();
        //Add entrants to the linked list.
        entrantList.addLast("Brandon");
        entrantList.addLast("Adam");
        entrantList.addLast("Cody");
        entrantList.addLast("Shawn");
        entrantList.addLast("David");

        //Withdraw entrants from the competition.
        entrantList.withdraw(1);
        entrantList.withdraw(3);

        //Update each entrant's completion time in the list.
        entrantList.updateNode(1, 10);
        entrantList.updateNode(2, 15);
        entrantList.updateNode(4, 12);
        entrantList.updateNode(5, 11);

        //Output the contents of the list.
        entrantList.outputList();
    }
}
