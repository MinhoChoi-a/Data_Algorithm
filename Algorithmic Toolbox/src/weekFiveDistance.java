import java.util.Scanner;

public class weekFiveDistance {
	  public static int EditDistance(String s, String t) {
		  
		  int sLength = s.length();
		  int tLength = t.length();
		  
		  int x= 0;
		  
		  int[][] dimArray = new int[s.length()+1][t.length()+1]; 
		  
		  dimArray[0][0] = 0;
		  
		  for(int i=1; i <= sLength; i++) {
			  dimArray[i][0] = i;  
		  }
		  
		  for(int i=1; i <= tLength; i++) {
			  dimArray[0][i] = i;  
		  }
		  
		  //need to determine which string is longer
		  
		  for(int i=1; i <= tLength; i++) {
			  
			  for(int n=1; n<=sLength; n++) {
			  
			  if(s.charAt(n-1) == t.charAt(i-1)) {
				  x = dimArray[n-1][i-1];
				  dimArray[n][i] = x;
			  }
			  
			  else if(s.charAt(i-1) != t.charAt(i-1)) {
				  x = dimArray[n-1][i-1] + 1;
				  dimArray[n][i] = x;
				  
				  	if(dimArray[n][i] > dimArray[n-1][i]) {
				  		x = dimArray[n-1][i]+1;
				  		dimArray[n][i] = x;
				  	}
				  	
				  	if(dimArray[n][i] > dimArray[n][i-1]) {
				  		x = dimArray[n][i-1]+1;
				  		dimArray[n][i] = x;
				  	}
			  }
			}
		  }
		  
		  	return dimArray[sLength][tLength];
		 }
	  
	  
		  public static void main(String args[]) {
		    Scanner scan = new Scanner(System.in);

		    String s = scan.next();
		    String t = scan.next();

		    System.out.println(EditDistance(s, t));
		  }

		}
