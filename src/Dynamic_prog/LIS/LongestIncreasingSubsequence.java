package Dynamic_prog.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
//        System.out.println(findlongest(0,-1,nums,nums.length,dp));
        tabular(nums,nums.length);
    }

    private static void tabular(int[] nums, int n) {
        int[][] dp = new int[n+1][n+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int prev = ind-1;prev>=-1;prev--){
                int length = dp[ind+1][prev+1];
                if( prev == -1 || nums[prev] < nums[ind]){
                    length = Math.max(length,1 + dp[ind+1][ind+1]);
                }
                dp[ind][prev+1] = length;
            }

        }
        System.out.println(dp[0][0]);


    }

    private static int findlongest(int ind, int prev, int[] nums, int n,int dp[][]) {
        if(ind == n){
            return 0;
        }
        if(dp[ind][prev+1] != -1){
            return dp[ind][prev+1];
        }
        int length = findlongest(ind+1,prev,nums,n,dp);
        if(prev == -1 || nums[prev] < nums[ind]){
            length = Math.max(length,1 + findlongest(ind+1,ind,nums,n,dp));
        }
        dp[ind][prev+1]= length;
        return dp[ind][prev+1];
    }

}
