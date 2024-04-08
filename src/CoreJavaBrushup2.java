import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup2 {

	public static void main(String[] args) {

   int[] arr3 = {1,2,4,5,6,7,8,9,10,122};
       
     for( int i=0; i<arr3.length; i++)
     {
    	 if (arr3[i]%2==0)
    	 {
    	   System.out.println(arr3[i]);
    	   break;
        }
    	 else
    	 {
    		 System.out.println(arr3[i] + " is not multiple of 2");
    	 }
    	 
     }
    	 //create object of the class -object.method
       ArrayList a = new ArrayList();
       a.add("Ronit");
       a.add("Array");
       a.add("list");
      
       // getting particular array
         System.out.println(a.get(2));
       
       //getting full list
       for(int i=0; i<a.size(); i++)
         {
    	   System.out.println(a.get(i));
         }
        
                 //Or
      // for( String val :a)
      //  { 
   	  // System.out.println(val);
       //  }
     
       //item present in arraylist
       System.out.println(a.contains("Ronit"));
       
       //convert array to arraylist and checking item is present
       String[] web = {"ronit" , "is", "the", "best"};
       List<String> webArrayList = Arrays.asList(web);
     System.out.println(webArrayList.contains("ronit"));
       
       
       
    	   
       
       
       
       
    		   
        
	 	
		

	}

}
