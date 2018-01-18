import java.util.ArrayList;

/**
 * Created by Brandon on 2017-03-02. Student I.D.: 201238730
 * Creates a complete binary tree.
 */
public class ArrayListCompleteBinaryTree<E> {
    private ArrayList<Position<E>> T;

    /**
     * Class for BTNodes
     * @param <E> - Element type
     */
    class BTNode<E> implements Position<E> {
        E element;

        /**
         * Contructs BTNodes to be used in the tree.
         * @param element - the element stored at this node.
         */
        public BTNode(E element) {
            this.element = element;
        }

        //Returns the element stored at this node
        public E getElement() {
            return element;
        }

        //Sets the element stored at this node
        public E setElement(E element) {
            this.element = element;
            return element;
        }
    }

    /**
     * Constructs a new arrayList based complete binary tree.
     */
    public ArrayListCompleteBinaryTree() {
        T = new ArrayList<Position<E>>();
        T.add(0, null);
    }

    /**
     * Gets the size of the tree. It's size - 1 since the first entry is always null.
     * @return the size of the tree
     */
    public int size() {
        return T.size() - 1;
    }

    /**
     * Checks whether or not the tree is empty.
     * @return the boolean value.
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Checks whether or not a node is internal
     * @param node the node to be checked
     * @return the boolean value
     */
    public boolean isInternal(Position<E> node) {
        return hasLeft(node);
    }

    /**
     * Checks whether or not the node is external
     * @param node the node to be checked
     * @return the boolean value
     */
    public boolean isExternal(Position<E> node) {
        return !isInternal(node);
    }

    /**
     * Checks whether or not the node is located at the root
     * @param node the node to be checked
     * @return the boolean value
     */
    public boolean isRoot(Position<E> node) {
        BTNode<E> checkedNode = checkPosition(node);
        return T.indexOf(checkedNode) == 1;
    }

    /**
     * Checks whether or not the node has a left child
     * @param node the node to be checked
     * @return the boolean value
     */
    public boolean hasLeft(Position<E> node) {
        BTNode<E> checkedNode = checkPosition(node);
        return 2*(T.indexOf(checkedNode)) + 1 <= size();
    }

    /**
     * checks whether or not the node has a right child
     * @param node the node to be checked
     * @return the boolean value
     */
    public boolean hasRight(Position<E> node) {
        BTNode<E> checkedNode = checkPosition(node);
        return 2*(T.indexOf(checkedNode)) + 1 <= size();
    }

    /**
     * Gets the root of the tree
     * @return the root of the tree
     */
    public Position<E> getRoot() {
        if(isEmpty()) { throw new RuntimeException("Tree is empty"); }
        return T.get(1);
    }

    /**
     * Gets the left child of the node
     * @param node - the node to get the left child from
     * @return the left child
     */
    public Position<E> getLeft(Position<E> node) {
        if(!hasLeft(node)) { throw new RuntimeException("No left child"); }
        BTNode<E> checkedNode = checkPosition(node);
        return T.get(2*(T.indexOf(checkedNode)));
    }

    /**
     * Gets the right child of the node provided
     * @param node - the node to get the right child from
     * @return the right child
     */
    public Position<E> getRight(Position<E> node) {
        if(!hasLeft(node)) { throw new RuntimeException("No right child"); }
        BTNode<E> checkedNode = checkPosition(node);
        return T.get(2*(T.indexOf(checkedNode)) + 1);
    }

    /**
     * Gets the parent of the node
     * @param node - the node to get the parent from
     * @return the parent
     */
    public Position<E> getParent(Position<E> node) {
        if(isRoot(node)) { throw new RuntimeException("No parent"); }
        BTNode<E> checkedNode = checkPosition(node);
        return T.get((T.indexOf(checkedNode))/2);
    }

    /**
     * Replaces a value at a position with another.
     * @param node - the position of the element to be replaced
     * @param element - the element to replace the other
     * @return the element which replaced the other
     */
    public E replace(Position<E> node, E element) {
        BTNode<E> checkedNode = checkPosition(node);
        return checkedNode.setElement(element);
    }

    /**
     * Add an element to the tree
     * @param element - the element to be added
     * @return the element which was added
     */
    public BTNode<E> add(E element) {
        int index = size() + 1;
        BTNode<E> newNode = new BTNode<>(element);
        T.add(index, newNode);
        return newNode;
    }

    /**
     * Removes the bottom-right most node in the tree
     * @return the node which was removed
     */
    public E remove() {
        if(isEmpty()) { throw new RuntimeException("No element to remove"); }
        return T.remove(size()).getElement();
    }

    /**
     * Checks whether the position actually exisits.
     * @param node - the node to be checked
     * @return the node which was checked
     */
    private BTNode<E> checkPosition(Position<E> node) {
        if(node == null) { throw new RuntimeException("Invalid position"); }
        return (BTNode<E>) node;
    }

    /**
     * Gets the arrayllist of the tree
     * @return the arraylist of this tree
     */
    public ArrayList<Position<E>> getArrayList() {
        return T;
    }
}
