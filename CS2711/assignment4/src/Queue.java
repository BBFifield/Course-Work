import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-02. Student I.D.: 201238730
 * A class used to implement the Queue ADT using the operations of a priority queue.
 */
public class Queue<V> {

    private PriorityQueue<Integer, V> priorityQueue;
    private int counter;

    /**
     * Constructs a queue from a specified priority queue implementation.
     * @param priorityQueue - a priority queue implementation.
     */
    public Queue(PriorityQueue<Integer,V> priorityQueue) {
        this.priorityQueue = priorityQueue;
        counter = 1;
    }

    /**
     * Gets the size of the queue.
     * @return the size of the queue.
     */
    public int size() {
        return priorityQueue.size();
    }

    /**
     * Checks whether or not the queue is empty.
     * @return boolean value for whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    /**
     * Gets the front entry in the queue.
     * @return the front entry in the queue.
     */
    public Position<Entry<Integer,V>> front() {
        return priorityQueue.getFront();
    }

    /**
     * Inserts a value at the back
     * @param value - the value to be inserted
     */
    public void enqueue(V value) {
        priorityQueue.insert(counter, value);
        counter++;
    }

    /**
     * Removes an entry at the front.
     * @return the entry which was removed.
     */
    public Entry<Integer,V> dequeue() {
        Entry<Integer,V> removedElement = priorityQueue.removeMin();
        return removedElement;
    }

    /**
     * Returns a string representation of the queue.
     * @return a string representation of the queue.
     */
    public String toString() {
        ArrayList<Position<Entry<Integer,V>>> entryList = priorityQueue.getEntryList();
        String entryString = "";
        for(Position<Entry<Integer,V>> node: entryList) {
            V value = node.getElement().getValue();
            int number = node.getElement().getKey();
            entryString += String.format("(%d, %s) ", number, value);
        }
        return entryString;
    }
}
