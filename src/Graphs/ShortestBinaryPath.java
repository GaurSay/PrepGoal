package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBinaryPath {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
//        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 1;


        //1 block cell
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        int drow[]={-1,0,1};
        int dcol[]={-1,0,1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;

            if(r==n-1 && c==n-1){
                return d;
            }

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {

                    if (dr == 0 && dc == 0) continue;

                    int nr = r + dr;
                    int nc = c + dc;

                    if(nr>=0 && nr<n && nc >=0 && nc<n &&
                            grid[nr][nc] == 0 && 1+d < dist[nr][nc]){
                        dist[nr][nc] = 1 + d;
                        q.add(new Pair(nr,nc,1+d));
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
//        int grid[][] = {{1,0,0},{1,1,0},{1,1,0}};
        int grid[][] = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
