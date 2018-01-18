/**
 * Creates Entries with an associated key and value.
 * Created by Brandon on 2017-03-29. Student I.D: 201238730
 */
public class Entry<K,V> {

    private K key;
    private V value;

    /**
     * Constructs a new Entry object
     * @param key - the key of this entry.
     * @param value - the value associated with this entry.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * gets the key associated with the entry.
     * @return the key.
     */
    public K getKey() {
        return key;
    }

    /**
     * Changes the key associated with this Entry.
     * @param key - the key to be set.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Gets the value associated with this entry.
     * @return the value.
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the value associated with this entry.
     * @param value - the value to be set.
     * @return the old value asociated with this entry.
     */
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
