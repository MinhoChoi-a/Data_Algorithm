import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class weekFourBinary {
	
	static int binarySearch(int a[], int b) {
		
		int h = a.length -1;
		int l = 0;
		int m = 0;
		int p = -1;
		
		boolean loop = true;
		
		while(loop && l <= h) {
			
			m = l + (h-l)/2;
			
			if(b == a[m]) {
				loop = false;
				p = m;
			}
			
			else if(b < a[m]) {
				h = m - 1;
			}
			
			 else if(b > a[m]) {
				l = m + 1;
			}
			
		}
		return p;
	}
	public static void main(String[] args) {
        
		FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
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

