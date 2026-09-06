package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue< Pair > q = new LinkedList< >();
        int[][] vis = new int[n][m];
        int[][] output = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};


        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dist;

            q.remove();
            output[r][c] = d;

            // exactly 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, d+1));
                }
            }
        }
        return output;
    }
}
class Pair {
    int row;
    int col;
    int dist;

    Pair(int _row, int _col, int _dist) {
        this.row = _row;
        this.col = _col;
        this.dist = _dist;
    }
}
