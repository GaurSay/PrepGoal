package Dynamic_prog.Subsequences;
import java.util.*;
public class subsets_with_sumK {
    public static void main(String[] args) {
        int target = 5;
        int[] nums = {1, 2, 3, 4, 5};
        int dp[][] = new int[nums.length][target+1];
        for (int[] row : dp) {Arrays.fill(row, -1);}
        tabular(nums,target);
//        System.out.println(subset(nums.length-1,nums,nums.length,target,dp));
    }

    private static void tabular(int[] nums,int target) {

        int[][] dp = new int[nums.length][target + 1];
        int n = nums.length;

        //base case target =0
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 1;
//        }
        if (nums[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;


        // base case index = 0
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int take = 0;
                if (nums[i] <= t) {
                    take = dp[i - 1][t - nums[i]];
                }
                int notTake = dp[i - 1][t];

                dp[i][t] = take + notTake;

            }
        }

        System.out.println(dp[n-1][target]);
    }

    private static int subset(int index,int nums[],int n,int target,int[][] dp){
        if(target == 0){
            return 1;
        }
        if(index==0){
            return target==nums[0] ? 1 : 0;
        }

        if(dp[index][target] !=-1){
            return dp[index][target];
        }
        int take = 0;
        if(target>=nums[index]){
            take = subset(index-1,nums,n,target-nums[index],dp);
        }

        int notTake = subset(index-1,nums,n,target,dp);
        dp[index][target] = take + notTake;
        return dp[index][target];

    }
}
