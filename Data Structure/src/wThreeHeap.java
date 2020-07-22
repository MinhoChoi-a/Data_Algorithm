import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class wThreeHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new wThreeHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }
    
    
    private void SiftDown(int d) { 
    	
    	int maxIndex = d;
    	
    	int left = data[2*d-1];
    	
    	if(left <= d && data[left] < data[d]) {
    		maxIndex = left;
    		swaps.add(new Swap(left, d));
    	}
    	
    	int right = data[2*d+2];
    	
    	if(right <= d && data[right] < data[d]) {
    		maxIndex = right;
    		swaps.add(new Swap(right, d));
    	}
    	
    	if(2*d+2 != maxIndex) {
    		int tmp = data[2*d+2];
            data[2*d+2] = data[maxIndex];
            data[maxIndex] = tmp;
            SiftDown(maxIndex);
    	}
    	
    }
    
    
    private void generateSwaps() {
      
    	int size = data.length - 1;
    	swaps = new ArrayList<Swap>();
    	
    	for(int i = size/2 - 1; i >= 0; i--) {
    		SiftDown(i);
    	}
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
