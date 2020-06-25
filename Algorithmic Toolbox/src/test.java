import java.util.ArrayList;
import java.math.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a=2816213588L;
		long b=239;
		long result;
		
		ArrayList<Integer> list = new ArrayList<>();
		  
		  list.add(1);
		  list.add(1);
		  
		  long q,w;
		  
		  int i =2;
		  
		  int mListLength=0;
		  
		  boolean loop = true;
		  while(i < a && loop)
		  {
			list.add(list.get(i-1) + list.get(i-2));
			
			w = list.get(i-1)%b;
			q = list.get(i)%b;
			
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
		  
		  result=previous;
		  }
		  	  
		  long[] mList = new long[mListLength];
			
		  for(int n=0; n<mListLength; n++) {
				mList[n] = list.get(n)%b;
			}
			
		  int n = (int)a%mListLength;
			
		result=mList[n-1];

	System.out.println(result);
	
	}

	}


