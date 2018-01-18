import java.util.ArrayList;

/**
 * Created by Brandon on 2017-02-24. Student I.D.: 201238730
 * Used for implementing priority queues.
 */
public interface PriorityQueue<K,V> {
    /**
     * Gets the size of the priority queue
     * @return the size
     */
    public int size();

    /**
     * Checks if it's empty
     * @return the boolean value
     */
    public boolean isEmpty();

    /**
     * Gets the position at the front of the queue
     * @return the front position
     */
    public Position<Entry<K,V>> getFront();

    /**
     * Inserts an entry into the priority queue
     * @param key - the key to be binded to the entry
     * @param value - the value to be stored
     * @return the entry which was inserted
     */
    public Entry<K,V> insert(K key, V value);

    /**
     * Gets the entry value
     * @return the entry value
     */
    public Entry<K,V> min();

    /**
     * Removes the minimum entry
     * @return the minimum entry which was removed
     */
    public Entry<K,V> removeMin();

    /**
     * Get the arrayList representation of the priority queue
     * @return
     */
    public ArrayList<Position<Entry<K,V>>> getEntryList();
}
