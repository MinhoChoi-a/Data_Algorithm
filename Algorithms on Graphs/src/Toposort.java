import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {

    private static Integer[] toposort(ArrayList<Integer>[] adj) {
        ArrayList<Integer> used = new ArrayList<>();
        ArrayList<Integer> order = new ArrayList<>();

        dfs(adj, used, order, 0);

        int max = Collections.max(order);
        int min = Collections.min(order);

        Integer[] reverse = new Integer[order.size()];
        int k =0;
        for(int i=order.size()-1; i>=0; i--){
            reverse[k] = order.get(i);
            k++;
        }

        for(int i =0; i<adj.length;i++) {
            if(!order.contains(i)) {
                if(i < min) {
                    //put front
                }

                else if(i>max) {
                    //put behind
                }

            }
        }


        return reverse;
    }

    private static void dfs(ArrayList<Integer>[] adj, ArrayList<Integer> used, ArrayList<Integer> order, int s) {

        if(!used.contains(s)) {

            while(s < adj.length) {

                  for (int i = 0; i < adj[s].size(); i++) {

                      if (adj[adj[s].get(i)].size() > 0) {
                          dfs(adj, used, order, adj[s].get(i));
                      } else {
                          used.add(adj[s].get(i));
                          if (!order.contains(adj[s].get(i))) {
                              order.add(adj[s].get(i));
                          }
                      }

                      if (!order.contains(s)) {
                          if (!order.contains(s)) {
                              order.add(s);
                              used.add(s);
                          }
                      }
                  }
                s++;
              }
            }
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

