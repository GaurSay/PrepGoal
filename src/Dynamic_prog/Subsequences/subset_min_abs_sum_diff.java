package Dynamic_prog.Subsequences;

public class subset_min_abs_sum_diff{
    public static void main(String[] args) {
        int totalSum = 0;
        int[] nums = {8, 6, 5};
        for(int i=0;i<nums.length;i++){
            totalSum+= nums[i];
        }
        tabular(nums,totalSum);
    }

    private static void tabular(int[] nums,int target){

        boolean[][] dp= new boolean[nums.length][target+1];
        int n = nums.length;

        //base case target =0
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

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

        // Initialize minimum difference to a large value
        int mini = Integer.MAX_VALUE;

        // Check all possible subset sums in last row of dp table
        for (int s1 = 0; s1 <= target; s1++) {
            if (dp[n - 1][s1]) {
                // Calculate other subset sum and difference
                int s2 = target - s1;
                int diff = Math.abs(s1 - s2);

                // Update minimum difference
                mini = Math.min(mini, diff);
            }
        }

        System.out.println(mini);

    }
}
