/*
 File	Name: Lab Assignment 04	– ToDoList Manager Version 2
 Course Name: CST8132 300	
 Lab Section: CST8132 302	
 Student Name:	Fahim Farque
 Date:	Friday	December 4, 2015

 */
package task;

/**
 * This class represents the custom validation for the tasks class
 * @author fahim farque
 * @version 1.0
 * @since 1.8
 */
public class ValidationException extends Exception{
	
	/**
	 * 
	 *  - returns The message "There was a problem when validating data"
	 */
	public ValidationException(){
		super("There was a problem when validating data");
	} // end constructor
	
	/**
	 * 
	 * @param message entered into the parameter
	 */
	public ValidationException(String message){
		super(message);
	} // end constructor
	
	/**
	 * 
	 * @param message explains the throwable
	 * @param throwable exception found in the code
	 */
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	} // end constructor
	
	/**
	 * 
	 * @param throwable exception found in the code
	 */
	public ValidationException(Throwable throwable){
		super(throwable);
	} // end constructor
} // end class
