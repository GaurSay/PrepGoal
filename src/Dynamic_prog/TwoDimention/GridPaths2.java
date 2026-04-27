package Dynamic_prog.TwoDimention;

import java.util.Arrays;

public class GridPaths2 {


    public static void main(String[] args) {
        int n =3;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        func(n-1,n-1,dp);
        System.out.println(dp[n-1][n-1]);
        int grid[][] =  {{0,1}};
        System.out.println(tabularize(grid));
    }

    private static int tabularize(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        if (grid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    private static int func(int i, int j,int dp[][]) {
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j] !=-1) return dp[i][j];
        if (i==0 && j==0){
            return 1;
        }

        dp[i][j] =  func(i-1,j,dp) +  func(i,j-1,dp);
        return dp[i][j];
    }
}
