import java.util.Scanner;

public class weekThreeMaxLoot {
	 
	static double max_loot(int n, int w, double vArray[], double wArray[]) {
		    
			int price = 0;
		    
			
			int t=0;
		    double a=0;
		    double vFirst, vAfter, wAfter, wFirst;
		    double valueAfter, valueBefore;
		    
		    boolean loop = true;
		    
		    while(loop) {
		    
		    	int i=0;
		    	t++;
		    	
		    while(i < n-t) {
		    	
		    	vFirst = vArray[i];
		    	wFirst = wArray[i];
		    	vAfter = vArray[i+1];
		    	wAfter = wArray[i+1];
		    	valueBefore = vArray[i]/wArray[i];
		    	valueAfter = vArray[i+1]/wArray[i+1];
		    	
		    	if(valueBefore > valueAfter)
		    	{
		    		vArray[i+1] = vFirst;
		    		vArray[i] = vAfter;
		    		
		    		wArray[i+1] = wFirst;
		    		wArray[i] = wAfter;
		    	}
		    	i++;
		    
		    	if(i >= n-t)
		    	{
		    		loop = false;
		    
		    	}
		    }
		    }
		    
		    double accValue=0, accWeight=0;
		    
		    for(int i=n-1; n < 0; i--) {
		    	
		    	accWeight+=wArray[i];
		    	
		    		if(accWeight <= w) {
		    			accValue+=vArray[i];
		    		}
		    		
		    		else {
		    			break;
		    		}
		    	}
		    
		    return accValue;
		    
	}
		    	
		    
		  public static void main(String args[]) {
		    Scanner scanner = new Scanner(System.in);
		    int n = scanner.nextInt();
		    int w = scanner.nextInt();
		    int i=1;
		    
		    double[] vArray = new double[n];
		    double[] wArray = new double[w];
		    
		    while(i <= n) {
		    	vArray[n] = scanner.nextDouble();
		    	wArray[n] = scanner.nextDouble();
		    	n++;
		    }
		    
		    System.out.println(max_loot(n, w, vArray, wArray));
		  }
		}


