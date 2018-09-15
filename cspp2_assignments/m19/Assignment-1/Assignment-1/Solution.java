import java.util.Scanner;
import java.util.Arrays;

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int size = 0;
        while (size < questionCount) {
            String line = s.nextLine();
            String[] tokens = line.split(":");
            String[] choices = tokens[1].split(",");
            Quiz question = new Quiz(tokens[0], choices, Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
            quiz.add(question);
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        quiz.questions(s, quiz, answerCount);
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report


    }
}

class Quiz {

    private String quest;
    private String[] options;
    private int answer;
    private int marks;
    private int penalty;
    private Quiz[] quiz;
    private int size;
    private String[] uanswers;

    Quiz() {
        //Empty.
    }

    Quiz(String question, String[] choices, int correct, int mark, int penal) {

        this.quest = question;
        this.options = choices;
        this.answer = correct;
        this.marks = marks;
        this.penalty = penal;
        this.quiz = new Quiz[1];
        this.uanswers = new String[1];
        this.size = 0;
    }

    public String getQuestion() {
        return this.quest;
    }

    public String[] getOptions() {
        return this.options;
    }

    public int getAnswer() {
        return this.answer;
    }

    public int getMarks() {
        return this.marks;
    }

    public int getPenalty() {
        return this.penalty;
    }

    public void resize() {
        quiz = Arrays.copyOf(quiz, 2 * quiz.length);
        uanswers = Arrays.copyOf(uanswers, 2 * uanswers.length);
    }

    public void add(Quiz quizz) {
        System.out.println(size);
        if (size >= quiz.length) {
            resize();
        }
        quiz[size] = quizz;
        size += 1;
        System.out.println(size);
    }

    public void questions(Scanner s, Quiz quizz, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(quiz[i].getQuestion() + "(" + quiz[i].getMarks() + ")");
            for (int j = 0; j < options.length - 1; j++) {
                System.out.print(options[j] + "    ");
            }
            System.out.println(options[options.length - 1]);
            uanswers[i] = s.nextLine();
        }
    }

    public void report() {
        for (int i = 0; i < size; i++) {
            System.out.println("question text " + i);
            if(uanswers[i].equals(quiz[i].getAnswer())){
                System.out.println("Correct Answer! - Marks Awarded: " + quiz[i].getMarks());
            } else {
                System.out.println("Wrong Answer! - Penalty: " + quiz[i].getPenalty());
            }
            
        }
        System.out.println("Total Score: ");
    }
}