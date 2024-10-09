import java.util.Scanner;

public class Test {

	public static void main(String args[])
	{
		String str;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String: ");
		str=sc.next();
		int n=str.length();
		boolean flag=false;
			for(int i=0;i<n/2;i++)
			{
				if((str.charAt(i)=='['&&str.charAt(n-i-1)==']')||(str.charAt(i)=='('&&str.charAt(n-i-1)==')')||(str.charAt(i)=='{'&&str.charAt(n-i-1)=='}'))
				{
					flag=true;
				}
				else
				{
					flag=false;
					break;
				}
			}
		if(flag)
		{
			System.out.println("Valid Paranthesis");
		}
		else
		{
			System.out.println("Invalid Paranthesis");
		}
	}
}
