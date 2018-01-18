/**
 * Created by Brandon on 2017-01-19. Student I.D.: 201238730
 * This class allows you to creates a singly linked list of Entrant objects, what follows are it's various methods.
 */
public class EntrantList {

    private Node firstNode;
    private Node lastNode;
    private int entryNumber;

    //This instance variable will be used in the addLast(String n) method so that an if statement
    //will only be executed under the condition that the first entrant is to be added, this is
    //so that there will not be an empty node in the list in the future.
    public boolean firstAdded;

    /**
     * Constructs an singly-linked EntrantList.
     */
    public EntrantList() {
        firstNode = new Node();
        lastNode = firstNode;
        firstAdded = false;
        entryNumber = 1;
    }

    /**
     * Adds an entrant to the competition.
     * @param name - the name of the entrant to be added.
     */
    public void addLast(String name) {
        Node newNode = new Node();
        newNode.setElement(new Entrant(name));
        newNode.getElement().setEntryNumber(entryNumber);
        newNode.setNext(null);
        if(firstAdded == false) {
            lastNode.setNext(null);
            lastNode = newNode;
            firstNode = lastNode;
            firstAdded = true;
            entryNumber++;
        }
        else {
            lastNode.setNext(newNode);
            lastNode = newNode;
            entryNumber++;
        }
    }

    /**
     * Withdraws a person from the competition by entry number.
     * @param entryNumber - the number of the entrant to be withdrawn from the competition.
     */
    public void withdraw(int entryNumber) {
        Node currentNode = firstNode;
        Node previousToCurrent = currentNode;
        while(currentNode != null) {
            if(currentNode.getElement().getEntryNumber() == entryNumber) {
                //previousToCurrent node is not needed here since there is no previous node from the first position in the list.
                if(currentNode == firstNode) {
                    firstNode = currentNode.getNext();
                    currentNode.setNext(null);
                }
                //Changes the address in previous node from current node to the one after current node since current node will be removed.
                else {
                    previousToCurrent.setNext(currentNode.getNext());
                    currentNode.setNext(null);
                }
                break;
            }
            else {
                previousToCurrent = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    /**
     * Updates each entrant completion time after the race finishes.
     * @param entryNumber - the entry number of the applicant to be updated.
     * @param completionTime - the completion time of the applicant to be updated.
     */
    public void updateNode(int entryNumber, int completionTime) {
        Node currentEntrant = firstNode;
        while(currentEntrant != null) {
            if(currentEntrant.getElement().getEntryNumber() == entryNumber) {
                currentEntrant.getElement().setCompletionTime(completionTime);
                break;
            }
            else {
                currentEntrant = currentEntrant.getNext();
            }
        }
    }

    /**
     * Outputs the info of each applicant.
     */
    public void outputList() {
        Node currentEntrant = firstNode;
        while(currentEntrant != null) {
            System.out.println(currentEntrant.getElement().toString());
            currentEntrant = currentEntrant.getNext();
        }
    }
}
