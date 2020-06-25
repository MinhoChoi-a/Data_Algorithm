//Fibonacci Number Again

import java.util.*;

public class weekTwoPisanoPeriod {
  static long pisano(long a, long b) {
	  
	  long[] list = new long[a];
	  
	  list[0] = 1;
	  list[1] = 1;
	  
	  long q,w;
	  
	  int i =2;
	  
	  int mListLength=0;
	  
	  boolean loop = true;
	  while(i < a && loop)
	  {
		list[i] = list[i-1] + list[i-2];
		
		w = list[i-1]%b;
		q = list[i]%b;
		
		if (w==0 && q==1)
		{
			mListLength = i;
			loop = false;
		}
		
		i++;
		  
	  }
	
	  if(mListLength ==0)
	  {
	  long previous = 1;
      long current  = 1;

      for (i = 0; i < a - 1; ++i) {
          long tmp_previous = previous % b;
          previous = current % b;
          current = (tmp_previous + current) % b;
      	}
	  
	  return previous;
	  }
	  	  
	  long[] mList = new long[mListLength];
		
	  for(int n=0; n<mListLength; n++) {
			mList[n] = list[n]%b;
		}
		
	  int n = a%mListLength;
		
	return mList[n-1];
  }
  
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    System.out.println(pisano(a, b));
  }
}
