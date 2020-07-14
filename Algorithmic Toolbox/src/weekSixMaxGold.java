import java.util.*;

public class weekSixMaxGold {
	private static Random random = new Random();
	
	static int optimalWeight(int W, int[] w) {
		
		int wLength = w.length;
		int value=0;
		
		
		int[][] valueArray = new int[W+1][wLength+1]; 
		  
		  for(int i=0; i <= wLength; i++) {
			  valueArray[0][i] = 0;  
		  }
		  
		  for(int i=0; i <= W; i++) {
			  valueArray[i][0] = 0;  
		  }
		  

		  for(int i=1; i <= wLength; i++) {
			  
			  int weight = 1;
			  
			  for(int n=1; n<= W; n++) {
			  
				  valueArray[n][i] = valueArray[n][i-1];
				  
				  if(w[i-1] <= weight) {
					value = valueArray[n-w[i-1]][i-1] + w[i-1];
					if(value > valueArray[n][i]) {
						valueArray[n][i] = value;
					}
				  }

				  weight++;
			  }
		  }
		  
		  return valueArray[W][wLength];
		 }

	
	    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

