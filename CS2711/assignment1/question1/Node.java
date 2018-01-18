/**
 * Created by Brandon on 2017-01-19. Student I.D.: 201238730
 * Creates nodes to be used in the Entrant singly linked list.
 */
public class Node {
    private Entrant element;
    private Node next;

    /**
     * Constructs a new null object.
     */
    public Node() {
        element = new Entrant("");
        next = null;
    }

    /**
     * Gets an entrant object.
     * @return an entrant object.
     */
    public Entrant getElement() {
        return element;
    }

    /**
     * Gets the address of the node which is linked to this one.
     * @return the address of the next node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the entrant object used by the node.
     * @param element - the entrant object in the node.
     */
    public void setElement(Entrant element) {
        this.element = element;
    }

    /**
     * Sets the next node.
     * @param next -  the next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
