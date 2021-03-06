import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class weekFivePrimitveCalc {
	 static List<Integer> optimal_sequence(int m) {
	     
		 int[] minArray = new int[m+1];
		 
		 int x= 0;
		 minArray[0] = 0;
		 minArray[1] = 0;
		 
		 List<Integer> sequence = new ArrayList<Integer>(Collections.nCopies(m, 1));
		 
		 for(int t=2; t <minArray.length; t++) {
			 minArray[t] = m;
		 }
		 
		 for(int i=2; i <=m ; i++) {
			 
			 x = minArray[i-1] + 1;
				if(minArray[i] >= x) {
					minArray[i] = x;
					sequence.set(x, i);
				}
			 
				if(i % 3 == 0) {
					x = minArray[i / 3] + 1;
					if(minArray[i] >= x) {
						minArray[i] = x;
						sequence.set(x, i);
					}
				}
				
				if(i % 2 == 0) {
					x = minArray[i / 2] + 1;
					if(minArray[i] >= x) {
						minArray[i] = x;
						sequence.set(x, i);
					}
				}
				
			}	
		 
		 List<Integer> finalSequence = sequence.subList(0, minArray[m]+1);
		 
		 return finalSequence;
		}
		 
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        List<Integer> sequence = optimal_sequence(n);
	        System.out.println(sequence.size() - 1);
	        for (Integer x : sequence) {
	        	System.out.print(x + " ");
	        }
	    }
}
