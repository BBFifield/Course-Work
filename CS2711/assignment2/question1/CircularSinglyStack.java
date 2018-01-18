import java.util.EmptyStackException;

/**
 * Created by Brandon on 2017-02-02. Student I.D.: 201238730
 * This creates a CircularSinglyStack object to be used for the purpose of testing a
 * fixed capacity stack using a singly linked list.
 */
public class CircularSinglyStack<E> {
    private Node<E> top;
    int capacity;
    int size;

    /**
     * Creates CircularSinglyStack objects.
     * @param capacity - the maximum capacity of the stack before it wraps around.
     */
    public CircularSinglyStack(int capacity) {
        top = null;
        this.capacity = capacity;
        size = 0;
    }

    /**
     * Gets the size of the stack.
     * @return the size of the stack.
     */
    public int getSize() {
        return size;
    }

    /**
     * A truth value which indicates whether the stack is empty or not.
     * @return the truth value.
     */
    public boolean isEmpty() {
        if(top == null) {
            return true;
        }
        return false;
    }

    /**
     * Pushes an element on top of the stack.
     * @param element - the element to be pushed on top of the stack.
     */
    public void push(E element) {
        Node<E> newNode = new Node<E>(element, top);
        if(size == capacity) {
            Node<E> current = top;
            //Sets the position of the node to be linked to the top and the node which will be removed.
            //Size-2 being the node which will be linked to the new node, and -1 being the one to be removed.
            for(int i = 0; i < size - 2; i++) {
                current = current.getNext();
            }
            Node<E> bottom = current.getNext();
            bottom.setNext(null);
            current.setNext(newNode);
            top = newNode;
        }
        else {
            top = newNode;
            size++;
        }
    }

    /**
     * Gets the top element in the stack.
     * @return the top element in the stack.
     */
    public E top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getElement();
    }

    /**
     * Removes the top element in the stack.
     * @return returns the removed element.
     */
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        E temp = top.getElement();
        top = top.getNext();
        size = size - 1;
        return temp;
    }

    /**
     * Outputs the list elements. For our purpose we assumed they were strings since we used strings to test the class.
     * Outputs the elements from top to bottom.
     */
    public void outputList() {
        Node<E> current;
        current = top;
        for(int i = 0; i < size; i++) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    /**
     * Creates nodes to be used in the circular singly linked list stack.
     */
    class Node<E> {
        private E element;
        private Node<E> next;

        /**
         * Constructs nodes for the stack.
         * @param element - the element at this node.
         * @param next - the next node in the list.
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        /**
         * Gets the element at this node.
         * @return the element at this node.
         */
        public E getElement() {
            return element;
        }

        /**
         * Gets the next node in the list.
         * @return the next node in the list.
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the element for the node.
         * @param element - the element to be set.
         */
        public void setElement(E element) {
            this.element = element;
        }

        /**
         * Sets the next node in the list.
         * @param next - the next node in the list.
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
