import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj, int v, ArrayList<Integer> components, int check) {

        if(check == 0) {

            int i = 0;
            while (check == 0 && i < components.size()) {

                if (components.get(i) == v) {
                    check = 1;
                    return check;
                } else {
                    if (adj[components.get(i)].size() > 0) {
                        check = acyclic(adj, v, adj[components.get(i)], check);
                    }
                }

                i++;
            }

            v++;

            if (v < adj.length) {
                check = acyclic(adj, v, adj[v], check);
            }

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

        int v = 0;
        ArrayList<Integer> components = adj[0];
        int check = 0;

        System.out.println(acyclic(adj, v, components, check));
    }
}

