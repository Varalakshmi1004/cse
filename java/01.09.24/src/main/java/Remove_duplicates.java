import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Remove_duplicates {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of the array:");
		int size=sc.nextInt();
		int[] array = new int[size];
		System.out.println("enter array elements:");
		for(int i =0;i<size;i++)
		{
			array[i]=sc.nextInt();
		}
		HashMap<Integer, Integer> mp = new HashMap<>();
		for(int i=0;i<array.length;i++)
		{
			if(mp.containsKey(array[i]))
			{
				  mp.put(array[i],mp.get(array[i]) + 1);
			}
			else
			{
				mp.put(array[i],1);
			}
		}
		 for (Map.Entry<Integer, Integer> entry : mp.entrySet()) 
		 {
			 if(entry.getValue()==1)
	            System.out.println(entry.getKey());
		 }
		sc.close();
	}
}
