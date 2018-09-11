import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;

public class StackQueue {
	private int size;
	private int[] stack;
	private int length;
	public StackQueue() {
		size = 0;
		stack = new int[10];
		length = stack.length;
	}
	public void add(int item) {
		stack[size] = item;
		size += 1;
	}

	public void remove() {
		size -= 1;
	}

	public int peek() {
		return stack[size - 1]; 
	}
	public int size() {
		return size;
	}

	public String toString() {
		String str = "[";
		if (size > 0) {
			for (int i = 0; i < size - 1; i++) {
				str += stack[i] + ", ";
			}
			str += stack[size - 1];
		}
		str += "]";
		return str;
	}

	public void addQ(int item) {
		if(size > 0) {
			for (int i = size - 1; i >= 0; i--) {
				stack[i+1] = stack[i];
			}
			stack[0] = item;
			size += 1;
		} else {
		stack[size] = item;
		size += 1;
	}
	}

	public static void main(String[] args) {
		StackQueue sq = new StackQueue();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int m = 0;
		String std = sc.nextLine();
		if (std.equals("Stack")) {
			while (m < n) {
				String line = sc.nextLine();
				String[] s = line.split(" ");
				m++;
				switch (s[0]) {
					case "add":
					sq.add(Integer.parseInt(s[1]));
					break;
					case "remove":
					sq.remove();
					break;
					case "peek":
					System.out.println(sq.peek());
					break;
					case "print":
					System.out.println(sq.toString());
					break;
					case "size":
					System.out.println(sq.size());
					default:
					break;
				}
			}
		} else {
			while(n > 0) {
				String line = sc.nextLine();
				String[] s = line.split(" ");
				n--;
				switch (s[0]) {
					case "add":
					sq.addQ(Integer.parseInt(s[1]));
					break;
					case "remove":
					sq.remove();
					break;
					case "peek":
					System.out.println(sq.peek());
					break;
					case "print":
					System.out.println(sq.toString());
					break;
					default:
					break;
				}
			}
		}
	}
}
