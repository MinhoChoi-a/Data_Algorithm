import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {

        Queue<Integer> que = new LinkedList<>();
        que.add(s);

        Boolean[] visited = new Boolean[adj.length];

        for(int i=0; i< visited.length; i++) {
            visited[i] = false;
        }

        visited[s] = true;

        Integer[] prev = new Integer[adj.length];

        for(int i=0; i <prev.length; i++) {
            prev[i] = -1;
        }


        Integer x = 0;
        ArrayList<Integer> neigh;


        while(!que.isEmpty()) {
            x = que.poll();
            neigh = adj[x];

            for( int n: neigh ) {
                if(!visited[n]) {
                    que.add(n);
                    visited[n] = true;
                    prev[n] = x;
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        for(int at = t; at != -1 ; at = prev[at]) {
                path.add(at);
        }

        if(path.get(path.size()-1) == s)
            return path.size() - 1;

        return -1;
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
        System.out.println(distance(adj, x, y));
    }
}

