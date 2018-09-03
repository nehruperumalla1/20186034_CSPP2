import java.util.*;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	private String data;
	private String length;
	public InputValidator(String input) {
		this.data = input;
	}
	public boolean validateData(String inputdata) {
		if ((this.data).length() >= 6) {
			return true;
		} else {
			return false;
		}
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData(input));

    }

}
