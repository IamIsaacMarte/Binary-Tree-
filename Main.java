/*
* Name: Isaac Francisco Marte
* Class: CMSC 350
* Purpose: The main class creates a GUI that allows a user to create a binary tree based on input provided
  and allows them to then perform several operations on the tree itself.
* */


package cmsc350projects.project1;

// imports modules used to create gui framework, and listening/handling events
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class extends the JFrame modules and implements to use the action listeners
public class Main extends JFrame implements ActionListener{

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

    // North panel method sets input label and text field in north section of border layout
    private JPanel northPanel() {
        JPanel northPanel = new JPanel(); // initiates a new panel for north position
        northPanel.add(TREE_INPUT_LABEL); // add the input label
        northPanel.add(TREE_INPUT_FIELD); // add the text field for the input entered by user
        return northPanel;  // return the new north panel with associated attributes in north of border layout
    }

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

    // South panel method displays the output label and text field in south of border layout
    private JPanel southPanel(){
        JPanel southPanel = new JPanel();
        southPanel.add(OUTPUT_TREE_LABEL);
        southPanel.add(OUTPUT_FIELD);
        return southPanel;
    }


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

    // main method runs program window and sets main window parameters once application is run
    public static void main(String[] args) {
        Main frame = new Main();  // instantiates instance of the main class that is extending the JFrame capabilities
        frame.setBounds(200, 200, 700, 200);  //Permanent size of window
        frame.setResizable(false);  // Prevents user from changing size of window setting resizable to false
        frame.setVisible(true);  // Makes window visible to user when program is run
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Terminates program when window is closed
    }

}
