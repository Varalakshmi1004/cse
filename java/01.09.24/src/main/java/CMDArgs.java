
public class CMDArgs {
	public static void main(String[] args)
	{
		if(args.length==0)
		{
			System.out.println("No values");
		}
		else
		{
			String result = String.join(",", args);
			System.out.println(result);
		}
	}
}
