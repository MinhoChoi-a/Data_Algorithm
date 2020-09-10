import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {

    private static int reach(ArrayList<Integer>[] adj, int x, int y, ArrayList<Integer> visited) {

        boolean visit = false;
        visited.add(x);

        for(int  i=0; i < adj[x].size(); i++) {

            visit = false;

            if(adj[x].get(i) == y) {
                return 1;
            }

            if(visited.contains(adj[x].get(i))) {
                visit = true;
            }

            if(!visit) {
               int c = reach(adj, adj[x].get(i), y, visited);
               if(c == 1) {
                   return 1;
               }
            }
        }
        //write your code here
        return 0;
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        ArrayList<Integer> visited = new ArrayList<>();
        System.out.println(reach(adj, x, y, visited));
    }
}

