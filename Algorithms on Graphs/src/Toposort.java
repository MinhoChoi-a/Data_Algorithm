import java.util.*;

public class Toposort {

    private static Integer[] toposort(ArrayList<Integer>[] adj) {
        Stack<Integer> trace = new Stack<>();
        ArrayList<Integer> order = new ArrayList<>();

        Integer[] used = new Integer[adj.length];

        for(int i=0; i< adj.length; i++) {
            used[i] = 0;
        }

        for(int i=0; i < adj.length; i++) {
            if(used[i]==0) {
                dfs(adj, trace, order, used,i);
            }
        }

        Integer[] reverse = new Integer[order.size()];
        int k =0;
        for(int i=order.size()-1; i>=0; i--){
            reverse[k] = order.get(i);
            k++;
        }

        return reverse;
    }

    private static void dfs(ArrayList<Integer>[] adj, Stack<Integer> trace, ArrayList<Integer> order, Integer[] used, int s) {

                used[s] = 1;

                for (int i = 0; i < adj[s].size(); i++) {
                        if(used[adj[s].get(i)] == 0) {
                        dfs(adj, trace, order, used, adj[s].get(i)); }
                }

                order.add(s);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        Integer[] order = toposort(adj);

        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

