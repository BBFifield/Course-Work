/**
 * Created by Brandon on 2017-03-02. Student I.D.: 201238730
 * This program creates two queue ADTs that use different priority queue implementations, an unsorted list and a heap.
 */
public class QueueTests {
    public static void main(String[] args) {

        //Construct the two different queues.
        Queue<String> queueUnsorted = new Queue<>(new UnsortedListPriorityQueue<>());
        Queue<String> queueHeap = new Queue<>(new HeapPriorityQueue<>());

        //Make an array of values to be inputted into the queues for testing.
        String[] names = {"Brandon", "Adam", "Griff", "Shawn", "Marvin", "Barry", "Michelle", "Dot", "Lucas", "Ben"};
        for(String name: names) {
            queueUnsorted.enqueue(name);
            queueHeap.enqueue(name);
        }

        //Shows the contents of the unsorted list queue after all enqueues have taken place.
        System.out.println("Unsorted list queue after insertion of all elements: " + queueUnsorted.toString());
        System.out.println("Unsorted list queue after each succesive dequeue: \n");

        //Shows the contents of the unsorted list queue after each dequeue, in addition to the front value and size.
        for(int i = 0; i < 9; i++) {
            queueUnsorted.dequeue();
            System.out.println(queueUnsorted.toString());
            System.out.println("Front: " + queueUnsorted.front().getElement().getKey());
            System.out.println("Size: " + queueUnsorted.size() + "\n");
        }

        System.out.println("_____________________________________________________________________________________________________________________\n");

        //Shows contents of heap queue after all enqueues.
        System.out.println("Heapified list queue after insertion of all elements: " + queueHeap.toString());
        System.out.println("Heapified list queue after each succesive dequeue: \n");

        //Shows the contents of the heap list queue after each dequeue, in addition to the front value and size.
        for(int i = 0; i < 9; i++) {
            queueHeap.dequeue();
            System.out.println(queueHeap.toString());
            System.out.println("Front: " + queueHeap.front().getElement().getKey());
            System.out.println("Size: " + queueHeap.size() + "\n");
        }
    }
}
