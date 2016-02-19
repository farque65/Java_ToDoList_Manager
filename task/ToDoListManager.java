/*
 File	Name: Lab Assignment 04	– ToDoList Manager Version 2
 Course Name: CST8132 300	
 Lab Section: CST8132 302	
 Student Name:	Fahim Farque
 Date:	Friday	December 4, 2015
 Author: Stanley Pieda (2015) Personal Communication 
 Updated By: Fahim Farque
                                                    
 */
package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import task.TaskIsCompleteComparator;
import task.TaskPriorityComparator;
import task.TaskTitleComparator;

/**
 * This class defines how the user interacts with the todo list manager. The
 * menu and what the user can do in the to do list manager is defined here.
 * 
 * @author fahim farque
 * @version 1.0
 * @since 1.8
 */
public class ToDoListManager {

	/**
	 * ADD_TASK = {@value}
	 */
	private static final int ADD_TASK = 1;

	/**
	 * TOGGLE_TASK_COMPLETE = {@value}
	 */
	private static final int TOGGLE_TASK_COMPLETE = 2;

	/**
	 * REMOVE_TASK = {@value}
	 */
	private static final int REMOVE_TASK = 3;

	/**
	 * VIEW_TASKS = {@value}
	 */
	private static final int VIEW_TASKS = 4;

	/**
	 * SAVE_TASKS = {@value}
	 */
	private static final int SAVE_TASKS = 5;

	/**
	 * LOAD_TASKS = {@value}
	 */
	private static final int LOAD_TASKS = 6;

	/**
	 * SORT_BY_TITLE = {@value}
	 */
	private static final int SORT_BY_TITLE = 7;

	/**
	 * SORT_BY_PRIORITY = {@value}
	 */
	private static final int SORT_BY_PRIORITY = 8;

	/**
	 * SORT_BY_ISCOMPLETE = {@value}
	 */
	private static final int SORT_BY_ISCOMPLETE = 9;

	/**
	 * EXIT = {@value}
	 */
	private static final int EXIT = 10;
	private ArrayList<Task> tasks = null;
	private Scanner input = null;

	/**
	 * Default constructor, initializes tasks and initializes input
	 */
	public ToDoListManager() {
		tasks = new ArrayList<Task>();
		input = new Scanner(System.in);
	} // end Constructor

	/**
	 * runToDoList method - Here the method runs through the menu options
	 * enabling the the user to choose the action they want to do.
	 * 
	 * Source: Stanley Pieda (2015) personal communication (alterations made to
	 * original)
	 * 
	 */
	public void runToDoList() {
		int option = -1;
		while (option != EXIT) {
			try {
				showMenu();
				option = input.nextInt();
				input.nextLine();
				switch (option) {
				case ADD_TASK:
					addTask();
					break;
				case TOGGLE_TASK_COMPLETE:
					toggleTaskComplete();
					break;
				case REMOVE_TASK:
					removeTask();
					break;
				case VIEW_TASKS:
					viewTasks();
					break;
				case SAVE_TASKS:
					saveTasks();
					break;
				case LOAD_TASKS:
					loadTasks();
					break;
				case SORT_BY_TITLE:
					sortByTitle();
					break;
				case SORT_BY_PRIORITY:
					sortByPriority();
					break;
				case SORT_BY_ISCOMPLETE:
					sortByIsComplete();
					break;
				case EXIT:
					System.out.println("program will exit");
					break;
				default:
					System.out.println("unrecognized command");
					break;
				} // end switch
			} // end try
			catch (InputMismatchException e) {
				System.err.println("Please enter integer numbers for menu selection");
				input.nextLine(); // remove bad data from stream
			} // end catch
		} // end while
	} // end method

	/**
	 * This prints to screen all the menu options
	 * 
	 * Source: Stanley Pieda (2015) personal communication (alterations made to
	 * original)
	 * 
	 */
	private void showMenu() {
		System.out.println(ADD_TASK + " to add a task");
		System.out.println(TOGGLE_TASK_COMPLETE + " to toggle a task's is completed");
		System.out.println(REMOVE_TASK + " to remove a task");
		System.out.println(VIEW_TASKS + " to view all tasks");
		System.out.println(SAVE_TASKS + " to save all tasks");
		System.out.println(LOAD_TASKS + " to load all tasks");
		System.out.println(SORT_BY_TITLE + " to sort by task title");
		System.out.println(SORT_BY_PRIORITY + " to sort by task priority");
		System.out.println(SORT_BY_ISCOMPLETE + " to sort tasks by iscomplete");
		System.out.println(EXIT + " to exit program");
	} // end method

	/**
	 * addTask method - Here the method allows the user to add a task on the to
	 * do list. The method has a try catch block that catches ValidException.
	 */
	private void addTask() {
		try {
			System.out.println("Please enter task title");
			System.out.println("(Title cannot be empty, max 25 characters)");
			String title = input.nextLine();
			System.out.println("Please enter task priority (high, medium, low)");
			String priority = input.nextLine();
			Task task = new Task(title, priority);
			tasks.add(task);
		} catch (ValidationException e) {
			System.err.println("There was a problem adding a task:");
			System.err.println(e.getMessage());
			System.err.println("Please try again.");
		} // end catch
	} // end method

	/**
	 * toggleTaskComplete method - Here the method toggles between complete and
	 * not complete of the task index the user enters. This method has a try
	 * catch block that catches if the user enters an index out of bounds of the
	 * array. The method also catches input mismatch if the user does not enter
	 * an int value for the index value.
	 * 
	 * Source: Stanley Pieda (2015) personal communication
	 * 
	 */
	private void toggleTaskComplete() {
		if (tasks.isEmpty()) {
			System.out.println("Nothing to toggle, no tasks");
		} else {
			try {
				System.out.println("Please enter index number of task to toggle complete / incomplete");
				int index = input.nextInt();
				input.nextLine();
				Task task = tasks.get(index);
				task.setIsComplete(!task.getIsComplete());
			} catch (InputMismatchException e) {
				System.err.println("Could not toggle task complete");
				System.err.println("Please enter only integers for index");
				System.err.println("Please try again");
				input.nextLine(); // remove bad data from stream
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Could not toggle task complete");
				System.err.println("Please enter a valid index");
				System.err.printf("%d to %d%n", 0, tasks.size() - 1);
				// if we are here, there is no bad data in the stream
			} // end catch
		} // end if
	} // end method

	/**
	 * removeTask method - This method removes the to do list task based on the
	 * index number the user enters. This method has a try catch block that
	 * catches if the user enters an index out of bounds of the array. The
	 * method also catches input mismatch if the user does not enter an int
	 * value for the index value.
	 * 
	 * Source: Stanley Pieda (2015) personal communication
	 * 
	 */
	private void removeTask() {
		if (tasks.isEmpty()) {
			System.out.println("Nothing to remove, no tasks");
		} else {
			try {
				System.out.println("Please enter index number of task to remove");
				int index = input.nextInt();
				input.nextLine();
				tasks.remove(index);
			} catch (InputMismatchException e) {
				System.err.println("Could not remove task");
				System.err.println("Please enter only integers for index");
				System.err.println("Please try again");
				input.nextLine(); // remove bad data from stream
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Could not remove task");
				System.err.println("Please enter a valid index");
				System.err.printf("%d to %d%n", 0, tasks.size() - 1);
				// if we are here there is no bad data in the stream
			} // end catch
		} // end if
	} // end method

	/**
	 * viewTask method - This method shows all the task in the to do list
	 * organized by index number.
	 * 
	 * Source: Stanley Pieda (2015) personal communication
	 * 
	 */
	private void viewTasks() {
		if (tasks.isEmpty()) {
			System.out.println("Nothing to show, no tasks");
		} else {
			for (int index = 0; index < tasks.size(); index++) {
				System.out.printf("index: %d %s%n", index, tasks.get(index).toString());
			} // end for
		} // end else
	} // end method

	/**
	 * Saves all the tasks added by user and after saving displays the amount of
	 * records saved
	 */
	private void saveTasks() {
		Formatter output = null;
		if (tasks.isEmpty()) {
			System.out.println("Nothing to show, no tasks");
		} else {

			try {

				output = new Formatter(new BufferedWriter(new FileWriter(new File("tasks.txt"))));

				for (int i = 0; i < tasks.size(); i++) {
					if (i < tasks.size()) {
						output.format("%s%n", tasks.get(i).createTabRecord());
					} else if (i == tasks.size() - 1) {
						output.format("%s", tasks.get(i).createTabRecord());
					} else {

					}

				} // end of for loop

				System.out.println("\nSaved " + tasks.size() + " records to file tasks.txt");

			} catch (IOException ex) {
				System.err.println("Problem with file output operation: " + ex.getMessage());
			} finally {
				if (output != null) {
					output.flush();
					output.close();
				}
			}
		} // end else
	} // end method

	/**
	 * This first clears all the tasks in the tasks arraylist and then loads all
	 * the tasks from Tasks.txt. This method catches FileNotFoundException,
	 * IOException and ValidationException
	 */
	private void loadTasks() {

		try (Scanner input = new Scanner(new FileReader(new File("tasks.txt")))) {
			tasks.clear();

			while (input.hasNext()) {
				String line = input.nextLine();
				String[] parts = line.split("\t");

				Task tisk = new Task(parts[0], parts[1], Boolean.parseBoolean(parts[2]));

				tasks.add(tisk);

			} // end of while loop

			System.out.println("\nLoaded " + tasks.size() + " records to file tasks.txt");

		} catch (FileNotFoundException ex) {
			System.err.println("File not found" + ex.getMessage());

		} catch (IOException ex) {
			System.err.println("Problem with file input operation: " + ex.getMessage());
		} catch (ValidationException e) {
			System.err.println("There was a problem loading tasks:");
			System.err.println(e.getMessage());
			System.err.println("Please try again.");
		}

	} // end method

	/**
	 * Sorts all the tasks in tasks array list by title
	 */
	private void sortByTitle() {
		if (tasks.isEmpty()) {
			System.out.println("Nothing to show, no tasks");
		} else {

			Collections.sort(tasks, new TaskTitleComparator());

			System.out.println("Sorting by title completed");
		} // end else
	} // end of sortByTitle

	/**
	 * Sorts all the tasks in tasks array list by priority
	 */
	private void sortByPriority() {
		if (tasks.isEmpty()) {
			System.out.println("Nothing to show, no tasks");
		} else {

			Collections.sort(tasks, new TaskPriorityComparator());

			System.out.println("Sorting by priority completed");
		} // end else
	} // end of sortByPriority

	/**
	 * Sorts all the tasks in tasks array list by completeness
	 */
	private void sortByIsComplete() {
		if (tasks.isEmpty()) {
			System.out.println("Nothing to show, no tasks");
		} else {

			Collections.sort(tasks, new TaskIsCompleteComparator());

			System.out.println("Sorting by is-complete completed");
		} // end else
	} // end of sortByPriority

} // end class
