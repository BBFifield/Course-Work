/**
 * Created by Brandon on 2017-02-15. Student I.D.: 201238730
 * This class allows you to create a binary tree, what follows are it's various methods.
 */
public class BTNode {

    private int data;
    private BTNode left;
    private BTNode right;
    private int xCoor;
    private int yCoor;

    //These are counters to be used by the generateYcoordinates() and generateXcoordinates methods.
    private static int countVisited = 0;
    private static int depthTracker = 0;

    /**
     * Constructs BTNode objects for the binary tree.
     * @param data - the value to be held by the node.
     */
    public BTNode(int data) {
        this.data = data;
        left = null;
        right = null;
        xCoor = 0;
        yCoor = 0;
    }

    /**
     * Constructs BTNode objects for the binary tree with additional paramters.
     * @param data - the value to be held by the node.
     * @param left - the left node linked to this node.
     * @param right - the right node linked to this node.
     */
    public BTNode(int data, BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        xCoor = 0;
        yCoor = 0;
    }

    /**
     * Gets the value inside the node.
     * @return the data value in the node.
     */
    public int getData() {
        return data;
    }

    /**
     * Sets the left node.
     * @param left - the node to be set as the left node.
     */
    public void setLeftNode(BTNode left) {
        this.left = left;
    }

    /**
     * Gets the left node.
     * @return the left node linked to this node.
     */
    public BTNode getLeftNode() {
        return left;
    }

    /**
     * Sets the right node of this node.
     * @param right - the right node linked to this node.
     */
    public void setRightNode(BTNode right) {
        this.right = right;
    }

    /**
     * Gets the right node.
     * @return the right node linked to this node.
     */
    public BTNode getRightNode() {
        return right;
    }

    /**
     * Checks to see if there is a left node linked to this node.
     * @return whether or not this node has a left node.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * Checks to see if there is a right node linked to this node.
     * @return whether or not this node has a right node.
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * Gets the x-coordinate of the node, used for drawing binary trees.
     * @return the x-coordinate of the node.
     */
    public int getxCoor() {
        return xCoor;
    }

    /**
     * Sets the x-coordinate of the node, used for drawing binary trees.
     * @param xCoor - the x-coordinate to be set.
     */
    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    /**
     * Gets the y-coordinate of the node, used for drawing binary trees.
     * @return the y-coordinate of the node.
     */
    public int getyCoor() {
        return yCoor;
    }

    /**
     * Sets the y-coordinate of the node, used for drawing binary trees.
     * @param yCoor - the y-coordinate to be set.
     */
    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    /**
     * Inserts an integer into the binary tree.
     * @param dataValue - the value to be inserted.
     * @param root - the root of the binary tree.
     */
    public static void insert(int dataValue, BTNode root) {
        //If value is less than the current node, traverse the left side of the node.
        if(root.getData() > dataValue) {
            //if the left node is not null, continue traversing down the tree.
            if(root.hasLeft())
                insert(dataValue, root.getLeftNode());
            //If the left node is null, set the left node to hold the data value.
            else
                root.setLeftNode(new BTNode(dataValue));
        }
        //If value is greater than the current node, traverse the right side of the node.
        else if(root.getData() < dataValue) {
            //if the right node is not null, continue traversing down the tree.
            if(root.hasRight())
                insert(dataValue, root.getRightNode());
            //If the right node is null, set the right node to hold the data value.
            else
                root.setRightNode(new BTNode(dataValue));
        }
        //In the case where the value is equal to any value currently in the tree, throw an exception, as it is not normal for
        //binary search trees to hold two the same values.
        else {
            throw new RuntimeException("You cannot insert a value equal to another value into this Binary Search Tree.");
        }
    }

    /**
     * Conducts an inorder traversal of the binary tree starting at the root and outputs a node's contents when it is visited.
     * @param root - The root of the tree.
     */
    public static void inOrder(BTNode root) {
        if(root != null) {
            inOrder(root.getLeftNode());
            System.out.print(root.getData() + " ");
            inOrder(root.getRightNode());
        }
    }

    /**
     * Conducts a postorder traversal on the binary tree, outputs contents at each node visit.
     * @param root - the root of the binary tree.
     */
    public static void postOrder(BTNode root) {
        if( root != null) {
            postOrder(root.getLeftNode());
            postOrder(root.getRightNode());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * Finds the height of a binary tree.
     * @param root - the root of the tree.
     * @return the height of the tree.
     */
    public static int height(BTNode root) {
        //If the left and right nodes of a node are both null, then it must mean that this node is external, thus the height is zero.
        if(!root.hasLeft() && !root.hasRight()) {
            return 0;
        }
        //If the left node of a node is null, the continue down the right side and add 1 to the height of the tree.
        else if(!root.hasLeft()) {
            return height(root.getRightNode()) + 1;
        }
        //If the right node of a node is null, the continue down the left side and add 1 to the height of the tree.
        else if(!root.hasRight()) {
            return height(root.getLeftNode()) + 1;
        }
        //In all other cases, both nodes must not be null, and therefore we must take the max of both sides to get the height of the tree.
        return Math.max(height(root.getLeftNode()) + 1, height(root.getRightNode()) + 1);
    }

    /**
     * Counts the number of nodes in a tree.
     * @param root - the root of the tree.
     * @return the number of nodes in the tree.
     */
    public static int count(BTNode root) {
        if(root != null) {
            return 1 + count(root.getLeftNode()) + count(root.getRightNode());
        }
        return 0;
    }

    /**
     * Determines whether a value occurs inside a tree, and if so it returns the node containing the value, if not return null.
     * @param number - the number to look for.
     * @param root - the root of the binary tree.
     * @return the node which contains the value, or null if none.
     */
    public static BTNode occurs(int number, BTNode root) {
        if(root == null) {
            System.out.printf("%nThe number " + number + " does not occur in this tree.%n");
            return null;
        }
        else if(root.getData() == number) {
            System.out.printf("%nThe number " + root.getData() + " does occur in this tree.%n");
            return root;
        }
        else if(root.getData() > number) {
            return occurs(number, root.getLeftNode());
        }
        else {
            return occurs(number, root.getRightNode());
        }
    }

    /**
     * Gets the sum of all values in the tree.
     * @param root - the root of the tree.
     * @return the sum.
     */
    public static int sum(BTNode root) {
        int sumOfNums = 0;
        if(root == null) {
            return sumOfNums;
        }
        sumOfNums = sumOfNums + root.getData();
        return sumOfNums + sum(root.getLeftNode()) + sum(root.getRightNode());
    }

    /**
     * Generates x-coordinates for each node in the tree so that they can be outputted as a drawing.
     * @param root - the root of the tree.
     */
    public static void generateXcoordinates(BTNode root) {
        //Uses inorder traversal to count each successive node in the tree and sets the x-coor of the node to the count at that time.
        if(root != null) {
            generateXcoordinates(root.getLeftNode());
            root.setxCoor(countVisited);
            countVisited += 1;
            generateXcoordinates(root.getRightNode());
        }
    }

    /**
     * Generates y-coordinates for each node in the tree so that they can be outputted as a drawing.
     * @param root - the root of the tree.
     * @param depth - the depth of the current node.
     */
    public static void generateYcoordinates(BTNode root, int depth) {
        //Uses preorder traversal to generate the y coordinates.
        if( root != null) {
            root.setyCoor(depth);
            //Increment the depth counter when going down the tree.
            depthTracker = depthTracker + 1;
            generateYcoordinates(root.getLeftNode(), depthTracker);
            generateYcoordinates(root.getRightNode(), depthTracker);
            //Decrement the depth counter when the recursive call is done.(Going up the tree.)
            depthTracker = depthTracker - 1;
        }
    }

    /**
     * Generates a 2Darray using x and y coordinates of each node in the tree.
     * @param root - the root of the tree.
     * @param array -  the array to be generated.
     */
    public static void generate2Darray(BTNode root,BTNode[][] array) {
        if(root != null) {
            array[root.getyCoor()][root.getxCoor()] = root;
            generate2Darray(root.getLeftNode(), array);
            generate2Darray(root.getRightNode(), array);
        }
    }

    /**
     * Draws a binary search tree inside the console.
     * @param root - the root of the tree.
     */
    public static void draw(BTNode root) {
        //Resets the countVisited variable to zero.
        countVisited = 0;
        BTNode[][] arrayBTNodes = new BTNode[height(root) + 1][count(root)];
        generateXcoordinates(root);
        generateYcoordinates(root, depthTracker);
        generate2Darray(root, arrayBTNodes);

        //Print out the array. When a value in the array is null print out a whitespace.
        for(int i = 0; i < arrayBTNodes.length; i++) {
            for(int j = 0; j < arrayBTNodes[i].length; j++) {
                if(arrayBTNodes[i][j] == null) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(arrayBTNodes[i][j].getData());
                }
            }
            System.out.println();
        }
    }
}
