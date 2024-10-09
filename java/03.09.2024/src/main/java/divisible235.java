public class divisible235 {
	public static void main(String[] args)
	{
		int i=0,j=1;
		System.out.println("The 10 numbers which are divisible by 2,3,5 are ");
			while(i<10)
			{
				if(j%2==0 && j%3==0 && j%5==0)
				{
					System.out.println(j);
					i++;
				}
				j++;
			}
	}
}
