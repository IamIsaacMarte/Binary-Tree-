# Binary-Tree- Creates a Binary Tree based on the input provided and adds each character of the input as a node value to construct the tree structure. The program verified that the input is alphabatical, numerical or a open or closing parenthesis. If a special character is entered a message is displayed to the user. Once the tree is created the program will allow you to check several statuses of the structure like if it is balanced, full, or proper and returns a message to user based on if the conditions are true or false. Once the tree is created, yout are also able to do an inorder treversal of the tree which is left subtree, root, right subtree. Within the main class the GUI is created using Java swing to interact with the user and accept input, and button press events. 

Explanation of the code and classes used for the program in more detail are below. 


Main Class
The Main class extends the JFrame class to create a window for the GUI application and implements the ActionListener interface to handle events of the GUI components within the window using several imports modules from the java swing and awt libraries. 

 
Within the main class the buttons, labels, and text fields are initiated and are private to ensure they are not assessable outside of the constructor. The components are given their respective names and provide the user with messages to ensure they know how to use the application. 
// Variables set to constants for the gui fields such as label, buttons, and text fields.
private static final JLabel TREE_INPUT_LABEL = new JLabel("Enter Tree");
private static final JLabel OUTPUT_TREE_LABEL = new JLabel("Output");
private static final JButton MAKE_TREE_BUTTON = new JButton("Make Tree");
private static final JButton IS_BALANCED_BUTTON = new JButton("Is Balanced?");
private static final JButton IS_FULL_BUTTON = new JButton("Is Full?");
private static final JButton IS_PROPER_BUTTON = new JButton("Is Proper?");
private static final JButton HEIGHT_BUTTON = new JButton("Height");
private static final JButton NODES_BUTTON = new JButton("Nodes");
private static final JButton INORDER_BUTTON = new JButton("Inorder");
private static final JTextField TREE_INPUT_FIELD = new JTextField(25);
private static final JTextField OUTPUT_FIELD = new JTextField(25);

Main Class Constructor
The Main class constructor creates the main panel of the GUI along with the BorderLayout layout manager and sets the title of the window using super. Within the BorderLayout 3 additional nested panels are added to the north, center, and south position of the layout manager and an empty border is set around to improve appearance of the interface. 
// constructor which sets title of window and panel properties such the layout manager and location of components
public Main() {
    super("Binary Tree Maker");
    JPanel mainPanel = new JPanel(); // Main panel where other panels are nested for position
    setContentPane(mainPanel); // Sets main panel to the window
    mainPanel.setBorder(new EmptyBorder(5,5,5,5));
    mainPanel.setLayout(new BorderLayout());  // Instantiates border layout manager in the main panel
    mainPanel.add(northPanel(), BorderLayout.NORTH); // positions north panel in north of border layout
    mainPanel.add(centerPanel(), BorderLayout.CENTER);  // positions center panel in center of border layout
    mainPanel.add(southPanel(), BorderLayout.SOUTH); // positions south panel in south of border layout

}

The North Panel Method
The northPanel creates a JPanel object and holds the components for the label and text field used by the user to enter the expression they wish to use to create the binary tree. The northPanel method and the northPanel object have the same name and indicate its position within the border layout. The method returns the panel object along with the components within it. 
// North panel method sets input label and text field in north section of border layout
private JPanel northPanel() {
    JPanel northPanel = new JPanel(); // initiates a new panel for north position
    northPanel.add(TREE_INPUT_LABEL); // add the input label
    northPanel.add(TREE_INPUT_FIELD); // add the text field for the input entered by user
    return northPanel;  // return the new north panel with associated attributes in north of border layout
}

The Center Panel Method
The centerPanel creates a JPanel object and holds the components for the buttons used by the user to make a tree once an input is provided in the northPanel, and checks for several statuses based on the input given by the user, and the button pressed. The centerPanel method and the centerPanel object have the same name and indicate its position within the border layout. The method returns the panel object along with the button components within it. 
// Center panel method sets the buttons for different functionalities in center of border layout
private JPanel centerPanel(){
    JPanel centerPanel = new JPanel();  // initiates a new panel object for center position
    centerPanel.add(MAKE_TREE_BUTTON); // adds the make tree button to center panel
    centerPanel.add(IS_BALANCED_BUTTON); // adds the is balanced button to center panel
    centerPanel.add(IS_FULL_BUTTON);  // adds is full button to center panel
    centerPanel.add(IS_PROPER_BUTTON); // adds is proper button to center panel
    centerPanel.add(HEIGHT_BUTTON); // adds the height button to the center panel
    centerPanel.add(NODES_BUTTON);  // adds the count nodes button to center panel
    centerPanel.add(INORDER_BUTTON); // adds the inorder button to center panel
    return centerPanel;  // returns the new center panel which is placed in center of border layout
}

The South Panel Method
The southPanel creates a JPanel object and holds the components for the label and text field that displays the ouput messages or values based on the input, and buttons pressed within the GUI. The southPanel method and the southPanel object have the same name and indicate its position within the border layout. The method returns the panel object along with the components within it. 
// South panel method displays the output label and text field in south of border layout
private JPanel southPanel(){
    JPanel southPanel = new JPanel();
    southPanel.add(OUTPUT_TREE_LABEL);
    southPanel.add(OUTPUT_FIELD);
    return southPanel;
}

The Action Performed Method
The actionPerformed method is called when a GUI component event occurs and handles the functionality based on which button is pressed by the user.  If the MAKE_TREE_BUTTON is pressed, a new binary tree object is created with the input value, and if successful, the text "Binary tree successfully created" is displayed in the output text field. Similarly, if the IS_BALANCED_BUTTON is pressed, the isBalanced method is called on the binary tree object, and the isBalanced method returns true, the text "Your tree is balanced" is displayed in the output text field to the user. The rest of the buttons work similarly where a particular method from the Binary tree object is called when a particular event is requested by the user to display a message or values to indicate the status of the current tree based on the tree attributes from the input given to create it. 
// handles the functionality wanted by the user based on the button pressed in the frameworks
@Override
public void actionPerformed(ActionEvent e) {
    String input = TREE_INPUT_FIELD.getText(); // variable is equal to the value entered in input field
    BinaryTree tree = new BinaryTree(input); // creates a new binary tree object with the input in its parameters
    try {
        if (e.getSource() == MAKE_TREE_BUTTON) {
            tree.makeTree(input);
            OUTPUT_FIELD.setText("Binary tree successfully created");

        }
    }catch (InvalidTreeSyntax ex) {
        OUTPUT_FIELD.setText("Exception: " + ex.getMessage());
    }

    // Conditional statements check which button option user selected and calls its respective method
    // to perform on tree and providing a message to the output field depending on condition to user.
    if (e.getSource() == IS_BALANCED_BUTTON) {
        if (tree.isBalanced()) {
            OUTPUT_FIELD.setText("Your tree is balanced");
        } else {
            OUTPUT_FIELD.setText("Your tree is not balanced");
        }
    } else if (e.getSource() == IS_FULL_BUTTON) {
        if (tree.isFull()) {
            OUTPUT_FIELD.setText("Your Tree is Full");
        } else {
            OUTPUT_FIELD.setText("Your Tree is not Full");
        }
    } else if (e.getSource() == IS_PROPER_BUTTON){
        if(tree.isProper()){
            OUTPUT_FIELD.setText("Your Tree is Proper");
        } else {
            OUTPUT_FIELD.setText("Your Tree is not proper");
        }
    } else if (e.getSource() == HEIGHT_BUTTON){
        int treeHeight = tree.getHeight();
        OUTPUT_FIELD.setText("You tree height is " + treeHeight);

    } else if (e.getSource() == NODES_BUTTON){
        int nodeCount = tree.countNodes();
        OUTPUT_FIELD.setText("Your node count is " + nodeCount);
    } else if (e.getSource()== INORDER_BUTTON){
        String inorderTraversal = tree.inorderTraversal();
        OUTPUT_FIELD.setText("Inorder Traversal " + inorderTraversal);
    } else {
        OUTPUT_FIELD.setText("You must first create a tree");
    }
}

The Main Method
The main method is the entry point of the application and is used to set up the main window of the program. Within the main method the Main class is created using the new keyword and assigned to the variable name frame. Using the frame object, the setBounds method is called on the frame to set the size and position of the window using the parameters x, y, width, and height values supplied. The setResizable method is called on the frame object to prevent the user from resizing the window by adding false within its parameters. The setVisible method is then called on the frame object to make the window visible to the user when the program is executed. Finally, the setDefaultCloseOperation method is called on the frame object with the parameter EXIT_ON_CLOSE, which closes the window and terminates the program if the user closes the window.
// main method runs program window and sets main window parameters once application is run
public static void main(String[] args) {
    Main frame = new Main();  // instantiates instance of the main class that is extending the JFrame capabilities
    frame.setBounds(200, 200, 700, 200);  //Permanent size of window
    frame.setResizable(false);  // Prevents user from changing size of window setting resizable to false
    frame.setVisible(true);  // Makes window visible to user when program is run
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Terminates program when window is closed
}


Binary Tree Class
The Binary Tree class represents a binary tree and allows for the creation of a binary tree structure where each parent node can have up to 2 child nodes at a time. The binary tree structure is created by passing the input provided by the user on the GUI. Several methods are used by the Main class to perform the specified functionality based on the input and events requested by the user to the tree once the tree is created using the make tree button on the GUI.  
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

The Node Class & Node Class Constructor
The Node class defines a binary tree node, which has the attributes for the data variable that is stored in the node as well a reference to the left and right child nodes of the current position. The attributes of the nodes are private but are accessible and initiated by the class constructor, which takes a char parameter, initializes the data variable with the provided value, and sets left and right references to null.
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

The Make Tree Method
The make tree method takes a string treeInput which is the value entered by the user in the GUI and constructs a binary tree with it. The method initializes a Stack object called nodeStack to keep track of the nodes as they are created and initializes a parent and child node to keep track of the current parent, and child nodes being constructed.
The method iterates through each character in the String treeInput using a for loop and checks whether it is an open parenthesis, a closing parenthesis, or a value that can be used for the node. If the character is an open parenthesis, parent is set equal to child and pushes the current parent node onto the nodeStack, sets parent to null, and updates child to null. If the character is a closing parenthesis, the method pops the top value from the nodeStack and sets it to parent. If the child is not null, the method sets child as either the left or right child of parent, depending on whether parent already has a left child.
Using the conditional statement, the character is checked to see if the value is a letter or digit, to ensure it is a valid value for the node and throws an InvalidTreeSyntax exception If it is not a valid character value. If the value is valid then a new Node object with the given value and assigns it to child. Once all the characters in the input are iterated through the method sets the root node of the binary tree to the current parent node. 

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

The is Balanced Method
The isBalanced() method is a public method that calls the private helper method isBalanced(Node node) to hide the implementation details of the algorithm. The private isBalanced(Node node) method takes a node of the binary tree as input and recursively checks if the tree rooted at this node is balanced or not. If the node is null, it returns true since an empty tree is considered balanced. Otherwise, it calculates the height of the left, and right subtrees using the getHeight() method. It then checks if the absolute difference between the heights is less than or equal to one 1, and if the left and right subtrees are also balanced by recursively calling the isBalanced(Node node) method. If all the conditions are met the method returns true, otherwise it will return false.
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

The is Full Method
The isFull Methods is used to check if a binary tree is a full binary tree or not by verifying if every node in the tree other than the leaf nodes has exactly two children. The public isFull() method is passed the root node of the tree and calls the private helper method isFull(Node node) which returns a Boolean value indicating whether the binary tree is a full binary tree or not. When the public isFull() method calls the private isFull(Node node) which takes the node and passes the current argument. The method isFull(Node node) returns true if the given node is null or if it is a leaf node. If the current node has both left, and right children the method recursively checks if its left and right subtrees are full binary trees using the same isFull () method. If both subtrees are full binary trees, then the method returns true, otherwise returns false.
// recursively calls the isFull private method by passing in the current node and accessing tree is full
public boolean isFull () {
    return isFull(root);
}

// verifies the current node to check if the node is null and returns true then checks the 
// left child node and right child node to see if null and returns true if so
// if the node left and right child are not null recursively recalls the is full method for the right and left node
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

The is Proper Method
The isProper() method is used to check if the binary tree rooted at root is a proper binary tree or not by verifying that every node has either 0 or 2 children. The public isProper() method is passed the root node of the tree and calls the private helper method isProper(Node node) method which returns a Boolean indicating whether the binary tree rooted at node is a proper binary tree or not. If the node is null, the method returns true since an empty tree is a proper binary tree. If the node is a leaf node the method returns true because a leaf node is a proper binary tree. If the node has both a left child and a right child, the method recursively calls itself on both children and returns true only if both children are proper binary trees. If the node only has one child either left or right, the method returns false since a binary tree with only one child is not a proper binary tree.
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

The Get Height Method
the getHeight() methods are used to calculate the height of a binary tree by checking the maximum number of nodes from the root to any leaf node. The public getHeight() method supplies the root node of the tree and uses the private getHeight(Node node) method with the a Node object as a parameter and recursively calculates the height of the binary tree starting from the specified node. The method first checks if the node is null and If so returns -1, since a null node does not count as a value for the height of a tree. If the node is not null, the method recursively calculates the height of the left and right sub-trees respectively by calling the getHeight() method on the left and right child nodes. The method then returns the maximum of the left and right sub-tree heights plus 1, which represents the height of the current node and the entire binary tree where the +1 accounts for the root node of the tree.
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

The Count Nodes Method 
The countNodes method is a recursive method that counts the number of nodes in the binary tree. The private countNodes method is supplied the root node of the binary tree as its argument from the public countNodes method. The private countNodes method first checks to see if the current node is null and if so, the method returns 0, indicating that there are no nodes in the subtree. If the current node is not null, the method recursively counts the number of nodes in the left subtree and the right subtree of the current node by recursively recalling the countNodes method on those subtrees. The method then returns the sum of 1 for the current node and the number of nodes in the left and right subtrees until all nodes in the binary tree have been counted. The method then returns the total number of nodes in the binary tree.
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

The Inorder Traversal Method
public String inorderTraversal() {
    StringBuilder sb = new StringBuilder();
    inorderTraversal(root, sb);
    return sb.toString();
}

private void inorderTraversal (Node node, StringBuilder sb){
    if (node == null)
        return;
    sb.append("(");
    inorderTraversal(node.left, sb);
    sb.append(node.data);
    inorderTraversal(node.right, sb);
    sb.append(")");
}

The inorderTraversal methods are used to perform an inorder traversal of a binary tree by traversing the tree nodes of a tree from left subtree, root, to right subtree in that specific order. The public inorderTraversal() method initializes a StringBuilder object sb, and then calls the inorderTraversal() method with the root node of the binary tree and sb object supplied to its parameter. It then returns the result of calling the sb object using the toString () method.
The private inorderTraversal () method takes two parameters which are the Node object and a StringBuilder object and uses recursion to call itself to perform the traversal of the binary tree. The method first checks if the current node is null and if so simply returns to end the recursion, then the method appends a left parenthesis to sb to indicate the start of a new subtree. Then recursively calls inorderTraversal () with the left child of the current node and sb, which will traverse the left subtree and appends the current node’s data to sb once the left subtree has been traversed. Similarly, the method recursively calls inorderTraversal () with the right child of the current node and sb, which will traverse the right subtree. Once the traversal is complete the method appends a closing parenthesis to sb to denote the end of the subtree and returns, which ends the recursion of the current node.
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


The Invalid Tree Syntax Class 
The Invalid Tree Syntax Class is a custom exception class that extends the built-in RuntimeException class, which has single constructor that takes in a String message as an argument. The super(message) statement calls the constructor of the parent class RuntimeException and passes an error message when an error occurs during the parsing of a tree object where the syntax of the tree is not invalid. If an error occurs, an instance of this exception class is thrown and the error message is passed to the user to show the cause of the exception.
/*
 * Name: Isaac Francisco Martw
 * Class: CMSC 350
 * Purpose: The class is used to handle unchecked exceptions based on the conditions not valid to the tree structure
 * */

package cmsc350projects.project1;

// The InvalidTreeSyntax class has a single constructor that takes in a String message within its parameters.
public class InvalidTreeSyntax extends RuntimeException{


    /*The super(message) statement calls the constructor of the parent class RuntimeException.*/
    public InvalidTreeSyntax(String message){
        super(message);
    }
}
