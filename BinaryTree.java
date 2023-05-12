/*
 * Name: Isaac Francisco Marte
 * Class: CMSC 350
 * Purpose: The Binary tree class holds several methods that allow to create a binary tree and
   check several conditions on the tree structure based on the input supplied by the user in the main class.
   When a method is called the binary tree nodes are created or assessed to inform the user if conditions
   like the tree being balanced, full, or proper are checked. Also, the height, number of nodes
   and an inorder traversal of the tree are the main capabilities allowed by the class.
 * */

package cmsc350projects.project1;


import java.util.Stack;

// The Binary class creates a binary tree and provides several operations that can be performed on the tree
public class BinaryTree{

    // initiates variable for root node in the binary search tree
    private Node root;


    /*
    * The Binary Tree constructor accepts a string input of the value provided in the input field
      and checks the input to make sure it is not equal to null or blank. If the value is null or
      empty a new invalid syntax message is thrown otherwise sets the root equal to null. */
    public BinaryTree(String treeInput) throws InvalidTreeSyntax {
        if( treeInput == null || treeInput.isEmpty()){
            throw new InvalidTreeSyntax("No input was provided to build the Binary Tree");
        }
        root = null;
    }

    // Node class which has three attributes
    public static class Node {
        private char data; // stores data associated with a node
        private Node left; // stores the position of the left current node
        private Node right;

        // Node class constructor initializes the attributes of the node class used by the tree methods
        public Node(char element){
            this.data = element;
            this.left = null;
            this.right = null;
        }
    }


    // This method is used to create the binary tree structure and is used when the make tree button is pressed
    public void makeTree(String treeInput) {
        Stack<Node> nodeStack = new Stack<>();
        Node parent = null;
        Node child = null;

        // for loop iterates through each character of input and checks for parenthesis to determine position
        for (int i = 0; i < treeInput.length(); i++) {
            char nodeValue = treeInput.charAt(i);

           /* condition checks to see if characters are digit or alphabetical and construct the tree
              through the iteration on each character based on the current node position and ensures
              each node only has a left and right child. */
            if (nodeValue == '(') {
                if (child != null) {
                    parent = child;
                    nodeStack.push(child);
                    child = null;
                }
                nodeStack.push(parent);
                parent = null;
            } else if (nodeValue == ')') {
                if (child != null) {
                    if(parent == null){
                        parent = nodeStack.pop();
                    }
                    if(parent.left == null){
                        parent.left = child;
                    } else if (parent.right == null){
                        parent.right = child;
                    }
                    child = null;
                }
                parent = nodeStack.pop();

            } else {
                if (!Character.isAlphabetic(nodeValue)
                        || !Character.isDigit(nodeValue)){
                    throw new InvalidTreeSyntax("Invalid Input: Values for tree must be alphabetical or numerical");
                } else if (Character.isDigit(nodeValue) && child != null){
                    int number = Character.getNumericValue(nodeValue);
                    child = new Node((char) number);
                } else if (Character.isLetter(nodeValue) && child == null){
                    child = new Node(nodeValue);
                }
            }
        }
            root = parent; // sets root to parent
        }


        // The is balanced method allows user to check if the entire binary tree is balanced or not,
        // by passing the root node of the tree.
        public boolean isBalanced () {
            return isBalanced(root);
        }

        // The private isBalanced method provides allows user to check the balance of a subtree
        // rooted from the given node.
        private boolean isBalanced (Node node){
            if (node == null)
                return true;
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            if (Math.abs(leftHeight - rightHeight) <= 1
                    && isBalanced(node.left)
                    && isBalanced(node.right))
                return true;
            return false;
        }


        // recursively calls the isFull private method by passing in the current node and accessing tree is full
        public boolean isFull () {
            return isFull(root);
        }

        // verifies the current node to check if the node is null and returns true then checks the
        // left child node and right child node to see if null and returns true if so
        // if the left and right child node are not null recursively recalls the is full method
        // else returns false
        private boolean isFull (Node node){
            if (node == null)
                return true;
            if (node.left == null && node.right == null)
                return true;
            if (node.left != null && node.right != null)
                return (isFull(node.left) && isFull(node.right));
            return false;
        }


        // passes the root node within its parameters and supplies the argument to the private is proper method
        public boolean isProper () {
            return isProper(root);
        }

        // If the binary tree is proper, the method returns true. Otherwise, it returns false
        private boolean isProper (Node node){
            if (node == null)
                return true;
            if (node.left == null && node.right == null)
                return true;
            if (node.left != null && node.right != null)
                return (isProper(node.left) && isProper(node.right));
            return false;
        }


        // uses the private get height helper method and supplies the root/current node to the method argument
        public int getHeight () {
            return getHeight(root);
        }

        // the method uses recursion to calculate the height of the tree from root to left and right subtree
        private int getHeight (Node node){
            if (node == null)
                return -1;
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }


        // provides the root/current node to the private current node method arguments
        public int countNodes () {
            return countNodes(root);
        }

        // Method is used to count the number of nodes in a binary tree using recursion to add the sum of the nodes
        private int countNodes (Node node){
            if (node == null)
                return 0;
            return 1 + countNodes(node.left) + countNodes(node.right);
        }


        // The inorder traversal method initiates a string builder object and recursively calls its helper method
        public String inorderTraversal() {
            StringBuilder sb = new StringBuilder();
            inorderTraversal(root, sb);
            return sb.toString();
        }
        // the inorderTraversal() method recursively visits all the nodes of the binary tree left, root, right
        // and builds a new string value incorporating the tree's contents.
        private void inorderTraversal (Node node, StringBuilder sb){
            if (node == null)
                return;
            sb.append("(");
            inorderTraversal(node.left, sb);
            sb.append(node.data);
            inorderTraversal(node.right, sb);
            sb.append(")");
        }
}
