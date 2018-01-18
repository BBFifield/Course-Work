import java.util.Scanner;

/**
 * Created by Brandon on 2017-02-15. Student I.D.: 201238730
 * This program creates binary search tree and does some operations on it.
 */
public class BinaryTreeRunner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //This array of integers is to be used as input for the Binary Search Tree.
        int[] integerValues = {9, 3, 10, 7, 6, 2, 1, 8, 4};

        //Create the new Binary Search Tree and insert the integers from the array into it.
        BTNode binaryTree = new BTNode(5);
        for(int value: integerValues) {
            BTNode.insert(value, binaryTree);
        }

        //Gets and outputs the number of nodes in the binary tree.
        int numNodes = BTNode.count(binaryTree);
        System.out.println("The number of nodes in this Binary Search Tree is: " + numNodes);

        //Gets and outputs the height of the binary tree.
        int height = BTNode.height(binaryTree);
        System.out.println("The height of this Binary Search Tree is: " + height);

        //Outputs the contents of the tree using inOrder traversal.
        System.out.printf("%nThe outputted contents using inorder traversal is:%n");
        BTNode.inOrder(binaryTree);
        //Outputs the contents of the tree using postOrder traversal.
        System.out.printf("%nThe outputted contents using postorder traversal is:%n");
        BTNode.postOrder(binaryTree);

        //Gets a number from the user to see if it occurs inside the tree and returns the node which holds the number.
        System.out.printf("%nType in a number to see if it occurs in the tree: ");
        int numToSearch = in.nextInt();
        BTNode nodeReturned = BTNode.occurs(numToSearch, binaryTree);
        if(nodeReturned != null) {
            System.out.println("The number of the node returned is: " + nodeReturned.getData());
        }

        //Gets the sum of values in the binary tree and outputs it.
        int sum = BTNode.sum(binaryTree);
        System.out.println("The sum of the values in the binary tree is: " + sum);

        //Draws the binary tree.
        System.out.printf("%nA drawing of the binary search tree: %n%n");
        BTNode.draw(binaryTree);
    }
}
