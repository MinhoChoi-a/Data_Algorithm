import java.util.Scanner;

public class weekThreeCarFuel {
	 
	static int min_refills(int dist, int tank, int stops[]) {
		    
		int stop=0;
		int num=0;
		boolean loop = true;
		int t=1;
		
		for(int i =0; i < stops.length; i++) {
			
			if(stops[i] - stop <= tank ) {
				
				while(loop) {
					if(stops[i+t] - stop > tank)
					{
						stop = stops[i+t-1];
						num++;
						loop = false;
					}
				t++;
				}
			}
			
			else if(stops[i] - stop > tank) {
				return -1;
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


