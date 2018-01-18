/**
 * Created by Brandon on 2017-02-24. Student I.D.: 201238730
 * Used for implementing entries with keys and values
 */
public interface Entry<K,V> {
    /**
     * Gets a key from an entry
     * @return the key
     */
    public K getKey();

    /**
     * gets the value in the entry
     * @return the value in the entry
     */
    public V getValue();
}
