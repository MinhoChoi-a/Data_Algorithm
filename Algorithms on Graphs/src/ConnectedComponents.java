import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj, ArrayList<Integer> visited, int x) {

        boolean visit = false;

        for(int  i=0; i < adj.length; i++) {

            for(int t=0; t < adj[i].size(); t++) {

                visited.add(adj[i].get(t));
                visit = false;

                if(visited.contains(adj[i].get(t))) {
                    visit = true;
                }

                if(!visit) {
                    numberOfComponents(adj, visited, x);
                    x++;
                }
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

        int x = 1;
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

