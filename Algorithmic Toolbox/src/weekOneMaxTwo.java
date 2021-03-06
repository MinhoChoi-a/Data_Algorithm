import java.util.*;
import java.io.*;

public class weekOneMaxTwo {
	    
	 static long getMaxPairwiseProductNaive(int[] numbers) {
	        long max_product = 0;
	        int n = numbers.length;

	        for (int first = 0; first < n; ++first) {
	            for (int second = first + 1; second < n; ++second) {
	                max_product = Math.max(max_product,
	                    ((long)numbers[first] * (long)numbers[second]));
	            }
	        }

	        return max_product;
	    }
	
	static long getMaxPairwiseProductFast(int[] numbers) {
	        long max_product = 0;
	        int n = numbers.length;
	        int maxOne=0;
	        int maxTwo=0;
	        int maxIndex = 0;
	        
	        for (int first = 0; first < n; first++) {
	            
	        	int a = numbers[first];
	        	
	        	if (maxOne < a)
	            {
	            	maxOne = a;
	            	maxIndex = first;
	            }
	        }
	        
	        for (int first = 0; first < n; first++) {
            	
        		int b = numbers[first];
	        	
	        	if (maxTwo < b && maxIndex != first)
            	{
            		maxTwo = b;
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
	        System.out.println(getMaxPairwiseProductFast(numbers));
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


