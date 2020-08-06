import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String p = input.pattern, t = input.text;
        
        List<Integer> point = new ArrayList<Integer>();
        
        long hashP = input.hashFunction(p);
        
        int lengthS = (input.text).length();
        int lengthP = (input.pattern).length();
        
        for(int i=0; i <= lengthS - lengthP; i++) {
        	
        	String check = t.substring(i, i + lengthP);
        	long hashC = input.hashFunction(check);
        		
        		if(hashP == hashC) {
        			if(p.equals(check)) {
        				point.add(i);
        			}
        		}
        }
        
        return point;
        
    }     
        
        
    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
        
        long hashFunction(String str) {
        	
        	int prime = 50077;
        	int x = 31;
        	
        	int hashPrep = 0;
        	long hashCode = 0;
        	
        	int lengthP = str.length();
        	
        	for(int i=0; i < lengthP; i++) {
        		hashPrep = (int)str.charAt(i);
        		hashCode = (hashCode*x + hashPrep)%prime;
        	}
        	
        	return hashCode;
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

