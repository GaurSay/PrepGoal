package Dynamic_prog.TwoDimention;

import java.util.Arrays;

public class GridPaths {

    public static void main(String[] args) {
        int n =3;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        func(n-1,n-1,dp);
        System.out.println(dp[n-1][n-1]);
        System.out.println(uniquePaths(3,3));
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


    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
