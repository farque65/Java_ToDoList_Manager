/*
 File	Name: Lab Assignment 04	– ToDoList Manager Version 2
 Course Name: CST8132 300	
 Lab Section: CST8132 302	
 Student Name:	Fahim Farque
 Date:	Friday	December 2, 2015
 
 */
package task;

/**
 * @author fahim
 * MathLauncher class
 * - This is a child class of the MathProblem parent class. This class contains the
 *		- main method()
 *		- runs prof.runMenu() from Mathteacher
 */
public class ToDoListLauncher {

	
	/**
	 * The main method
	 *  - This is where the menu options are launched and user entries are chosen 
	 * @param args Command line arguments (not used) 
	 */
	public static void main(String[] args) {
		ToDoListManager todolist = new ToDoListManager();

		todolist.runToDoList();

	}// end of main method

}// end of MathLauncher class
