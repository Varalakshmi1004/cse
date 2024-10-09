import java.util.Scanner;
public class charType {
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a String:");
		String input=scanner.next();
		for(int i=0;i<input.length();i++)
		{
		char ch = input.charAt(i);
		if(Character.isDigit(ch))
			System.out.println("Digit");
		else if(Character.isLetter(ch))
			System.out.println("Alphabet");
		else 
			System.out.println("Special Character");
		}
		scanner.close();
	}
}
