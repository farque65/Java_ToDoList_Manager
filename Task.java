/*
 File	Name: Lab Assignment 04	– ToDoList Manager Version 2
 Course Name: CST8132 300	
 Lab Section: CST8132 302	
 Student Name:	Fahim Farque
 Date:	Friday	December 4, 2015
 
 */

package task;

/**
 * This class sets each task and defines the conditions for title, priority and
 * iscomplete
 * 
 * @author fahim farque
 * @version 1.0
 * @since 1.8
 */
public class Task {

	// data-fields
	private String title;
	private String priority;
	private boolean isComplete;

	/**
	 * This constructor takes no parameters and set the title and priority
	 * default values to No title and priority.
	 */
	public Task() {
		this.title = "No title";
		this.priority = "No priority";
	}

	/**
	 * Task Constructor takes three params and throws ValidationException
	 * 
	 * @param title
	 *            is set by setTitle() method
	 * @param priority
	 *            is set by setPriority() method
	 * @param isComplete
	 *            set by setIsComplete() method
	 * @throws ValidationException
	 *             if conventions of setting title, setting priority and setting
	 *             completion
	 */
	public Task(String title, String priority, boolean isComplete) throws ValidationException {

		setTitle(title);

		setPriority(priority);

		setIsComplete(isComplete);

	}// end of constructor

	/**
	 * Task constructor with takes two params
	 * 
	 * @param title
	 *            is set by setTitle() method
	 * @param priority
	 *            is set by setPriority() method
	 * @throws ValidationException
	 *             if conventions of setting title, setting priority and setting
	 *             completion
	 */
	public Task(String title, String priority) throws ValidationException {

		setTitle(title);

		setPriority(priority);

	}// end of constructor

	// getter and setter of Title

	/**
	 * 
	 * @return the string object of title set in setTitle.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            sets the title
	 * @throws ValidationException
	 *             defines under what conditions to throw the
	 *             ValidationException when setting the priority string object.
	 */
	public void setTitle(String title) throws ValidationException {

		if (title == null)
			throw new ValidationException("Title cannot be null.");

		if (title.length() == 0)
			throw new ValidationException("Title cannot be empty.");

		if (title.length() > 25)
			throw new ValidationException("Title cannot exceed 20 characters.");

		if (title != title.trim())
			throw new ValidationException("Title cannot be empty.");

		if (title.contains("\t"))
			throw new ValidationException("Title cannot contain tab spaces.");

		this.title = title.trim();

	}

	// getter and setter of Priority

	/**
	 * 
	 * @return the string object of priority set in setPriority.
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * 
	 * @param priority
	 *            takes one String parameter to set the priority
	 * @throws ValidationException
	 *             defines under what conditions to throw the
	 *             ValidationException when setting the priority string object.
	 */
	public void setPriority(String priority) throws ValidationException {

		if (priority == null)
			throw new ValidationException("Priority cannot be null.");

		if (priority.length() == 0)
			throw new ValidationException("Priority cannot be empty.");

		if (priority != priority.trim())
			throw new ValidationException("Priority cannot be empty.");

		if (priority.trim().toLowerCase().equals("high") == false
				&& priority.trim().toLowerCase().equals("medium") == false
				&& priority.trim().toLowerCase().equals("low") == false)

			throw new ValidationException("Priority is not high, medium or low.");

		this.priority = priority.trim();
	}

	// getter and setter isComplete

	/**
	 * 
	 * @return the boolean object of isComplete set in setIsComplete.
	 */
	public boolean getIsComplete() {
		return isComplete;
	}

	/**
	 * 
	 * @param isComplete
	 *            takes one boolean parameter to set IsComplete.
	 */
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	/**
	 * 
	 * @return a string that contains the values of title, priority and is
	 *         complete/not complete based on boolean value of isComplete.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		String isCompleteValue = null;

		if (isComplete == true) {

			isCompleteValue = "is complete";
		} else if (isComplete == false) {

			isCompleteValue = "is not complete";
		}

		return builder.append(title).append(" ").append("(" + priority + ")").append(" ").append(isCompleteValue)
				.toString();

	}// end of toString

	/**
	 * 
	 * @return formatted string of title, priority and iscomplete with tab
	 *         spaces
	 */
	public String createTabRecord() {

		String expected = String.format("%s\t%s\t%s", title, priority, Boolean.toString(isComplete));

		return expected;

	}// end of createTabRecord

}// end of Task class
