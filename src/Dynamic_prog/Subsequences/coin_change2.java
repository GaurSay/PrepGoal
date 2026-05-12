package Dynamic_prog.Subsequences;

import java.util.Arrays;

public class coin_change2 {

    public static void main(String[] args) {

        int target = 4;
        int[] coins = {1, 2, 3};
        int n = coins.length;
        int[][] dp = new int[n][target + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        countWays(n - 1, coins, target, dp);
        System.out.println(dp[n-1][target]);
        tabular(coins,target);
    }

    private static void tabular( int[] coins,int target){

        int n = coins.length;
        int[][] dp = new int[n][target+1];

        for(int t=0;t<=target;t++){
            if(t%coins[0] ==0){
                dp[0][t] =  1;
            }
        }

        for(int index=1;index<n;index++){
            for(int t=0;t<=target;t++){
                int notTake = dp[index-1][t];
                int take = 0;
                if(t>=coins[index]){
                    take = dp[index][t-coins[index]];
                }
                dp[index][t] = take+notTake;
            }
        }
        System.out.println(dp[n-1][target]);

    }


    private static int countWays(int index, int[] coins, int target, int[][] dp) {
        if (index == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = countWays(index - 1, coins, target, dp);
        int take = 0;
        if (target >= coins[index]) {
            take = countWays(index, coins, target - coins[index], dp);
        }
        dp[index][target] = take + notTake;
        return take + notTake;
    }
}
