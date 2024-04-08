import java.util.Arrays;

public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		
		int a = 7;
		String cr = "is cristiano ronaldo's number";
		//System.out.println(cr);
		
		
		int[] arr1 = new int[4];
		arr1[0] = 11;
		arr1[1] = 22;
		arr1[2] = 33;
		arr1[3] = 44;
		//System.out.println(arr1[0]);
		
		
		//array for numbers//
		int[] arr2 = {40, 50, 60, 70};
		
		for (int i=0; i<arr2.length; i++)
		{
			
		System.out.println(arr2[i]);
		
		}
		
		
		//array for string of characters//
		String[] web = {"ronit" , "is", "the", "best"};
		
		//Type1 for loop
		
		for (int i=0; i<web.length; i++)
		{
			
		System.out.println(web[i]);
		
		}
		
		//Type2 for loop
		
		for ( String s: web)
		{
			
		System.out.println(s);
		
		}
		
	}

}
