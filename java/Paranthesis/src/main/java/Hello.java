import java.util.Scanner;

public class Hello {
	public static void main(String[] args)
	{
		String str;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string contains paranthesis and brackets: ");
		str=sc.next();
		int n=str.length();
		boolean valid;
		if(n%2==0)
		{
			valid=valid_Paranthesis(0,n-1,str);
		}
		else
		{
			valid=false;
		}
		if(valid==true)
		{
			System.out.println("Valid Paranthesis");
		}
		else
		{
			System.out.println("Invalid Paranthesis");
		}
	}
	public static boolean valid_Paranthesis(int start,int end,String str)
	{
		char ch=str.charAt(start);
		int ind=start+1;
		boolean f=false;
		if(start<end)
		{
		for(int i=ind;i<=end;i++)
		{
			if((ch=='['&&str.charAt(i)!=']')||(ch=='('&&str.charAt(i)!=')')||(ch=='{'&&str.charAt(i)!='}'))
			{
				ind++;
			}
			else
			{
				f=true;
			}
		}
		if(start+1!=ind&&f==true)
		{
			valid_Paranthesis(start+1,ind-1,str.substring(start+1,ind-1));
		}
		else
		{
			valid_Paranthesis(ind+1,end,str.substring(ind+1,end));
		}
	}
		return f; 
	}
}

