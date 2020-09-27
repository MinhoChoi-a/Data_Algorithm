import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj, int v, ArrayList<Integer> components, int check, ArrayList<Integer> visited) {

            int i = 0;
            while (check == 0 && i < components.size()) {

                if (components.get(i) == v) {
                    check = 1;
                    return check;
                }

                else {

                    if (adj[components.get(i)].size() > 0 && !visited.contains(components.get(i))) {
                        visited.add(components.get(i));
                        check = acyclic(adj, v, adj[components.get(i)], check, visited);
                    }
                }
                i++;
            }

            return check;
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

        int check = 0;

        int v=0;

        ArrayList<Integer> visited = new ArrayList<>();

        while(v < adj.length && check == 0) {
            check = acyclic(adj, v, adj[v], check, visited);
            v++;
            visited.clear();
        }

        System.out.println(check);
    }
}

