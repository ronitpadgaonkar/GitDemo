 
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		
		String s = "God is Great";
		String[] SplittedString = s.split("is");
		System.out.println(SplittedString[0]);
		System.out.println(SplittedString[1].trim());
		
		for(int i=0; i<s.length(); i++)
		{
			System.out.println(s.charAt(i));
			
		}
		
		for(int i=s.length()-1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
			
		}

	}

}
