import java.util.ArrayList;

/**
 * Created by Brandon on 2017-02-25. Student I.D.: 201238730
 * A heap implementation of the priority queue ADT.
 */
public class HeapPriorityQueue<K, V> implements PriorityQueue<K,V> {

    private ArrayListCompleteBinaryTree<Entry<K,V>> heap;
    private CoolComparator c;

    /**
     * Class which implements Entry interface to create myEntry objects.
     * @param <K> - a key type
     * @param <V> - a value type.
     */
    class MyEntry<K,V> implements Entry<K,V> {
        protected K k;
        protected V v;

        /**
         * Constructs myEntry objects.
         * @param key - the key to be binded with this entry.
         * @param value - the value to be stored.
         */
        public MyEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Get the key.
         * @return the key.
         */
        public K getKey() {
            return k;
        }

        /**
         * Get the value.
         * @return the value.
         */
        public V getValue() {
            return v;
        }
    }

    /**
     * Constructs the heap priority queue objects.
     */
    public HeapPriorityQueue() {
        heap = new ArrayListCompleteBinaryTree<>();
        c = new CoolComparator();
    }

    /**
     * Gets the size of the priority queue.
     * @return the size of the priortity queue.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Checks whether or not the priority queue is empty.
     * @return the boolean value for whether the priortiy queue is empty or not.
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Gets the front node.
     * @return the front node.
     */
    public Position<Entry<K,V>> getFront() {
        if(isEmpty()) {
            return null;
        }
        return heap.getRoot();
    }

    /**
     * Gets the minimum ordered entry.
     * @return the minimum ordered entry.
     */
    public Entry<K,V> min() {
        if(isEmpty()) {
            throw new RuntimeException("Empty Heap, no minimum value to be found");
        }
        return heap.getRoot().getElement();
    }

    /**
     * Insert an entry into the priority queue by providing key and value.
     * @param key - the key to be binded to this entry.
     * @param value - the value to be stored
     * @return the entry which was created.
     */
    public Entry<K,V> insert(K key, V value) {
        Entry<K,V> newEntry = new MyEntry<K,V>(key, value);
        upHeap(heap.add(newEntry));
        return newEntry;
    }

    /**
     * Removes the minimum ordered entry in the priortiy queue.
     * @return the minimum ordered entry which was removed.
     */
    public Entry<K,V> removeMin() {
        if(isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        Entry<K,V> min = heap.getRoot().getElement();
        if(size() == 1) {
            heap.remove();
        }
        else {
            heap.replace(heap.getRoot(), heap.remove());
            downHeap(heap.getRoot());
        }
        return min;
    }

    /**
     * Pushes an entry up the heap when it is inserted so that it restores order in the heap.
     * @param nodeA - the node to be ordered.
     */
    public void upHeap(Position<Entry<K,V>> nodeA) {
        Position<Entry<K,V>> nodeB;
        while(!heap.isRoot(nodeA)) {
            nodeB = heap.getParent(nodeA);
            if(c.compare(nodeB.getElement().getKey(), nodeA.getElement().getKey()) <= 0) break;
            swap(nodeB, nodeA);
            nodeA = nodeB;
        }
    }

    /**
     * Pushes an entry down the heap when to restore order.
     * @param node the node to be pushed down.
     */
    public void downHeap(Position<Entry<K,V>> node) {
        while(heap.isInternal(node)) {
            Position<Entry<K,V>> smallerNode;
            if(!heap.hasRight(node)) {
                smallerNode = heap.getLeft(node);
            }
            else if(c.compare(heap.getLeft(node).getElement().getKey(), heap.getRight(node).getElement().getKey()) <= 0) {
                smallerNode = heap.getLeft(node);
            }
            else {
                smallerNode = heap.getRight(node);
            }

            if(c.compare(smallerNode.getElement().getKey(), node.getElement().getKey()) < 0) {
                swap(node, smallerNode);
                node = smallerNode;
            }
            else {
                break;
            }

        }
    }

    /**
     * Swaps two positions in the heap.
     * @param nodeA - the first node in the swap.
     * @param nodeB - the second node in the swap.
     */
    public void swap(Position<Entry<K,V>> nodeA, Position<Entry<K,V>> nodeB) {
        Entry<K,V> temp = nodeA.getElement();
        heap.replace(nodeA, nodeB.getElement());
        heap.replace(nodeB, temp);
    }

    /**
     * Gets an arrayList representation of the complete binary tree.
     * @return the arraylist representation of the complete binary tree.
     */
    public ArrayList<Position<Entry<K,V>>> getEntryList() {
        ArrayList<Position<Entry<K,V>>> entryList = new ArrayList<>();
        ArrayList<Position<Entry<K,V>>> temp = heap.getArrayList();
        //Add entries from one arraylist to the other so that nothing can be changed inside the original arraylist for the complete binary tree.
        for(int i = 1; i < temp.size(); i++) {
            entryList.add(temp.get(i));
        }
        return entryList;
    }
}
