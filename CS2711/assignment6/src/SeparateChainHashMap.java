import java.util.ArrayList;

/**
 * Creates a new Separate Chain Hash Table.
 * Created by Brandon on 2017-03-29. Student I.D: 201238730
 */
public class SeparateChainHashMap<V> extends HashMap<V> {

    private ArrayList<Entry<String,V>>[] bucketArray;

    /**
     * Constructs a new Separate Chain Hash Table given a capacity and prime factor.
     * @param capacity - the maximum size of the table.
     * @param primeFactor - the prime number which is to be used by the MAD compression function.
     */
    public SeparateChainHashMap(int capacity, int primeFactor) {
        super(capacity, primeFactor);
    }

    /**
     * Creates an empty table of a specified capacity.
     */
    public void initializeTable() {
        bucketArray = (ArrayList<Entry<String,V>>[]) new ArrayList[getCapacity()];
    }

    /**
     * Gets the value associated with the given key in the table at location 'code'
     * @param code - the index in the hash table to look up.
     * @param key - the key associated with the value.
     * @return the associated value
     */
    public V get(int code, String key) {
        ArrayList<Entry<String,V>> tableBucket = bucketArray[code];
        if(tableBucket == null) {
            return null;
        }
        return getFromBucket(key, tableBucket);
    }

    /**
     * Groups the given key and value and puts it in the hash table at the given location
     * @param code - the hash value. (location)
     * @param key - the key to be grouped with the value.
     * @param value - the value to be put in the table.
     * @return the value which was previously associated with k, or null if it didn't exist.
     */
    public V put(int code, String key, V value) {
        ArrayList<Entry<String,V>> bucket = bucketArray[code];
        if(bucket == null) {
            bucketArray[code] = new ArrayList<>();
            bucket = bucketArray[code];
        }
        int sizeBeforeInsert = bucket.size();
        V valuePut = putInBucket(key,value,bucket);
        setSize(getSize() + bucket.size() - sizeBeforeInsert);
        return valuePut;
    }

    /**
     * Removes the entry associated with the given key from the hash table at the specified location.
     * @param code - the bucket or index in the table.
     * @param key - the key associated with the entry.
     * @return the value which was removed from the table
     */
    public V remove(int code, String key) {
        ArrayList<Entry<String,V>> bucket = bucketArray[code];
        if(bucket == null) {
            return null;
        }
        int sizeBeforeRemove = bucket.size();
        V valueRemoved = removeFromBucket(key, bucket);
        setSize(getSize() - sizeBeforeRemove - bucket.size());
        return valueRemoved;
    }

    /**
     * gets the index of an entry at the specified bucket in the table.
     * @param key - the key associated with the entry.
     * @param bucket - the bucket that may hold numerous key values.
     * @return an the index of the location inside the bucket that the key resides, or -1 if it isn't found.
     */
    public int indexInBucket(String key, ArrayList<Entry<String,V>> bucket) {
        for(int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets the value of the given key
     * @param key - the key to find.
     * @param bucket - the bucket which contains the array of entries.
     * @return the value associated with the key, or null if it doesn't exist.
     */
    public V getFromBucket(String key, ArrayList<Entry<String,V>> bucket) {
        int index = indexInBucket(key, bucket);
        if(index == -1) return null;
        return bucket.get(index).getValue();
    }

    /**
     * Groups the given value and key and puts them inside the bucket (array of entries)
     * @param key - the key to group with the specified value.
     * @param value - the value to tie with the given key.
     * @param bucket - Array of keys at a location in the table.
     * @return the old value associated with the key, or null if no entry existed.
     */
    public V putInBucket(String key, V value, ArrayList<Entry<String, V>> bucket) {
        int index = indexInBucket(key, bucket);
        if(index == -1) {
            bucket.add(new Entry<>(key, value));
            return null;
        }
        else {
            return bucket.get(index).setValue(value);
        }
    }

    /**
     * Removes the entry associated with the key.
     * @param key - the key whose entry is to be removed.
     * @param bucket - array of keys at a location in the hash table
     * @return the value associated with the removed key, or null if it didn't exist.
     */
    public V removeFromBucket(String key, ArrayList<Entry<String,V>> bucket) {
        int index = indexInBucket(key, bucket);
        int size = bucket.size();
        if(index == -1) return null;
        V valueRemoved = bucket.get(index).getValue();
        if(index != size - 1) {
            bucket.set(index, bucket.get(size - 1));
        }
        bucket.remove(size - 1);
        return valueRemoved;
    }

    /**
     * Gets all entries inside the hash table.
     * @return an ArrayList with the entries inside the hash table.
     */
    public ArrayList<Entry<String,V>> getEntryList() {
        ArrayList<Entry<String,V>> entryList = new ArrayList<>();
        for(int i = 0; i < getCapacity(); i++) {
            if(bucketArray[i] != null) {
                for(Entry<String,V> entry: bucketArray[i]) {
                    entryList.add(entry);
                }
            }
        }
        return entryList;
    }

    /**
     * Gets the probe sequence associated with a separate chaining hash table which used the first function.
     * @param keys - the keys which will have their locations looked up.
     * @return a string representing the probe sequence of the given keys inside the table.
     */
    public String firstFunctProbeSequence(ArrayList<String> keys) {
        String probeSequence = "";
        for(String key: keys) {
            probeSequence += firstHashFunction(key) + ": " + key + "\n";
        }
        return probeSequence;
    }

    /**
     * Gets the probe sequence associated with a separate chaining hash table which used the second function.
     * @param keys - the keys which will have their locations looked up.
     * @return a string representing the probe sequence of the given keys inside the table.
     */
    public String secondFunctProbeSequence(ArrayList<String> keys) {
        String probeSequence = "";
        for(String key: keys) {
            probeSequence += secondHashFunction(key) + ": " + key + "\n";
        }
        return probeSequence;
    }
}









