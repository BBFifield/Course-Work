import java.util.ArrayList;

/**
 * Creates a new Linear Probe Hash table.
 * Created by Brandon on 2017-03-29. Student I.D: 201238730
 */
public class LinearProbeHashMap<V> extends HashMap<V> {

    private Entry<String,V>[] bucketArray;

    /**
     * Constructs a new Linear Probe Hash Table given a capacity and prime factor.
     * @param capacity - the maximum size of the table.
     * @param primeFactor - the prime number which is to be used by the MAD compression function.
     */
    public LinearProbeHashMap(int capacity, int primeFactor) {
        super(capacity, primeFactor);
    }

    /**
     * Creates an empty table of a specified capacity.
     */
    public void initializeTable() {
        bucketArray = (Entry<String,V>[]) new Entry[getCapacity()];
    }

    /**
     * Checks to see if a bucket at the given index of the table is empty.
     * @param j - the index inside the table.
     * @return a boolean value representing true if the bucket is empty, or false if not.
     */
    public boolean isOpen(int j) {
        return (bucketArray[j] == null);
    }

    /**
     * Gets the index of a given key and hash code, or returns the first available bucket that can be used for storage.
     * @param code - the hash value of the key.
     * @param key - the key to get the associated table index of.
     * @return the index associated with the storage location of this key or the location of the first available bucket.
     */
    public int getIndex(int code, String key) {
        int indexToPutKey = -1;
        int index = code;
        do {
            if(isOpen(index)) {
                indexToPutKey = index;
                break;
            }
            else if(bucketArray[index].getKey().equals(key)) {
                return index;
            }
            index = (index+1) % getCapacity();
        }
        while(index != code);
        return -(indexToPutKey + 1);
    }

    /**
     * Gets the value associated with the given key in the table at location 'code'
     * @param code - the index in the hash table to look up.
     * @param key - the key associated with the value.
     * @return the associated value
     */
    public V get(int code, String key) {
        int index = getIndex(code, key);
        if( index < 0) return null;
        return bucketArray[index].getValue();
    }

    /**
     * Groups the given key and value and puts it in the hash table at the given location
     * @param code - the hash value. (location)
     * @param key - the key to be grouped with the value.
     * @param value - the value to be put in the table.
     * @return the value which was previously associated with k, or null if it didn't exist.
     */
    public V put(int code, String key, V value) {
        int index = getIndex(code, key);
        if(index >= 0) {
            return bucketArray[index].setValue(value);
        }
        bucketArray[-(index+1)] = new Entry<>(key, value);
        setSize(getSize() + 1);
        return null;
    }

    /**
     * Removes the entry associated with the given key from the hash table at the specified location.
     * @param code - the bucket or index in the table.
     * @param key - the key associated with the entry.
     * @return the value which was removed from the table
     */
    public V remove(int code, String key) {
        int index = getIndex(code, key);
        if(index < 0) return null;
        V valueRemoved = bucketArray[index].getValue();
        bucketArray[index] = null;
        setSize(getSize() - 1);
        return valueRemoved;
    }

    /**
     * Gets all entries inside the hash table.
     * @return an ArrayList with the entries inside the hash table.
     */
    public ArrayList<Entry<String,V>> getEntryList() {
        ArrayList<Entry<String,V>> entryList = new ArrayList<>();
        for(int i = 0; i < getCapacity(); i++) {
            if(!isOpen(i)) {
                entryList.add(bucketArray[i]);
            }
        }
        return entryList;
    }

    /**
     * Gets the probe sequence associated with a linear probe hash table which used the first function.
     * @param keys - the keys which will have their locations looked up.
     * @return a string representing the probe sequence of the given keys inside the table.
     */
    public String firstFunctProbeSequence(ArrayList<String> keys) {
        String probeSequence = "";
        for(String key: keys) {
            probeSequence += getIndex(firstHashFunction(key), key) + ": " + key + "\n";
        }
        return probeSequence;
    }

    /**
     * Gets the probe sequence associated with a linear probe hash table which used the second function.
     * @param keys - the keys which will have their locations looked up.
     * @return a string representing the probe sequence of the given keys inside the table.
     */
    public String secondFunctProbeSequence(ArrayList<String> keys) {
        String probeSequence = "";
        for(String key: keys) {
            probeSequence += getIndex(secondHashFunction(key), key) + ": " + key + "\n";
        }
        return probeSequence;
    }
}
