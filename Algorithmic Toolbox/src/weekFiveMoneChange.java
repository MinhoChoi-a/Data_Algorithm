import java.util.Scanner;

public class weekFiveMoneChange {
    
	static int getChange(int m) {
        
    	int[] changeArray = {1,3,4};
    	int[] minArray = new int[m+1];
    	int x = 0;
    	minArray[0] = 0;
    	minArray[1] = 1;
    	
    	for(int t = 2; t < minArray.length; t++) {
    		minArray[t] = m;
    	}
    	
    	for(int i =1; i <=m ; i++) {
    		
    		for(int n=0; n < changeArray.length-1; n++) {
    			
    			if(changeArray[n] <= i) {
    				
    				x = minArray[i-changeArray[n]] + 1;
    					if(minArray[i] >= x) {
    						minArray[i] = x;
    					}
    				}
    			}
    	}	
    	
    	return minArray[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

