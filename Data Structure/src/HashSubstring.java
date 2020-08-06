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
        
        int hashP = input.hashFunction(p);
        
        int lengthS = (input.text).length();
        int lengthP = (input.pattern).length();
        
        for(int i=0; i < lengthS - lengthP - 1; i++) {
        	
        	String check = t.substring(i, i + lengthP - 1);
        	int hashC = input.hashFunction(check);
        		
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
        
        int hashFunction(String str) {
        	
        	int hashPrep = 0;
        	String hashCode = "";
        	int lengthT = text.length();
        	int lengthP = str.length();
        	
        	for(int i=0; i < str.length(); i++) {
        		hashPrep = (int)str.charAt(i);
        		hashPrep = hashPrep* lengthT^ (lengthP - i - 1);
        		hashCode += String.format("%d", hashPrep);
        	}
        	
        	return Integer.parseInt(hashCode);
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

