import java.util.*;
import java.io.*;

public class weekOneMaxTwo {
	    static long getMaxPairwiseProduct(int[] numbers) {
	        long max_product = 0;
	        int n = numbers.length;
	        int maxOne=0;
	        int maxTwo=0;
	        
	        for (int first = 0; first < n; first++) {
	            	
	        	if (maxOne < numbers[first])
	            {
	            	maxOne = numbers[first];
	            }
	        }
	        
	        for (int first = 0; first < n; first++) {
            	
        		if (maxTwo < numbers[first] && numbers[first] != maxOne)
            	{
            		maxTwo = numbers[first];
            	}
	        }
	        
	        max_product = (long)maxOne * (long)maxTwo;
	        
	        return max_product;
	    }

	    public static void main(String[] args) {
	        FastScanner scanner = new FastScanner(System.in);
	        int n = scanner.nextInt();
	        int[] numbers = new int[n];
	        for (int i = 0; i < n; i++) {
	            numbers[i] = scanner.nextInt();
	        }
	        System.out.println(getMaxPairwiseProduct(numbers));
	    }

	    static class FastScanner {
	        BufferedReader br;
	        StringTokenizer st;

	        FastScanner(InputStream stream) {
	            try {
	                br = new BufferedReader(new
	                    InputStreamReader(stream));
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


