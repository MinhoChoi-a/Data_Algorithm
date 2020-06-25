import java.util.Scanner;

public class weekTwoGCD {
  static int gcd_naive(int a, int b) {
    int current_gcd = 1;
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
    
    current_gcd = numberA;
   
    return current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
