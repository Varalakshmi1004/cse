import java.util.Scanner;
public class repetition {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String:");
		String str=sc.next();
		System.out.println("enter the Number of copies:");
		int n=sc.nextInt();
		String result="";
		for(int i=0;i<n;i++)
		{
			result=result+str.substring(0, 2);
		}
		System.out.println(result);
	}
}
