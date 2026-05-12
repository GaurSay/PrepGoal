package Dynamic_prog.Subsequences;

import java.util.Arrays;

public class subset_target {
    public static void main(String[] args) {
        int target = 12;
        int[] nums = {4, 3, 5, 2};
        int n = nums.length;
        int[][] dp= new int[nums.length][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        tabular(nums,target);
//        System.out.println(subset(nums.length-1,nums,nums.length,target,dp));
    }

    private static void tabular(int nums[],int target){
        boolean[][] dp= new boolean[nums.length][target+1];
        int n = nums.length;

        //base case target =0
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        //we can also write dp[0][0] = 1 ,
        // when array contains zeros then dp[0][0] = 1 doesnt work as it should be dp[0][0] = 2,

        // base case index = 0
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }

        for(int i=1;i<n;i++){
            for(int t=1;t<=target;t++){
                boolean take = false;
                if(nums[i]<=t){
                    take = dp[i-1][t-nums[i]];
                }
                boolean notTake = dp[i-1][t];

                dp[i][t] =  take || notTake;

            }
        }
        System.out.println(dp[n-1][target]);

    }

    private static boolean subset(int index,int nums[],int n,int target,int[][] dp){
        if(target == 0){
            return true;
        }
        if(index==0){
            return target==nums[0];
        }

        if(dp[index][target] !=-1){
            return dp[index][target]==1;
        }
        boolean take = false;
        if(target>=nums[index]){
            take = subset(index-1,nums,n,target-nums[index],dp);
        }

        boolean notTake = subset(index-1,nums,n,target,dp);
        dp[index][target] = (notTake|| take ) ? 1 : 0;
        return notTake|| take ;

    }
}
