import java.util.Scanner;

public class weekSixParenthese {

	static long getMaximValue(String exp) {
	    
		int length = (exp.length()+1)/2;
		
		char[] operation = new char[length-1];
		
		long[][] min = new long[length][length];
		long[][] max = new long[length][length];
		
		for(int i=0; i<length; i++) {
			for(int y=0; y<length; y++) {
				min[i][y] = 0;
				max[i][y] = 0;
			}
		}
		
		int j = 0;
		long[] array = new long[4];
		
		int p = 1;
		for(int i=0; i< length-1; i++) {
			operation[i] = exp.charAt(p);
			p=p+2;
		}
		
		p = 0;
		for(int i=0; i< length; i++) {
			min[i][i] = Character.getNumericValue(exp.charAt(p));
			max[i][i] = Character.getNumericValue(exp.charAt(p));
			p=p+2;
		}
		
		for(int s=1; s<=length-1; s++) {
			
			for(int i=0; i<length-s; i++) {
				
				j = i+s;
				
				long minNum= Long.MAX_VALUE, maxNum= Long.MIN_VALUE;
				for(int k=i; k<=j-1; k++) {
					
					long a=0,b=0,c=0,d=0;
					
					if(operation[k]=='+') {
					
						a = max[i][k] + max[k+1][j];
						b = max[i][k] + min[k+1][j];
						c = min[i][k] + min[k+1][j];
						d = min[i][k] + max[k+1][j];
					}
					
					else if(operation[k]=='-') {
						
						a = max[i][k] - max[k+1][j];
						b = max[i][k] - min[k+1][j];
						c = min[i][k] - min[k+1][j];
						d = min[i][k] - max[k+1][j];
					}
					
					else if(operation[k]=='*') {
						
						a = max[i][k] * max[k+1][j];
						b = max[i][k] * min[k+1][j];
						c = min[i][k] * min[k+1][j];
						d = min[i][k] * max[k+1][j];
					}
					
					array[0] = a;
					array[1] = b;
					array[2] = c;
					array[3] = d;
					
					for(int x=1; x<4; x++) {
						
						for(int t=0; t<4-x; t++) {
						
						long before = array[t];
						long after = array[t+1];
						
						if(before>after) {
							array[t] = after;
							array[t+1] = before;
							}
						}
					}
					
					if(minNum > array[0]) {
						minNum = array[0];
					}
					
					if(maxNum < array[3]) {
						maxNum = array[3];
					}
				}
				
				min[i][j] = minNum;
				max[i][j] = maxNum;
			}
		}
		
		return max[0][length-1];
	}
		
			
		
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String exp = scanner.next();
	        System.out.println(getMaximValue(exp));
	    }
	}

