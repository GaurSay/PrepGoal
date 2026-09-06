package Graphs;

public class NumOfEnclaves{
    public int numEnclaves(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (n == 0 || m == 0) return 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        // visited matrix
        int[][] vis = new int[n][m];

        // traverse first and last row
        for (int j = 0; j < m; j++) {
            // DFS from top boundary 1
            if (vis[0][j] == 0 && mat[0][j] == 1) dfs(0, j, vis, mat, dr, dc);
            // DFS from bottom boundary 1
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 1) dfs(n - 1, j, vis, mat, dr, dc);
        }

        // traverse first and last column
        for (int i = 0; i < n; i++) {
            // DFS from left boundary 1
            if (vis[i][0] == 0 && mat[i][0] == 1) dfs(i, 0, vis, mat, dr, dc);
            // DFS from right boundary 1
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 1) dfs(i, m - 1, vis, mat, dr, dc);
        }

        // count all '0' which are unvisited
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 1) count++;;
            }
        }
        return count;
    }


    private void dfs(int r, int c, int[][] vis, int[][] mat, int[] dr, int[] dc) {
        // mark current cell visited
        vis[r][c] = 1;
        // cache dimensions
        int n = mat.length, m = mat[0].length;
        // try 4 directions
        for (int k = 0; k < 4; k++) {
            // compute next cell
            int nr = r + dr[k], nc = c + dc[k];
            // check bounds and unvisited 'O'
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && mat[nr][nc] == 1) {
                // continue DFS
                dfs(nr, nc, vis, mat, dr, dc);
            }
        }
    }
}