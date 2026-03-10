import java.util.*;

public class SuperTunnelFinder {
    private int timer = 0;

    public List<Integer> findSuperTunnels(int[][] matrix) {
        int n = matrix.length;
        int[] discoveryTime = new int[n];
        int[] lowLink = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] isSuperTunnel = new boolean[n]; // Use boolean array to avoid duplicates
        
        Arrays.fill(discoveryTime, -1);
        Arrays.fill(lowLink, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, matrix, discoveryTime, lowLink, visited, isSuperTunnel);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSuperTunnel[i]) result.add(i);
        }
        return result;
    }

    private void dfs(int u, int p, int[][] matrix, int[] disc, int[] low, boolean[] vis, boolean[] res) {
        vis[u] = true;
        disc[u] = low[u] = ++timer;
        int children = 0;

        for (int v = 0; v < matrix.length; v++) {
            if (matrix[u][v] == 0 || v == p) continue; 
            if (vis[v]) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                children++;
                dfs(v, u, matrix, disc, low, vis, res);
              
                low[u] = Math.min(low[u], low[v]);
                if (p != -1 && low[v] >= disc[u]) {
                    res[u] = true;
                }
            }
        }
        if (p == -1 && children > 1) {
            res[u] = true;
        }
    }

    public static void main(String[] args) {
        SuperTunnelFinder finder = new SuperTunnelFinder();
        int[][] matrix = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        };
        System.out.println("Super Tunnels: " + finder.findSuperTunnels(matrix));
    }
}
