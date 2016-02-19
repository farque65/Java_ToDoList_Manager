/*	
�File	Name: Lab Assignment 04	� ToDoList Manager Version 2
�Course Name: CST8132 300	
�Lab Section: CST8132 302	
�Student Name:	Fahim Farque
�Date:	Friday	December 4, 2015

 Source: Stanley Pieda (2015) personal communication
�
�*/
package task;

import java.util.Comparator;

public class TaskPriorityComparator implements Comparator<Task>{

	@Override
	public int compare(Task t1, Task t2){
		// need to sort high > medium > low
		// String based comparison is alphabetical so 
		// will not give desired results.
		int priority1 = convertPriorityToInt(t1);
		int priority2 = convertPriorityToInt(t2);
		return Integer.compare(priority1, priority2);
	}
	private int convertPriorityToInt(Task t){
		int priority;
		switch(t.getPriority().toLowerCase()){
		case "high":
			priority = 1;
			break;
		case "medium":
			priority = 2;
			break;
		case "low":
			priority = 3;
			break;
		default: // Future-Course-ToDo: Change Priority from String to an enum
			priority = 3;
			break;
		}
		return priority;
	}
}
