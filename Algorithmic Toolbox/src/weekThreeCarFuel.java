import java.util.Scanner;

public class weekThreeCarFuel {
	 
	static int min_refills(int dist, int tank, int stops[]) {
		
		int num=0;
		int lastStop=0;
		int d = dist;
		int c = 0;
		
		boolean loop = true;
		
		while(loop) {
			
			if (d <= tank) {
				loop = false;
			}
			
			else if (d > tank) {
				
				if(c == stops.length) {
					num = -1;
					loop = false;					
				}
				
				else if (stops[c] - lastStop <= tank) {
					
					int i=1;
					
					while(c+i < stops.length && stops[c+i] - lastStop <= tank) {
						i++;
					}
					if( c+i > stops.length) {
						c = c+i;
					}
					
					else {
						d = d - (stops[c+i-1]-lastStop);
						lastStop = stops[c+i-1];
						c = c+i;
						num++;
					}
				}
				
				else if (stops[c] - lastStop > tank) {
					num = -1;
					loop = false;
				}
			}
		}
		
		return num;
	}
		    
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int dist = scanner.nextInt();
	        int tank = scanner.nextInt();
	        int n = scanner.nextInt();
	        int stops[] = new int[n];
	        for (int i = 0; i < n; i++) {
	            stops[i] = scanner.nextInt();
	        }

	        System.out.println(min_refills(dist, tank, stops));
	    }
}


