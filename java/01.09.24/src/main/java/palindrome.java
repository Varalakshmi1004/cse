import java.util.Scanner;
public class palindrome {
		public static void main(String[] args)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter the value:");
			String value = scanner.nextLine();
			int flag=1;
			int n=value.length();
			
			for(int i=0;i<n/2;i++)
			{
				if(value.charAt(i)!=value.charAt(n-i-1))
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("Number is palindrome");
			}
			else
			{
				System.out.println("Number is not Palindrome");
			}
		}
}
