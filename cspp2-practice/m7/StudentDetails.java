import java.util.Scanner;
class Student {
	private String name;
	int roll;
	double[] marks = new double[3];
	public Student(String name1, int roll1, double[] marks1) {
		this.name = name1;
		this.roll = roll1;
		this.marks = marks1;
	}
	public double average(Student details) {
		int marks1 = 0;
		for(int i = 0; i < 3; i++) {
			marks1 += marks[i];
		}
		marks1 = marks1/3;
		return marks1;
	}
}
public class StudentDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "";
		int roll = 0;
		double[] marks = new double[3];
		int n = sc.nextInt();
		for (int i = 0; i < n;i++) {
			name = sc.next();
			roll = sc.nextInt();
			for (int j = 0; j < 3; j++) {
				marks[j] = sc.nextInt();
			}
			Student s = new Student(name, roll, marks);
			System.out.println(s.average(s));
		}
	}
}