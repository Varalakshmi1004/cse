public class method_ol {
	public void add(int x,int y)
	{
		System.out.println("Integer addition");
		System.out.println(x+"+"+y+"="+(x+y));
	}
	public void add(String x,String y)
	{
		System.out.println("String Concatenation");
		System.out.println(x+"+"+y+"="+x+y);
	}
	public static void main(String[] args)
	{
		method_ol obj1=new method_ol();
		obj1.add(10,20);
		obj1.add("vara","lakshmi");
	}
}
