import java.util.Scanner;
public class concatenation {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the first string:");
		String s1=sc.next();
		System.out.println("enter the second string:");
		String s2=sc.next();
		String result;
		int n=s1.length();
		if(s1.charAt(n-1)==s2.charAt(0))
		{
			result=s1.substring(0,n-1)+s2;
			result=result.toLowerCase();
		}
		else
		{
			result=s1+s2;
			result=result.toLowerCase();
		}
		System.out.println(result);
	}
}
