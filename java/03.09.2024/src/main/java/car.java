public class car {
	public void price(int millege)
	{
		int cost=millege*10000;
		System.out.println("price of any car based on millege="+cost);
	}
	public static void main(String[] args)
	{
		tata t1=new tata();
		t1.price(80);
		car c1=new car();
		c1.price(80);
	}
}
