import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-02. Student I.D.: 201238730
 * This class allows you to create an unsorted list priority queue.
 */
public class UnsortedListPriorityQueue<K,V> implements PriorityQueue<K,V> {

    private static int size = 0;
    private CoolComparator c;
    private Node<Entry<K,V>> front;
    private Node<Entry<K,V>> rear;

    /**
     * Creates myEntry objects to be hold keys for ordering, and values for storing.
     * @param <K> - A key type.
     * @param <V> - A value type.
     */
    class myEntry<K,V> implements Entry<K,V> {
        protected K k;
        protected V v;

        /**
         * Creates myEntry objects
         * @param key - the key which orders the entry
         * @param value - value to be stored.
         */
        public myEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Gets the key for this entry.
         * @return the key for this entry.
         */
        public K getKey() {
            return k;
        }

        /**
         * Gets the value for this entry.
         * @return the value for this entry.
         */
        public V getValue() {
            return v;
        }
    }

    /**
     * A node class for storing entries and linking to entries in a list.
     * @param <E> - an element type.
     */
    class Node<E> implements Position<E> {
        private E element;
        private Node<E> next;

        /**
         * Creates node objects.
         * @param element - the element to be stored at this node.
         * @param next -  the next node in the list.
         */
        public Node(E element, Node next) {
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
         * Sets the element stored at this node
         * @param element - the element to be stored at this node
         * @return the element which was stored at this node.
         */
        public E setElement(E element) {
            this.element = element;
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
         * Sets the next node in the list.
         * @param next - the next node in the list to be set.
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /**
     * Constructs an UnsortedListPriorityQueue.
     */
    public UnsortedListPriorityQueue() {
        c = new CoolComparator();
        front = null;
        rear = null;
    }

    /**
     * Gets the size of the priority queue.
     * @return the size of the priority queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the priority queue is empty.
     * @return boolean value for whether it is empty or not.
     */
    public boolean isEmpty() {
        if(front == null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Inserts an entry into the queue.
     * @param key - the key of the entry
     * @param value - the value to be stored.
     * @return the entry which was stored.
     */
    public Entry<K,V> insert(K key, V value) {
        size++; //Increase size of priority queue each time method is called.
        Entry<K,V> entry = new myEntry<>(key,value);
        Node<Entry<K,V>> newNode = new Node<>(entry,null);
        if(!isEmpty()) {
            rear.setNext(newNode);
            rear = rear.getNext();
        }
        else {
            front = newNode;
            rear = front;
        }
        return entry;
    }

    /**
     * Gets the node at the front of the queue.
     * @return the front of the queue.
     */
    public Node<Entry<K,V>> getFront() {
        return front;
    }

    /**
     * Finds the minimum ordered entry in the priority queue.
     * @return the minimum entry.
     */
    public Entry<K,V> min() {
        Node<Entry<K,V>> current = front;
        Entry<K,V> minimumEntry = current.getElement();
        if(isEmpty()) {
            throw new RuntimeException("Priority Queue is Empty, no minimum element.");
        }
        else {
            while(current.getNext() != null) {
                if(c.compare(current.getElement().getKey(), current.getNext().getElement().getKey()) < 0) {
                    minimumEntry = current.getElement();
                }
                else if(c.compare(current.getElement().getKey(), current.getNext().getElement().getKey()) > 0) {
                    minimumEntry = current.getNext().getElement();
                }
                current = current.getNext();
            }
        }
        return minimumEntry;
    }

    /**
     * Removes the minimum entry from the priority queue. Since the entries are not ordered we have to traverse the
     * list each time to find the minimum entry.
     * @return the minimum entry which was removed.
     */
    public Entry<K,V> removeMin() {
        Node<Entry<K,V>> current = front;
        Node<Entry<K,V>> minimumEntry = current;
        Node<Entry<K,V>> previousToMinimum = null; //previousToMinimum is used to link the node before and after minimum once it is removed.
        if(isEmpty()) {
            throw new RuntimeException("Priority Queue is Empty, no minimum element.");
        }
        else if(front.getNext() == null) {
            front = null;
        }
        else {
            while(current.getNext() != null) {
                if(c.compare(minimumEntry.getElement().getKey(), current.getNext().getElement().getKey()) > 0) {
                    previousToMinimum = minimumEntry;
                    minimumEntry = current.getNext();
                }
                current = current.getNext();
            }
        }

        if(previousToMinimum == null) {
            front = front.getNext();
        }
        else {
            previousToMinimum.setNext(minimumEntry.getNext());
            minimumEntry.setNext(null);
        }
        size--;
        return minimumEntry.getElement();
    }

    /**
     * Gets an arrayList representation of the priority queue.
     * @return the arraylist.
     */
    public ArrayList<Position<Entry<K,V>>> getEntryList() {
        ArrayList<Position<Entry<K,V>>> entryList = new ArrayList<>();
        Node<Entry<K,V>> current = front;
        while(current != null) {
            entryList.add(current);
            current = current.getNext();
        }
        return entryList;
    }
}
