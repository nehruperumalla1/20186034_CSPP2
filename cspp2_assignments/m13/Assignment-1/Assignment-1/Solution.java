import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Nehru Perumalla.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size;

    public Set() {
    	set = new int[10];
    	size = 0;
    }

    public boolean contains(int item) {
    	return indexOf(item) != -1;
    }

    public String toString() {
    	String str = "{";
    	if(size > 0) {
    		for (int i = 0; i < size - 1; i++) {
    			str += set[i] + ", ";
    		}
    		str += set[size - 1];
    	}
    	str += "}";
    	return str;
    }

    public void add(int item) {
    	if (!(contains(item))) {
    		if (size >= set.length) {
    			resize();
    		}
    		set[size] = item;
    		size += 1;
    	}
    }

    public int size() {
    	return size;
    }

    public void add(int[] items) {
    	if (items.length + size >= set.length) {
    		resize();
    	}
    	for (int i = 0; i < items.length; i++) {
    		add(items[i]);
    	}
    }
    public int get(int index) {
    	if (index < size && index >= 0) {
    		return set[index];
    	}
    	return -1;
    }

    public Set intersection(Set sett) {
    	int count = 0;
    	Set resultset = new Set();
    	if (this.size() != 0 && sett.size() != 0) {
	    	for (int i = 0; i < size; i++) {
	    		count = 0;
	    		for (int j = 0; j < sett.size(); j++) {
	    			if (sett.get(j) == set[i]) {
	    				count += 1;
	    			}
	    		}
	    		if (count >= 1) {
	    			resultset.add(get(i));
	    		}
	    	}
    	}
    	return resultset;
    }

    public Set retainAll(int[] items) {
    	Set retainset = new Set();
    	retainset.add(items);
    	return intersection(retainset);
    }

    public int[][] cartesianProduct(Set set1) {
    	//System.out.println(set1.size() + " * " + size + " = " + set1.size()*size);
    	int[][] cartesian = new int[set1.size()*size][2];
    	if (set1.size() > 0 && size > 0) {
    		for (int i = 0; i < set1.size()*size; i++) {
    			for (int j = 0; j < 2; i++) {
    				System.out.println(i);
    				cartesian[i][0] = 1;
    				cartesian[i][1] = 0;
    			}
    		}
    		return cartesian;
    	}
    	return null;
    }

    public int indexOf(int item) {
    	for (int i = 0; i < size; i++) {
    		if (set[i] == item) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void resize() {
    	set = Arrays.copyOf(set, set.length * 2);
    }




}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
