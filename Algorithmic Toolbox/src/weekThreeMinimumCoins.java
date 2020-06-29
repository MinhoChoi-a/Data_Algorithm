import java.util.Scanner;

public class weekThreeMinimumCoins {
	 
	static int mini_coins(int n) {
		    
			int number = 0;
		    int[] array = {10,5,1};
		    int m=1;
		    int i=0;
		    int a=0;
		    
		    while(i < 3 && m != 0) {
		    	m = n%array[i];
		    		
		    	if(m!=0) {
		    		a=n/array[i];
		    		number += a;
		    		n=m;
		    		}
		    	
		    	else if(m==0) {
		    		a=n/array[i];
		    		number += a;
		    		}
		    		
		    	i++;
		    }
	
		    return number;
	
	}
		    

		  public static void main(String args[]) {
		    Scanner scanner = new Scanner(System.in);
		    int n = scanner.nextInt();
		    
		    System.out.println(mini_coins(n));
		  }
		}


