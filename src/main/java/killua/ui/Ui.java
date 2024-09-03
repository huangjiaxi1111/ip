package killua.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import killua.task.Task;
import killua.util.TaskList;

/**
 * Represents the user interface of the Killua task manager.
 * It handles the display of messages and reading of user input.
 */
public class Ui {

    private static final String LINE = "______________________________________________________________________________";
    private final Scanner in;

    /**
     * Constructs a Ui instance with default input and output streams.
     */
    public Ui() {
        this(System.in, System.out);
    }

    /**
     * Constructs a Ui instance with specified input and output streams.
     *
     * @param in The input stream to read user input from.
     * @param out The output stream to print messages to.
     */
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
    }

    /**
     * Displays a welcome message and a list of available commands.
     */
    public void showWelcomeMessage() {
        printLine();
        System.out.println("""
        Welcome to Killua Task Manager!
        Here are some commands you can use:
            bye - Exit the application
            list - List all tasks
            mark <task number> - Mark a task as done
            unmark <task number> - Mark a task as not done yet
            delete <task number> - Delete a task
            todo <description> - Add a new todo task
            deadline <description> /by <yyyy-mm-dd> OR
            deadline <description> /by <yyyy-mm-dd hh:mm> - Add a new deadline task
            event <description> /from <yyyy-mm-dd> /to <yyyy-mm-dd> OR
            event <description> /from <yyyy-mm-dd hh:mm> /to <yyyy-mm-dd hh:mm> - Add a new event task""");
        printLine();
    }

    /**
     * Prints a separator line for formatting purposes.
     */
    public void printLine() {
        System.out.println(LINE);
    }

    /**
     * Displays an error message indicating that tasks could not be loaded.
     */
    public void showLoadingError() {
        printLine();
        System.out.println("Error loading tasks.");
        printLine();
    }

    /**
     * Displays a message indicating that a task has been added to the list.
     *
     * @param task The task that was added.
     * @param taskCount The total number of tasks in the list after the addition.
     */
    public void showTaskAdded(Task task, int taskCount) {
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        printLine();
    }

    /**
     * Displays a message indicating that a task has been deleted from the list.
     *
     * @param task The task that was deleted.
     */
    public void showTaskDeleted(Task task) {
        printLine();
        System.out.println("OK, I've deleted this task:");
        System.out.println("  " + task);
        printLine();
    }

    /**
     * Displays a farewell message when the application is exiting.
     */
    public void showBye() {
        printLine();
        System.out.println("Bye!");
        printLine();
    }

    /**
     * Displays the current list of tasks.
     *
     * @param tasks The task list to be displayed.
     */
    public void showTaskList(TaskList tasks) {
        printLine();
        if (tasks.isEmpty()) {
            System.out.println("Your task list is empty.");
        } else {
            System.out.println("Here are the tasks in your list:");
            tasks.printTasks();
        }
        printLine();
    }

    /**
     * Displays a message indicating that a task has been marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void showTaskMarked(Task task) {
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        printLine();
    }

    /**
     * Displays a message indicating that a task has been marked as not done yet.
     *
     * @param task The task that was marked as not done yet.
     */
    public void showTaskUnmarked(Task task) {
        printLine();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
        printLine();
    }

    /**
     * Displays tasks that are scheduled for a specific date.
     *
     * @param tasks The task list containing the tasks to be displayed.
     * @param date The date for which tasks are to be displayed.
     */
    public void showTasksOnDate(TaskList tasks, LocalDate date) {
        printLine();
        System.out.println("Tasks on " + date + ":");

        boolean hasTasks = false;
        for (Task task : tasks.getTasksOnDate(date).getTasks()) {
            System.out.println("  " + task);
            hasTasks = true;
        }

        if (!hasTasks) {
            System.out.println("No tasks found for this date.");
        }

        printLine();
    }

    /**
     * Displays an error message.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }

    /**
     * Reads and returns a command from user input.
     *
     * @return The command entered by the user.
     */
    public String readCommand() {
        return in.nextLine().trim();
    }

    /**
     * Displays the tasks that match a specified keyword.
     * Prints a message to indicate whether any matching tasks were found.
     * If matching tasks are found, prints each matching task to the console.
     * Otherwise, prints a message indicating that no matching tasks were found.
     *
     * @param tasks The TaskList containing the tasks to be displayed.
     */
    public void showMatchedTask(TaskList tasks) {
        printLine();
        if (tasks.isEmpty()) {
            System.out.println("No matching task in your list!");
        } else {
            System.out.println("Here are the Matching tasks in your list:");
            tasks.printTasks();
        }
        printLine();
    }
}
