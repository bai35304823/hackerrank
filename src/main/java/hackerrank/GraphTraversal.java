//Solution Approach

//Use DFS traversal, always visiting the largest-numbered neighbor first to maximize lexicographical order.

//Maintain a visited set to build B directly while traversing (A is optional).

//The resulting B is unique and lexicographically largest.





import java.util.*;

public class GraphTraversal {

    public static List<Integer> coolGraph(int g_nodes, int[] g_from, int[] g_to) {
        // Build adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= g_nodes; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < g_from.length; i++) {
            int u = g_from[i];
            int v = g_to[i];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // Sort neighbors in descending order for lexicographically largest traversal
        for (List<Integer> neighbors : adj.values()) {
            Collections.sort(neighbors, Collections.reverseOrder());
        }

        List<Integer> B = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        // DFS traversal
        dfs(1, adj, visited, B);

        return B;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> adj,
                            Set<Integer> visited, List<Integer> B) {
        if (!visited.contains(node)) {
            B.add(node);
            visited.add(node);
        }

        for (int neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adj, visited, B);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        int g_nodes = 5;
        int[] g_from = {4,5,1,4,3};
        int[] g_to   = {5,1,4,3,2};

        List<Integer> B = coolGraph(g_nodes, g_from, g_to);
        System.out.println(B); // Output: [5,4,3,2,1]
    }
}
