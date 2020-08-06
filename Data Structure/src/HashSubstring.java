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
        for (int cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String p = input.pattern, t = input.text;
        
        List<Integer> point = new ArrayList<Integer>();
        
        Long[] hashList = input.PreComputeHash();
        
        long hashCheck = input.hashFunction(p);
        
        for(int i=0; i < hashList.length; i++) {
        	
        	if(hashList[i] == hashCheck) {
        		
        		if(p.equals(t.substring(i, i+p.length()))) {
        			point.add(i);
        		}
        		
        	}
        		
        	}
        					
        return point;
        
    }     
        
        
    static class Data {
        String pattern;
        String text;
        int prime = 100000007;
        int x = 1011;
        
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
        
        Long hashFunction(String str) {
        	
        	int lengthP = str.length();
        	
        	long hashCode = 0;
        	
        	for(int i= lengthP -1; i >= 0 ; i--) {
        		hashCode = (hashCode*x + (int)str.charAt(i)) % prime;
        	}
        	
        	return hashCode;
        }
        
        Long[] PreComputeHash() {
        	
        	int lengthP = pattern.length();
        	int lengthS = text.length();
        	
        	Long[] hashList = new Long[lengthS - lengthP + 1];	
        	
        	String s = text.substring(lengthS - lengthP);
        	
        	hashList[lengthS - lengthP] = hashFunction(s);
        	
        	long y = 1;
        	
        	for (int i =1; i <= lengthP; i++) {
        		y = (y * x) % prime;
        	}
        	
        	for (int i = lengthS-lengthP-1; i >= 0; i--) {
        		long preHash = x * hashList[i+1] + text.charAt(i) - y * text.charAt(i+lengthP);
        		
        		while (preHash < 0) {
        			preHash += prime;
        		}
        		
        		hashList[i] = preHash % prime;
        	}
        	
        	return hashList;
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