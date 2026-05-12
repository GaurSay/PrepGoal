package Dynamic_prog.TwoDimention;

import java.util.Arrays;

public class Cheery_pickup_3D {

    public static void main(String[] args) {
        int[][] arr = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};

        int n = arr.length;
        int m = arr[0].length;

        int[][][] dp= new int[n][m][m];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        System.out.println(maxprofit(0, 0, m - 1, arr,n,m,dp));
        tabularize(m,n,arr);
    }

    private static void tabularize(int m, int n, int[][] arr) {
        int[][][] dp= new int[n][m][m];
        //base case
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2] = arr[n-1][j1];
                }else{
                    dp[n-1][j1][j2] = arr[n-1][j1] + arr[n-1][j2];
                }
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = (int)-1e9;
                    for(int dj1=-1; dj1<=1; dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int value = 0;
                            if(j1 == j2) {
                                value = arr[i][j1];
                            }else{
                                value =arr[i][j1]  +  arr[i][j2];
                            }
                            if(j1+dj1>=0 && j1+dj1 <m && j2+dj2>=0 && j2+dj2 <m ){
                                value += dp[i+1][j1+dj1][j2+dj2];
                            } else{
                                value += (int)-1e9;
                            }
                            maxi = Math.max(maxi,value);
                        }
                    }
                    dp[i][j1][j2]= maxi;
                }
            }
        }
        System.out.println(dp[0][0][m-1]);
    }

    private static int maxprofit(int i, int j1, int j2, int[][] arr,int n,int m,int[][][] dp) {
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)-1e9;
        }

        //base case
        if(i==n-1){
            if(j1==j2){
                return arr[i][j1];
            }
            else{
                return arr[i][j1] + arr[i][j2];
            }
        }

        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }

        int maxi = (int)-1e9;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1 == j2){
                    maxi = Math.max(maxi,arr[i][j1] +  maxprofit(i+1,j1+dj1,j2+dj2,arr,n,m,dp));
                }
                else{
                    maxi = Math.max(maxi,arr[i][j1]  +  arr[i][j2] + maxprofit(i+1,j1+dj1,j2+dj2,arr,n,m,dp));    ;
                }
            }
        }
        dp[i][j1][j2]= maxi;
        return maxi;

    }


}
