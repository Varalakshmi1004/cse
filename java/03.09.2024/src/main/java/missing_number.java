import java.util.Scanner;
public class missing_number {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of the array:");
		int n=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("enter array elements:");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int flag=0;
		for(int i=1;i<n;i++)
		{
			if(arr[i]!=arr[i-1]+1)
			{
				System.out.println("The missing number in the series : "+(arr[i]-1));
				flag=1;
				break;
			}
		}
		if(flag!=1)
		{
			System.out.println("No missing number is there in the series");
		}
	}
}
