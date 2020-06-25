//Fibonacci Number Again

import java.util.Scanner;

public class weekTwoPisanoPeriod {
  static long pisano(int a, int b) {
	  
	  if (a <= 1)
		return a;
		  
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
	  
	  long[] mList = new long[mListLength];
		
	  for(int n=0; n<mListLength; n++) {
			mList[n] = list[n]%b;
		}
		
	  int n = a%mListLength;
		
	return mList[n-1];
  }
  
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(pisano(a, b));
  }
}
