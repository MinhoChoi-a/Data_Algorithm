import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {

    private static ArrayList<Integer> visited = new ArrayList<>();

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {

        boolean visit = false;

        if(visited.contains(x)) {
           visit = true;
        }

        else {
           visited.add(x);
        }


        for(int  i=0; i < adj[x].size(); i++) {

            if (adj[x].get(i) == y) {
                return 1;
            }

            else {
                if(visit == false) {
                    reach(adj, adj[x].get(i), y); }
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
        System.out.println(reach(adj, x, y));
    }
}

