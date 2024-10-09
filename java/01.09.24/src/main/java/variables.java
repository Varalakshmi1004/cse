public class variables {
	String sname,course; //instance variables
	static String college;
	
	public void getData()
	{
		int x;
		Integer n; //wrapper
		n=20; //n acting as variable
		n.floatValue(); //n acting as object
		System.out.println(sname+" "+course+" "+college);
	}
	public static void main(String[] args)
	{
		variables.college="jntu";
		variables v1=new variables();
		v1.sname="vara";
		v1.course="DataScience";
		v1.getData();
		variables v2=new variables();
		v2.sname="satya";
		v2.course="web";
		v2.getData();
	}
}
