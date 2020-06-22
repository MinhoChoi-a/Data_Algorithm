import java.util.*;
import java.io.*;

public class W1_MaxTwo {
	    static long getMaxPairwiseProduct(int[] numbers) {
	        long max_product = 0;
	        int n = numbers.length;
	        int a,b;
	        long maxOne, maxTwo;
	        
	        for (int first = 0; first < n; ++first) {
	            	a = numbers[first];
	            	b = numbers[first+1];
	            	
	            	if (a>b)
	            	{
	            		maxOne = a;
	            	}
	            	
	            	else
	            	{
	            		maxOne=b;
	            	}
	            	long value = (long)numbers[first] * (long)numbers[second]; 
	            	max_product = Math.max(max_product,
	                    value);
	            }
	        }

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

}
