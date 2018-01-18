import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Brandon on 2017-02-02. Student I.D.: 201238730
 * This class allows you to create a singly-linked list based Queue which processes endnotes in documents for you and puts
 * them in a different format.
 */
public class QEndnoteProcessor {
    private File document;
    private File updatedDocument;

    private BufferedReader in;
    private BufferedWriter writeDoc;
    private BufferedWriter writeUpDoc;

    private int size;
    int sizeBeforeEnoteEnqueue;
    private Node head;
    private Node tail;

    /**
     * Constructs a singly-linked Queue Endnote Processor.
     * @param document - the document to be processed.
     * @throws IOException
     */
    public QEndnoteProcessor(File document) throws IOException {
        this.document = document;
        updatedDocument = new File("updatedDocument.txt");

        in = new BufferedReader(new FileReader(document));

        size = 0;
        //This will keep the size of the queue before the endnotes were stored and after the lines from the document
        //were stored. This way we can keep them separated from one another for further processing.
        sizeBeforeEnoteEnqueue = 0;
        head = new Node();
        tail = new Node();
    }

    /**
     * Gets the size of the Queue.
     * @return - the size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Gets a truth value of whether or not the Queue is empty.
     * @return - True or False for Queue emptiness.
     */
    public boolean isEmpty() {
        return(size == 0);
    }

    /**
     * Gets the front node of the Queue.
     * @return - the front node of the queue.
     * @throws RuntimeException - when there is an empty stack.
     */
    public Node front() throws RuntimeException{
        if(isEmpty()) {
            throw new RuntimeException("Exception: Empty Stack");
        }
        return head;
    }

    /**
     * Links a new node at the rear of the queue.
     * @param element - the element to be stored in the queue.
     */
    public void enqueue(String element) {
        Node node = new Node(element, null);
        if(size == 0) {
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    /**
     * Removes a node at the front.
     * @return the string element removed at the front.
     * @throws RuntimeException - when there is an empty stack.
     */
    public String dequeue() throws RuntimeException {
        if(size == 0) {
            throw new RuntimeException("Exception: Empty Queue");
        }
        String temp = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0) {
            tail = null;
        }
        return temp;
    }

    /**
     * Gets each line in the document and stores them in the queue for further processing.
     * @throws IOException
     */
    public void getLines() throws IOException{
        String line = null;
        while (in.ready()) {
            line = in.readLine();
            enqueue(line);
        }
    }

    /**
     * Gets the endnotes from the stored lines and then puts them at the rear of the queue. It also modifies the lines
     * so that they say "(endnote n)" in place of every endnote.
     * @throws IOException - thrown by getLines.
     */
    public void getEndnotes() throws IOException {

        getLines();

        //The index to be used when replacing endnotes with "(Endnote n)" where n is index.
        int endnoteIndex = 1;
        sizeBeforeEnoteEnqueue = size;

        Node current = head;
        String line = current.getElement();

        int indexLeftToken = 0;
        int indexRightToken = 0;
        boolean foundLeftToken = false;

        //Iterate through all nodes in the queue that aren't enotes.
        for(int j = 0; j < sizeBeforeEnoteEnqueue; j++) {
            for (int i = 0; i < line.length(); i++) {
                //See if the line contains a '{'.
                if (line.charAt(i) == '{') {
                    //Get its index to later locate the enote.
                    indexLeftToken = i;
                    foundLeftToken = true;
                } else if (line.charAt(i) == '}' && foundLeftToken) {
                    indexRightToken = i;

                    //Get the endnote itself and store it in endnote.
                    String endnote = line.substring(indexLeftToken, indexRightToken + 1);
                    //Replace {"endnote"} with "(Endnote n)".
                    line = line.replace(endnote, String.format("(Endnote %d)", endnoteIndex));
                    //Set the currently selected node's element to the modified line.
                    current.setElement(line);
                    //Modify the endnotes to a number in front  and without curly braces.
                    endnote = String.format("%d. %s", endnoteIndex, endnote.subSequence(1,endnote.length() - 1));
                    enqueue(endnote);
                    endnoteIndex++;
                }
            }
            current = current.getNext();
            line = current.getElement();
        }
    }

    /**
     * Output the queue contents to two files. A new file called "updatedDocument.txt" and an old document called
     * "Endnotes.txt" which had contained the old information to be processed.
     */
    public void process() {
        try {
            getEndnotes();

            //Set up two streams to write to the two documents.
            FileWriter blah = new FileWriter(document);
            FileWriter hah = new FileWriter(updatedDocument);
            //Set up a couple buffers.
            writeDoc = new BufferedWriter(blah);
            writeUpDoc = new BufferedWriter(hah);

            //Dequeue all elements in the Queue so that they can be written to the files.
            while (head != null) {
                String dequeuedElement = dequeue();
                //Write the contents in the buffer.
                writeDoc.write(String.format("%s%n",dequeuedElement));
                writeUpDoc.write(String.format("%s%n",dequeuedElement));
            }
            //Close the streams and flush all contents in the buffers to the files.
            writeUpDoc.close();
            writeDoc.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates nodes to be used in the Singly-Linked list of the queue.
     */
    class Node {
        private String element;
        private Node next;

        /**
         * Constructs Node objects.
         * @param element - a string object to be stored at this address.
         * @param next - the next node in the list.
         */
        public Node(String element, Node next) {
            this.element = element;
            this.next = next;
        }

        /**
         * Default constructor for the Node class.
         */
        public Node() {
            element = "";
            next = null;
        }

        /**
         * Gets the string element.
         * @return the string element.
         */
        public String getElement() {
            return element;
        }

        /**
         * Gets the address of the node which is linked to this one.
         * @return the address of the next node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets the String at this node.
         * @param element the string element to be set.
         */
        public void setElement(String element) {
            this.element = element;
        }

        /**
         * Sets the next node.
         * @param next - the next node.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }
}