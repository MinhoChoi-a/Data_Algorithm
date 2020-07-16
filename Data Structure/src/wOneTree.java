import java.util.*;
import java.io.*;

public class wOneTree {
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
    
    
	public class TreeHeight {
		int n;
		int parent[];
		
		class Node {
	    	
			int data;
	        List<Node> children = new ArrayList<>();
	        boolean root = false;
			
			Node(int data)
			{
				this.data = data;
			}
			
	    	void addChild(Node child){
	    		this.children.add(child);
	    	}
	    	
	    	void setRoot() {
	    		this.root = true;
	    	}
	    	
	    	List<Node> getChild() {
	    		return this.children;
	    	}
	    	
	    	int getHeight() {
	    		
	    		int x =0;
	    		
	    		if(this.children.isEmpty()) {
	    			return x;
	    		}
	    		
	    		Queue<List<Node>> q = new LinkedList<List<Node>>();
	    		q.add(this.children);
	    		
	    		while(!q.isEmpty()) {
	    			x++;
	    			
	    			List<Node> data = q.poll();
	    			
	    			List<Node> childData = new ArrayList<Node>();
	    			
	    			for(int i =0; i<data.size(); i++) {
	    				
	    				if(!(data.get(i).getChild()).isEmpty()) {
	    					
	    					for(int t=0; t<data.get(i).getChild().size(); t++) {
	    						childData.add((data.get(i)).getChild().get(t));	
	    					}
	    					
	    				}
	    			}
	    			
	    			if(!childData.isEmpty()) {
	    				q.add(childData);
	    				
	    			}
	    		
	    		}
	    		return x+1;
	    	}
		}
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
            
			Node[] nodes = new Node[n]; 
			int rootIndex=0;
			
			for(int i =0; i < n; i++) {
				nodes[i] = new Node(parent[i]);
			}
			
			for(int child_index=0; child_index < n; child_index++) {
				int p = parent[child_index];
				
				if(p == -1) {
					nodes[child_index].setRoot();
					rootIndex=child_index;
				}
				
				else {
					nodes[p].addChild(nodes[child_index]);
				}
			}
			
			
			return nodes[rootIndex].getHeight();
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new wOneTree().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
