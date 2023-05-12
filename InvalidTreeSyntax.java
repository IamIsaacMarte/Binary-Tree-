/*
 * Name: Isaac Francisco Marte
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
