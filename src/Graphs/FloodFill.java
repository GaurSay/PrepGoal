package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        Queue< Pair > q = new LinkedList< >();

        // n x m
        int[][] vis = new int[n][m];
        int[][] output = new int[n][m];
        int iniColor = image[sr][sc];

        q.add(new Pair(sr,sc));
        vis[sr][sc] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output[i][j] = image[i][j];
            }
        }

        // delta row and delta column
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;

            q.remove();
            output[r][c] = color;

            // 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                // check for valid coordinates and unvisited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == 0 && image[nrow][ncol] == iniColor) {

                    vis[nrow][ncol] = 1;
                    // push in queue
                    q.add(new Pair(nrow, ncol));
                }
            }

        }
        return output;
    }

    class Pair {
        int row;
        int col;
        Pair(int _row, int _col) {
            this.row = _row;
            this.col = _col;
        }
    }
}
