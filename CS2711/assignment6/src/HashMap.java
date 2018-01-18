import java.util.ArrayList;
import java.util.Random;

/**
 * An abstract class which can be extended to make different kinds of hash tables.
 * Created by Brandon on 2017-03-29. Student I.D: 201238730
 */
public abstract class HashMap<V> {
    
    private int size;
    private int capacity;
    private int primeFactor;
    private int shiftFactor;
    private int scaleFactor;

    /**
     * Constructs a hash table.
     * @param capacity - The maximum capacity of the table.
     * @param primeFactor - The prime number to be used in the MAD function.
     */
    public HashMap(int capacity, int primeFactor) {
        size = 0;
        this.capacity = capacity;
        this.primeFactor = primeFactor;
        Random randomizer = new Random();
        shiftFactor = randomizer.nextInt(primeFactor) + 1;
        scaleFactor = randomizer.nextInt(primeFactor);
        initializeTable();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the capacity of the table.
     * @return an integer number representing the maximum capacity of the table.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the value associated with the given key and hash value.
     * @param code - the index in the hash table to look up.
     * @param key - the key associated with the value.
     * @return the associated value.
     */
    public abstract V get(int code, String key);

    /**
     * Removes the entry associated with a key from table at the specified index.
     * @param code - the bucket or index in the table.
     * @param key - the key associated with the entry.
     * @return - the value which was removed.
     */
    public abstract V remove(int code, String key);

    /**
     * Groups together the key and value specified and puts it in the hash table.
     * @param code - the hash value.
     * @param key - the key to be grouped with the value.
     * @param value - the value to be put in the table.
     * @return the value which was previously associated with k, or null if it didn't exist.
     */
    public abstract V put(int code, String key, V value);

    /**
     * A cyclic shift hash code method which is to be used on a key of type string to generate an int value.
     * @param key - the key that is to be converted to an int.
     * @return the integer representation of the string key.
     */
    public int hashCode(String key) {
        int code = 0;
        for(int i = 0; i < key.length(); i++) {
            code = (code << 5) | (code >>> 27);
            code += (int) key.charAt(i);
        }
        return code;
    }

    /**
     * Hash function which uses division compression method to map a key.
     * @param key - the key to be mapped.
     * @return the mapped location of the key inside the table.
     */
    public int firstHashFunction(String key) {
        return Math.abs(hashCode(key) % capacity);
    }

    /**
     * This is the first hash function which uses the MAD method to map the hash code into the hash table.
     * @param key - the key which is to be converted into a hash code and then mapped into the table.
     * @return the index of the bucket the key shall be mapped to.
     */
    public int secondHashFunction(String key) {
        return ((Math.abs(hashCode(key)*scaleFactor + shiftFactor) % primeFactor) % capacity);
    }

    /**
     * Initializes an empty hash table with a given capacity.
     */
    public abstract void initializeTable();

    /**
     * Gets all entries inside the hash table.
     * @return an ArrayList with the entries inside the hash table.
     */
    public abstract ArrayList<Entry<String,V>> getEntryList();

    /**
     * Gets the probe sequence associated with a hash table which used the first function.
     * @param keys - the keys which will have their locations looked up.
     * @return a string representing the probe sequence of the given keys inside the table.
     */
    public abstract String firstFunctProbeSequence(ArrayList<String> keys);

    /**
     * Gets the probe sequence associated with a hash table which used the second function.
     * @param keys - the keys which will have their locations looked up.
     * @return a string representing the probe sequence of the given keys inside the table.
     */
    public abstract String secondFunctProbeSequence(ArrayList<String> keys);
}
