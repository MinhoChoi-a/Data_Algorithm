//https://github.com/jhines2k7/coursera/blob/master/data-structures-algorithms/week-two/solutions/JobQueue.java


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import wThreeHeap.Swap;

public class wThreeJobQue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new wThreeJobQue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }
    
    
    private void SiftDown(int d) { 
    	
    	int maxIndex = d;
    	    	
    	int needTime = jobs[d];
    	
    	
    	
    	if(left <= data.length-1 && data[left] < data[maxIndex]) {
    		maxIndex = left;
    	}
    	
    	int right = 2*d;
    	
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
    
    
    private void assignJobs() {
        
    	assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
    	
    	int size = jobs.length;
    	
    	for(int i = size/numWorkers; i >= 0; i--) {
    		SiftDown(i);
    	}
    	
    	
    	
    	
    	// TODO: replace this code with a faster algorithm.
        
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
