/*
 File	Name: Lab Assignment 04	– ToDoList Manager Version 2
 Course Name: CST8132 300	
 Lab Section: CST8132 302	
 Student Name:	Fahim Farque
 Date:	Friday	December 4, 2015

 Source: Stanley Pieda (2015) personal communication
 
 */
package task;

import java.util.Comparator;


public class TaskTitleComparator implements Comparator<Task>{
	
	
	@Override
	public int compare(Task t1, Task t2){
		return t1.getTitle().compareTo(t2.getTitle());
	}
}
