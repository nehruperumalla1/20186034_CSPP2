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
    	int n = 1;
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
                n = loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (n > 0) {
                    startQuiz(s, q, Integer.parseInt(tokens[1]));
                }
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (n > 0) {
                	displayScore(q);
            	}
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
    public static int loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount > 0) {
            int size = 0;
            while (size < questionCount) {
                String line = s.nextLine();
                String[] tokens = line.split(":");
                if (tokens.length == 5 && tokens[0].length() > 0) {
                    String[] choices = tokens[1].split(",");
                    if(choices.length > 1) {
	                    if (Integer.parseInt(tokens[2]) > 0 && Integer.parseInt(tokens[2]) <= choices.length) {
	                    	if (Integer.parseInt(tokens[3]) > 0) {
			                    quiz.add(new Quiz(tokens[0], choices, Integer.parseInt(tokens[2]),
			                        Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
			                    size += 1;
			                } else {
			                	System.out.println("Invalid max marks for " + tokens[0]);
			                	return -1;
			                }
	                	} else {
	                		System.out.println("Error! Correct answer choice number is out of range for " + tokens[0]);
	                		return -1;
	                	}
                	} else {
                		System.out.println(tokens[0] + " does not have enough answer choices");
                		return -1;
                	}
                } else  {
                    System.out.println("Error! Malformed question");
                    return -1;
                }
            }
            System.out.println(questionCount + " are added to the quiz");
        }else {
            System.out.println("Quiz does not have questions");
            return -1;
        }
        return 1;
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
        quiz.report();

    }
}

class Quiz {

    private String quest;
    private int answer;
    private int marks;
    private int penalty;
    Quiz[] quiz = new Quiz[10];
    int size = 0;
    int answersize = 0;
    private String[] uanswers = new String[1];
    private String[] options = new String[4];
    private int osize;

    Quiz() {
        //Empty.
    }

    Quiz(String question, String[] choices, int correct, int mark, int penal) {

        this.quest = question;
        this.options = choices;
        this.answer = correct;
        this.marks = mark;
        this.penalty = penal;
        this.osize = choices.length;
    }

    private int osize() {
    	return osize;
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
        quiz[size] = quizz;
        size += 1;
    }

    public void questions(Scanner s, Quiz quizz, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(quiz[i].getQuestion() + "(" + quiz[i].getMarks() + ")");
            for (int j = 0; j < quiz[i].osize() - 1; j++) {
                System.out.print(quiz[i].getOptions()[j] + "\t");
            }
            System.out.println(quiz[i].getOptions()[quiz[i].osize() - 1]);
            System.out.println();
            uanswers[answersize] = s.nextLine();
            answersize += 1;
            resize();
        }
    }

    public int answer(char c) {
    	String[] str = {"a", "b", "c", "d"};
    	for (int i = 0; i < str.length; i++) {
    		if (Character.toString(c).equals(str[i])) {
    			return i+1;
    		}

    	}
    	return 0;
    }

    public void report() {
        int correct = 0;
        int wrong = 0;
        boolean ans = true;

        for (int i = 0; i < size; i++) {
            ans = true;
            System.out.println(quiz[i].getQuestion());
            int x = answer(uanswers[i].charAt(7));
            if(Character.getNumericValue(uanswers[i].charAt(7)) == (quiz[i].getAnswer())){
            System.out.println(" " + "Correct Answer! - Marks Awarded: " + quiz[i].getMarks());
            correct += quiz[i].getMarks();
            ans = false;
            } if(x == (quiz[i].getAnswer())) {
            	System.out.println(" " + "Correct Answer! - Marks Awarded: " + quiz[i].getMarks());
            	correct += quiz[i].getMarks();
            	ans = false;
            }
            if (ans) {
                System.out.println(" "+ "Wrong Answer! - Penalty: " + quiz[i].getPenalty());
                wrong -= quiz[i].getPenalty();
            }  
        }
        System.out.println("Total Score: " + (correct - wrong));
    }
}