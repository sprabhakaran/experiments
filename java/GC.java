
import java.util.*;

public class GC{

	public static void main(String args[]){
	
		System.out.println("called");
		createFewLongLivedAndManyShortLivedObjects();
	
	}

	private static void createFewLongLivedAndManyShortLivedObjects() {
		HashSet<Double> set = new HashSet<Double>();

		long l = 0;
		for (int i=0; i < 100; i++) {
			Double longLivedDouble = new Double(l++);
			set.add(longLivedDouble);  // add to Set so the objects continue living outside the scope
		}

		while(true) { // Keep creating short-lived objects. Extreme but illustrates the point
			Double shortLivedDouble = new Double(l++);
		}
	}
}
