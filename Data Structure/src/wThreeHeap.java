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
    	    	
    	int left = 2*d+1;
    	
    	if(left <= data.length-1 && data[left] < data[maxIndex]) {
    		maxIndex = left;
    	}
    	
    	int right = 2*d+2;
    	
    	if(right <= data.length-1 && data[right] < data[maxIndex]) {
    		maxIndex = right;
    	}
    	
    	if(d != maxIndex) {
    		int tmp = data[d];
            data[d] = data[maxIndex];
            data[maxIndex] = tmp;
            swaps.add(new Swap(d, maxIndex));
            SiftDown(maxIndex);
    	}
    	
    	
    }
    
    
    private void generateSwaps() {
      
    	int size = data.length-2;
    	swaps = new ArrayList<Swap>();
    	
    	for(int i = size/2; i >= 0; i--) {
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
