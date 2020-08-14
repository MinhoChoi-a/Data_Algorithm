import java.util.*;
import java.io.*;

public class is_bst {
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
        
        void preMethod(int i, int small, int big) {
			
        	if(tree[i].left != -1) {
				if(tree[tree[i].left].key > tree[i].key) {
					check = false;
				}
				
				preMethod(tree[i].left, small, big);
			}
			
			if(tree[i].right != -1) {
				if(tree[tree[i].right].key < tree[i].key || tree[tree[i].left].key < small) {
					check = false;
				}
				
				preMethod(tree[i].right, small, big);
			}
		}
		
        void inMethod(int i, ArrayList<Integer> result) {
			
        		if(tree[i].left != -1) {
        			
        			if(tree[tree[i].left].key > tree[i].key) {
            			check=false;
            			return; }
            		
        			inMethod(tree[i].left, result);
    			}
        		
        		result.add(tree[i].key);
        		
        		if(tree[i].right != -1) {
    				
        			if(tree[tree[i].right].key < tree[i].key) {
            			check=false;
            			return;}
    				
    				inMethod(tree[i].right, result);
    			}
        	}
        	
        boolean isBinarySearchTree() {
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	
        	if(tree.length == 0) {
	        	return check;
	        }
	        
        	inMethod(0, result);
        	
        	int index = result.indexOf(tree[0].key);
        	
        	if(check == true) {
        	
        	for(int t=0; t < index; t++) {
        		if(result.get(t) > tree[0].key) {
        			check = false;
        		}
        	}
        	
        	for(int q= index+1; q < tree.length; q++) {
        		if(result.get(q) < tree[0].key ) {
        			check = false;
        		}
        	}
        	
        	}
          return check;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
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
