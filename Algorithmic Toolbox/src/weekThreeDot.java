import java.util.Scanner;

public class weekThreeDot {
	static int maxDotProduct(int a[], int b[]) {
		
		int vBefore, vAfter;
		boolean loop = true;
		
		int d=1;
		int i=0;
		
		while(d < a.length) {
		
			i=0;
		
			while(loop && i < a.length-d) {
				
				vBefore = a[i];
				vAfter = a[i+1];
				
				if(vBefore > vAfter)
				{
					a[i] = vAfter;
					a[i+1] = vBefore;
				}
				i++;
			}
			d++;
		}
		
		d =1;
		
		while(d < b.length) {
			
			i=0;
		
			while(loop && i < b.length-d) {
				
				vBefore = b[i];
				vAfter = b[i+1];
				
				if(vBefore > vAfter)
				{
					b[i] = vAfter;
					b[i+1] = vBefore;
				}
				i++;
			}
			d++;
		}
		
		int sum=0;
		
		i=0;
		
		while(i < a.length) {
			sum += a[i]*b[i];
			i++;
		}
		
		return sum;
		
	}
		
		
		
		
		
		    
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = scanner.nextInt();
	        }
	        int[] b = new int[n];
	        for (int i = 0; i < n; i++) {
	            b[i] = scanner.nextInt();
	        }
	        System.out.println(maxDotProduct(a, b));
	    }
	}

