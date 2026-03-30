package Dynamic_prog;

import java.util.Arrays;

public class MinimumNumberOfCoins {


    public static void main(String[] args) {
        int target = 11;
        int[] coins={1,2,5};
        int n = coins.length;
        int[][] dp = new int[n][target+1];

        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
//        count_min(n-1, coins, target,dp);
//        System.out.println(dp[n-1][target] );
        tabular(coins, target);
    }

    private static void tabular(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];

        for(int t=0;t<=target;t++){
            if(t%coins[0] ==0){
                dp[0][t] =  t/coins[0];
            }
            else{
                dp[0][t] = (int) 1e9;
            }
        }

        for(int index=1;index<n;index++){
            for(int t=0;t<=target;t++){
                int notTake = dp[index-1][t];
                int take = (int)1e9;
                if(t>=coins[index]){
                    take = 1 + dp[index][t-coins[index]];
                }
                dp[index][t] = Math.min(take,notTake);
            }
        }

        System.out.println(dp[n-1][target]);

    }

    private static int count_min(int index, int[] coins, int target,int[][] dp) {
        if(index==0){
            if(target%coins[0] ==0){
                return target/coins[0];
            }
            else{
                return (int) 1e9;
            }
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }

        int notTake = count_min(index-1,coins,target,dp);
        int take = (int)1e9;
        if(target>=coins[index]){
            take = 1 + count_min(index,coins,target-coins[index],dp);
        }
        dp[index][target] = Math.min(take,notTake);
        return Math.min(take,notTake);
    }


}
