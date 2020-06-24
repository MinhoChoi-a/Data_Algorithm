import java.util.*;

public class weekTwoFibonacci {
  static long calc_fib(int n) {
    
	  /** naive way
	  if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2); */
	  
	 //using array
	  if (n <= 1)
	  return n;
	  
	  long[] list = new long[n];
	  
	  list[0] = 1;
	  list[1] = 1;
	  
	  for(int i=2; i <n; i++)
	  {
		  list[i] = list[i-1] + list[i-2];  
	  }
	  
	  return (long)list[n-1];
	  
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
