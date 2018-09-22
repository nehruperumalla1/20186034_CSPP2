import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
    private String task;
    private String name;
    private int duration;
    private boolean important;
    private boolean urgent;
    private String status;
    Task() {
        //Nothiing.
    }

    Task(String title, String assignedTo,
        int time, boolean important1,
        boolean urgent1, String status1) throws Exception {
        if (title.length() == 0) {
            throw new Exception("Title not Provided");
        }
        if (time < 0) {
            throw new Exception("Ivalid timeToComplete " + time);
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

    public String getTitle() {
        return this.task;
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.duration;
    }

    public boolean getImp() {
        return this.important;
    }

    public boolean getUrg() {
        return this.urgent;
    }

    public String getStatus() {
        return this.status;
    }

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

class Todoist {
    List<Task> tasks;
    Todoist() {
        tasks = new List<Task>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
        return str;
    }

    public Task getNextTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (name.equals(tasks.get(i).getName())) {
                if (tasks.get(i).getStatus().equals("todo")
                    && (tasks.get(i).getImp() && !tasks.get(i).getUrg())) {
                    return tasks.get(i);
                } else if (tasks.get(i).getStatus().equals("todo")
                    && (tasks.get(i).getImp() && tasks.get(i).getUrg())) {
                    return tasks.get(i);
                }
            }
        }
        return null;
    }

    public Task[] getNextTask(String name, int count) {
        Task[] ctasks = new Task[count];
        int c = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (name.equals(tasks.get(i).getName())) {
                ctasks[c] = (tasks.get(i));
                c += 1;
                if (c == count) {
                    break;
                }
            }
        }
        return ctasks;
    }

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
public class TodoistMain {

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
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];

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
