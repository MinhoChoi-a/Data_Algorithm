import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        boolean check = true;
        Node[] tree;
        
        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        void inMethod(int i,int min, int max) {
			
        	if(check) {
        	
        		if(tree[i].left != -1) {
        			
        			if(tree[tree[i].left].key >= tree[i].key) {
        				check=false;
            			return;
        			}
        			        			
        			if(tree[tree[i].left].key >= max || tree[tree[i].left].key < min) {
            			check=false;
            			return; }
            		
        			inMethod(tree[i].left, min, tree[i].key);
    				}
        		
        		if(tree[i].right != -1) {
        			
        			if(tree[tree[i].right].key < tree[i].key) {
        				check=false;
            			return;
        			}
        			
        			if(tree[tree[i].right].key < min || tree[tree[i].right].key > max) {
            			check=false;
            			return;}
        			
        			inMethod(tree[i].right, tree[i].key, max);
    				}
        		}
        	}
        	
        boolean isBinarySearchTree() {
        	
        	if(tree.length == 0) {
	        	return check;
	        }
        	
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
        	
        	inMethod(0, min, max);
        	        	
          return check;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
