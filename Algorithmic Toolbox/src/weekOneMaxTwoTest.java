import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class weekOneMaxTwoTest {

	@Test
	void testFast() {
		
		int[] testArray = new int[9999];
		
		for(int i=0; i < 9999; i++ )
		{
			testArray[i] = i;
		}
		
		assertEquals(0, weekOneMaxTwo.getMaxPairwiseProductFast(testArray), "must be");
		
	}
	
	@Test
	void testComp() {
		
		boolean flag = true;
		Random ran = new Random();
		int n = 5;
		int m = 9;
		int[] testArray = new int[n];
		
		while(flag)
		{
		
			for(int i=0; i < n; i++ )
			{
				testArray[i] = ran.nextInt(m) + 2;
			}
			
			long a = weekOneMaxTwo.getMaxPairwiseProductFast(testArray); 
			long b = weekOneMaxTwo.getMaxPairwiseProductNaive(testArray);
			
			if(a == b)
			{
				for(int i=0; i<testArray.length; i++) {
					System.out.print(testArray[i]+"*");	
				}
				System.out.println();
				System.out.println("OK "+a+" "+b);
			}
			
			else
			{
				for(int i=0; i<testArray.length; i++) {
					System.out.print(testArray[i]+"*");	
				}
				System.out.println();
				System.out.println("Wrong: "+a+" "+b);
				flag = false;
			}
		}
		
	}
}


