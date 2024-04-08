
public class MethodsDemo {

	public static void main(String[] args) {
		
		 // Type-1, call method by creating object
		MethodsDemo d = new MethodsDemo();
		
		d.getdata();    // for void, when nothing is returned
		String name = d.getdata();   // for String, when something is returned back
		System.out.println(name);
		
		
		// Type-2, call method directly without creating object by putting static
		getdata2();
		String nam = getdata2();
		System.out.println(nam);
		
		
		

	}
      // Type-1, call method by creating object
	public String getdata()
	{
		System.out.println("hello ronit");
		return "bye";
		
		
	}
	
	   // Type-2, call method directly without creating object by putting static
	public static String getdata2()
	{
		System.out.println("hello tinor");
		return "cya";
		
		
	}
	
}
