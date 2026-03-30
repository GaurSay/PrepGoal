package Dynamic_prog;

import java.util.Arrays;

public class knapsack_0_1 {

    public static void main(String[] args) {
        int n = 3;
        int[] wt = {3,2,5};
        int[] val= {30,40,60};

        int W = 6;
        int[][] dp = new int[n][W+1];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

//        System.out.println(knapsack(n-1,n,wt,val,W,dp));
//        knapsack(n-1,n,wt,val,W,dp);
//        System.out.println(dp[n-1][W]);

        tabular(n,wt,val,W);
    }

    private static void tabular(int n, int[] wt, int[] val, int W) {

        int[][] dp = new int[n][W+1];

        //base case
        for(int i=wt[0];i<W;i++){
            dp[0][i] = val[0];
        }

        for(int index=1;index<n;index++){
            for(int w=0;w<W;w++){

                int notTake = dp[index-1][W];
                int take = Integer.MIN_VALUE;
                if(wt[index]<=W){
                    take = val[index] + dp[index-1][W-wt[index]];
                }
                dp[index][W] = Math.max(take,notTake);
            }
        }

        System.out.println(dp[n-1][W]);

    }

    private static int knapsack(int index,int n, int[] wt, int[] val, int W,int dp[][]) {
        if(index == 0){
            if(W>=wt[0]){
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[index][W]!=-1){
            return dp[index][W];
        }

        int notTake = knapsack(index - 1, n, wt, val, W,dp);
        int take = Integer.MIN_VALUE;
        if(wt[index]<=W){
            take = val[index] + knapsack(index-1,n,wt,val,W-wt[index],dp);
        }
        dp[index][W] = Math.max(take,notTake);
        return Math.max(take,notTake);
    }


}
