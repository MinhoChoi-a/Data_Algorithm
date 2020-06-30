import java.util.Scanner;

public class weekThreeMaxLoot {
	 
	static double max_loot(int n, int w, double vArray[], double wArray[]) {
		    
			int t=0;
		    
		    double vFirst=0, vAfter=0, wAfter=0, wFirst=0;
		    double valueAfter=0, valueBefore=0;
		    
		    boolean loop = true;
		    
		    if(n==1) {
		    	
		    	if(wArray[0]>=w)
		    		return (double)Math.round(vArray[t]/wArray[t]*w*10000d)/10000d;
		    	
		    	else if(wArray[0]<w)
		    		return (double)Math.round(vArray[t]/wArray[t]*wArray[0]*10000d)/10000d;
		    }
		    
		    
		  while(loop) {
		    
		    	int i=0;
		    	t++;
		    
		    	if(n-t==0)
		    	{
		    		loop = false;
		    
		    	}	
		    	
		    while(i < n-t && loop) {
		    	
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
		    
		    	
		    }
		    }
		    
		    double accValue=0;
		    
		    for(int i=n-1; i >= 0; i--) {
		    	
		    		if(wArray[i] <= w) {
		    			accValue+=vArray[i];
		    			w-=wArray[i];
		    		}
		    		
		    		else if(wArray[i] > w) {
		    			accValue+= vArray[i]/wArray[i]*w;
		    			break;
		    		}
		    }
		    
		    return (double)Math.round(accValue*10000d)/10000d;
		    
	}
		    	
		    
		  public static void main(String args[]) {
		    Scanner scanner = new Scanner(System.in);
		    int n = scanner.nextInt();
		    int w = scanner.nextInt();
		    int i=0;
		    
		    double[] vArray = new double[n];
		    double[] wArray = new double[n];
		    
		    while(i < n) {
		    	vArray[i] = scanner.nextDouble();
		    	wArray[i] = scanner.nextDouble();
		    	i++;
		    }
		    
		    System.out.println(max_loot(n, w, vArray, wArray));
		  }
		}


