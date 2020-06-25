//Least Common Multiple

import java.util.Scanner;

public class weekTwoLCM {
  static long lcm(int a, int b) {
	  
	  	long current_gcd = 1;
	    int numberA;
	    int numberB;
	    int d=1;
	    
	    if (a>b) {
	    numberA = a;
	    numberB = b; }
	    
	    else {
	    numberA = b;
	    numberB = a; }
	    
	    while(!(d== 0))
	    {
	    	d = numberA%numberB;
	    	numberA = numberB;
	    	numberB = d;
	    }
	    
	    current_gcd = (long)numberA;
	   
	    return current_gcd*(long)((a/current_gcd)*(b/current_gcd));
	  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
