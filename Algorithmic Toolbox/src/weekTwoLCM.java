//Least Common Multiple

import java.util.Scanner;

public class weekTwoLCM {
  static double lcm(double a, double b) {
    double d=2; //factorization number
    double f,ff; //rest
    double c=1;
    double leastCommon = 0;
    boolean loop = true;
    boolean nextLoop = true;
    
    if(a==b)
    	return a;
    
    while(loop)
    {
    	f= a%d;
    	ff= b%d;
    	
    	if(f==0 && ff==0)
    	{
    		a = a/d;
	    	b = b/d;
	    	c *= d;
    	}
    	
    	else
    	{
    		d++;
    	}
    	
    	if(d==4)
    		loop = false;
    	
    	else if(a==1 || b==1) {
    		
    		loop = false;
    	 	
    		if(a==1) 
    			leastCommon =  c*b*d;	
    			    
    		else
    			leastCommon = c*a*d;
    	}
    }
    
    if(leastCommon==0) {
    	
    	while(nextLoop)
        {
        	if(d%2==0 || d%3==0)
        		d++;
	    	
        	else {
	        	f= a%d;
	        	ff= b%d;
	        	
	        	if(a==d || b==d)
	        	{
	        		a = a/d;
	    	    	b = b/d;
	    	    	c *= d;
	        	}
	        	
	        	else if(f==0 && ff==0)
	        	{
	        		a = a/d;
	    	    	b = b/d;
	    	    	c *= d;
	        	}
	        	
	        	else {
	        		d++;
	        	}
	        	
	        	if(a==1 || b==1) {
	        		
	        		nextLoop = false;
	        	 	
	        		if(a==1) 
	        			leastCommon =  c*b*d;	
	        			    
	        		else
	        			leastCommon = c*a*d;
	        	}
        	}
        }
    }
    
    return leastCommon;
     
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    double a = scanner.nextDouble();
    double b = scanner.nextDouble();

    System.out.println(lcm(a, b));
  }
}
