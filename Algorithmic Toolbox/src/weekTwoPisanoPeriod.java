import java.util.*;
import java.math.*;

public class weekTwoPisanoPeriod {
  static int pisano(long a, int b) {
	  
	  ArrayList<Integer> mList = new ArrayList<>();
	  
	  	  int previous = 1;
		  int current  = 1;
		  int i = 0;
		  mList.add(1);
		  
		  int c = 0;
		  
		  int result;
		  
      for (i = 2; i < a; ++i) {
          int tmp_previous = previous % b;
          previous = current % b;
          current = (tmp_previous + current) % b;
      	
          mList.add(previous);
          
          if(previous==0 && current==1) {
        	  c=1;
        	  break;
        	}
       }
	  
      if(c==1) {
		  int n = (int)(a%mList.size());
		  if(n==0)
		  {
			  result=mList.get(mList.size()-1);
		  }
		  
		  else {
		  result=mList.get(n-1);
		  }
      }
      else
    	  result=current;
  
      return result;
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    int b = scanner.nextInt();

    System.out.println(pisano(a, b));
  }
}