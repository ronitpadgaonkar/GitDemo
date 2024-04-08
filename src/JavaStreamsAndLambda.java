import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;
import org.testng.Assert;

public class JavaStreamsAndLambda {
	
	@Test
      public void Regular()
           {
	
	         ArrayList<String> names = new ArrayList<String>();
	         names.add("Ajay");
	         names.add("Don");
	         names.add("Alex");
	         names.add("Adam");
	         names.add("Ram");
	         names.add("Abhi");
	
	         //Using regular java expressions
	         int count = 0;
	         for(int i=0; i<names.size(); i++)
	            {
	            	String actual =names.get(i);
	            	if(actual.startsWith("A"))
		              {
			            count++;
		              }
	            }
	         System.out.println("Count is " +count);

           }
	
	
	
	@Test
	  public void StreamFilter()
	  {
		ArrayList<String> names = new ArrayList<String>();
        names.add("Abhishek");
        names.add("Don");
        names.add("Alex");
        names.add("Adam");
        names.add("Ram");
        names.add("Abhijeet");
        
        Long c =names.stream().filter(s->s.startsWith("A")).count();
        
        System.out.println("c is " +c);
        
        
        //***Directly creating lightweight stream compatible collection and not big ArrayList
        Long d = Stream.of("Ajay", "Don", "Alex", "Adam", "Ram").filter( s->
        {
            s.startsWith("A");
            return true;
        }).count();
        
		System.out.println("d is " +d);
		
		
		//Printing all the names having letters >4
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//Printing only the first value [Limiting output to the first value only]
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	  }
	
	
	
	@Test
	  public void StreamMap()
	  {
		ArrayList<String> names = new ArrayList<String>();
        names.add("Man");
        names.add("Don");
        names.add("Woman");
		
		//Printing all the names which ends with "a" with UpperCase
		//Stream.of("Ajay", "Don", "Alex", "Adam", "Ram").filter( s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
        //Printing names which starts with "A" with UpperCase and sorted
		List<String> names1 = Arrays.asList("Abhishek", "Don", "Ram","Adam", "Abhijeet");      //Convert Arrays to ArrayList
		//names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));       //Sorting in alphabetical order 
		
		//Merging two ArrayList in Streams
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));        //Printing all the elements in the list
		Boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	  }
	
	
	
	@Test
	public void StreamCollect()
	{
		//Collecting the result and covert it back into any list
		List<String> ls =Stream.of("Ajay", "Don", "Alex", "Adam", "Ram").filter( s->s.endsWith("m")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
		//1-Printing unique numbers and 2-sort the array and print the 3rd Index
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//values.stream().distinct().forEach(s->System.out.println(s));     //Printing unique numbers from ArrayList
		
		List<Integer> li =values.stream().distinct().sorted().collect(Collectors.toList());       //Getting only unique[distinct] numbers and sorting it in ascending order
		System.out.println(li.get(2));           //Printing 3rd Integer after sorting
	
	}
	
	
      
}
