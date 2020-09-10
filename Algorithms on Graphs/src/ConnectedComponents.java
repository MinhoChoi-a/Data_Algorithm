import java.util.ArrayList;
import java.util.Scanner;


public class ConnectedComponents {

    private static ArrayList<Integer> reach(ArrayList<Integer>[] adj, ArrayList<Integer> visited, int x) {

        boolean visit = false;
        visited.add(x);

        for(int  i=0; i < adj[x].size(); i++) {

            visit = false;

            if(visited.contains(adj[x].get(i))) {
                visit = true;
            }

            if(!visit) {
                reach(adj, visited,adj[x].get(i));
                }
            }
        return visited;
    }


    private static int numberOfComponents(ArrayList<Integer>[] adj, ArrayList<Integer> visitedV, int x) {

        for(int  i=0; i < adj.length; i++) {

                if(!visitedV.contains(i)) {
                    visitedV = reach(adj, visitedV, i);
                    x++;
                }
        }

        return x;
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

        int x = 0;
        ArrayList<Integer> visited = new ArrayList<Integer>();

        if(m == 0) {
            x = n;
        }

        else {
            x = numberOfComponents(adj, visited, x);
        }

        System.out.println(x);
    }
}

