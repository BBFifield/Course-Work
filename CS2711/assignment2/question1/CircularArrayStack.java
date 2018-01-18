import java.util.EmptyStackException;

/**
 * Created by Brandon on 2017-02-02. Student I.D.: 201238730
 * This creates a CircularArrayStack object which is an implementation of a fixed capacity stack.
 */
public class CircularArrayStack<E> {
    private E[] data;
    private int top;
    private int size;

    /**
     * Creates a CircularArrayStack.
     * @param data - An array of any object type to be passed.
     */
    public CircularArrayStack(E[] data) {
        this.data = data;
        top = -1;
    }

    /**
     * Gets the truth value of whether or not the stack is empty.
     * @return True or false depending on if the stack is empty.
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Gets the size of the stack.
     * @return the size of the array.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the location of the top of the stack.
     * @param index - the index of where top will be.
     */
    public void setTop(int index) {
        top = index;
    }

    /**
     * Pushes an element on top of the stack.
     * @param element - the element to be pushed onto the stack.
     */
    public void push(E element) {
        if(top == data.length - 1) {
            top = 0;
            data[top] = element;
        }
        else {
            top++;
            data[top] = element;
            size++;
        }
    }

    /**
     * Gets the element on the top of the stack.
     * @return the element on top.
     */
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return data[top];
        }
    }

    /**
     * Remove the element on top of the stack.
     * @return the element on top.
     */
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            E element = data[top];
            top = top - 1;
            size = size - 1;
            return element;
        }
    }

    /**
     * Gets the data array.
     * @return the data array.
     */
    public E[] getData() {
        return data;
    }

    /**
     * Outputs the list elements. For our purpose we assumed they were strings since we used strings to test the class.
     * Outputs the elements from top to bottom.
     */
    public void outputList() {
        int index = top;
        for(int i = 0; i < data.length; i++) {
            System.out.printf("%s%n", data[index]);
            index = index - 1;
            if(index < 0) {
                index = data.length - 1;
            }
        }
    }
}
