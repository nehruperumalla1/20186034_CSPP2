import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment.
  */
class Task {
    /**
     * Name of the Task.
     */
    private String task;
    /**
     * Name of the Task Holder.
     */
    private String name;
    /**
     * Duration of Task in Minutes.
     */
    private int duration;
    /**
     * Task Importance.
     */
    private boolean important;
    /**
     * Task Urgency.
     */
    private boolean urgent;
    /**
     * Status of task.
     */
    private String status;

    /**
     * Constructs the object.
     */
    Task() {
        //Nothiing.
    }

    /**
     * Constructs the object.
     *
     * @param      title       The title
     * @param      assignedTo  The assigned to
     * @param      time        The time
     * @param      important1  The important 1
     * @param      urgent1     The urgent 1
     * @param      status1     The status 1
     * @throws
     */
    Task(final String title, final String assignedTo,
        final int time, final boolean important1,
        final boolean urgent1, final String status1) throws Exception {
        if (title.length() == 0) {
            throw new Exception("Title not provided");
        }
        if (time < 0) {
            throw new Exception("Invalid timeToComplete " + time);
        }

        if (!(status1.equals("todo") || status1.equals("done"))) {
            throw new Exception("Invalid status " + status1);
        }
        task = title;
        name = assignedTo;
        duration = time;
        important = important1;
        urgent = urgent1;
        status = status1;
    }

    /**
     * Gets the title.
     *
     * @return     The title.
     */
    public String getTitle() {
        return this.task;
    }

    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the time.
     *
     * @return     The time.
     */
    public int getTime() {
        return this.duration;
    }

    /**
     * Gets the imp.
     *
     * @return     The imp.
     */
    public boolean getImp() {
        return this.important;
    }

    /**
     * Gets the urg.
     *
     * @return     The urg.
     */
    public boolean getUrg() {
        return this.urgent;
    }

    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str += task + ", " + name + ", " + duration + ", ";
        if (getImp()) {
            str += "Important, ";
        } else {
            str += "Not Important, ";
        }

        if (getUrg()) {
            str += "Urgent, ";
        } else {
            str += "Not Urgent, ";
        }

        str += getStatus();
        return str;
    }
}

/**
 * Class for todoist.
 */
class Todoist {
    /**
     * Tasks List.
     */
    private List<Task> tasks;
    /**
     * Constructs the object.
     */
    Todoist() {
        tasks = new List<Task>();
    }

    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        tasks.add(task);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
        return str;
    }
    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(final String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (name.equals(tasks.get(i).getName())) {
                if (tasks.get(i).getStatus().equals("todo")
                    && (tasks.get(i).getImp() && !tasks.get(i).getUrg())) {
                    return tasks.get(i);
                }
            }
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (name.equals(tasks.get(i).getName())) {
                if (tasks.get(i).getStatus().equals("todo")
                    && (tasks.get(i).getImp() && tasks.get(i).getUrg())) {
                    return tasks.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Gets the next task.
     *
     * @param      name   The name
     * @param      count  The count
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String name, final int count) {
        Task[] ctasks = new Task[count];
        int c = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (name.equals(tasks.get(i).getName())
                && tasks.get(i).getStatus().equals("todo")) {
                ctasks[c] = (tasks.get(i));
                c += 1;
                if (c == count) {
                    break;
                }
            }
        }
        return ctasks;
    }

    /**
     * Total Time for Completion.
     *
     * @return     { Returns Integer }
     */
    public int totalTime4Completion() {
        int time = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getStatus().equals("todo")) {
                time += tasks.get(i).getTime();
            }
        }
        return time;
    }
}
/**
 * Class for todoist main.
 */
class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[2 + 1]);
        boolean important = tokens[2 + 2].equals("y");
        boolean urgent = tokens[2 + 2 + 1].equals("y");
        String status = tokens[2 + 2 + 2];

        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
