import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class weekFourMajority {

	
	static int findCandidate(int a[], int size) {
		
		 int maj_index = 0, count = 1; 
	        int i; 
	        for (i = 1; i < size; i++)  
	        { 
	            if (a[maj_index] == a[i]) 
	                count++; 
	            else
	                count--; 
	            if (count == 0) 
	            { 
	                maj_index = i; 
	                count = 1; 
	            } 
	        } 
	        return a[maj_index]; 
	    } 
	
	
	static boolean isMajority(int a[], int size, int cand) { 
        int i, count = 0; 
        for (i = 0; i < size; i++)  
        { 
            if (a[i] == cand) 
                count++; 
        } 
        if (count > size / 2)  
            return true; 
        else
            return false; 
    }  
	
	
	static int getMajorityElement(int[] a, int left, int right) {
		 /* Find the candidate for Majority*/
        int cand = findCandidate(a, right); 
  
        /* Print the candidate if it is Majority*/
        if (isMajority(a, right, cand)) 
            return 1;
        else 
            return -1; 
    } 
	
	
	
	/*
	static int getMajorityElement(int[] a, int left, int right) {
     
		int d = right/2;
		int t = 0;
		int check=0;
		int count=0;
	
	if(right == 1)
		return 1;
		
		
	for(int i=0 ;i < d;i++) {
		
		count=1;
		t=0;
	
		while(d+t < right) {
			
			check = a[d+t];
			
			if(check == a[i]) {
				count++;
			}
			
			t++;
		}
		
		if(count > d) {
			return count;
		}
		
		else if(count > 1){
			
			t=1;
			
			while(i+t < d) {
				
				check = a[i+t];
				
				if(check == a[i]) {
					count++;
					}
				t++;
				
				}
			
			if(count > d) {
				return count;
			}
		}
		
		}
	
		return -1;
		
	}
	
	*/
	
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}


	

