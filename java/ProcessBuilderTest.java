// Java code illustrating environment() method 
import java.io.*;
import java.util.*;
class ProcessBuilderTest
{ 
	public static void main(String[] arg) throws IOException 
	{ 
		// creating the process 
		ProcessBuilder pb = new ProcessBuilder(); 
		
		// map view of this process builder's environment 
		Map<String, String> envMap = pb.environment(); 
		
		// checking map view of environment 
		for(Map.Entry<String, String> entry : envMap.entrySet()) 
		{
			// checking key and value separately 
			System.out.println("Key = " + entry.getKey() + 
			", Value = " + entry.getValue()); 
		} 
		
			
	} 

  private static String getString(){
    System.out.println("Hello I'm ready!");
    return "Yes I'm ready!";
  }
} 


//changes1
//changes2

//mod1
//mod2
///mod3
