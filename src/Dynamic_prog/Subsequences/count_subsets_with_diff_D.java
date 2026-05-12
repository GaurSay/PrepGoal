package Dynamic_prog.Subsequences;

import java.util.Arrays;

public class count_subsets_with_diff_D {


    public static void main(String[] args) {
     /*   s1-s2 = D
        totalSum - s1 = s2
        totalSum - 2s2 = D
        (totalSum -D )/ 2 = s2

       */
        int diff = 1;
        int[] nums = {1, 1, 2, 3};

        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        if ((totalSum + diff) % 2 != 0 || diff > totalSum) System.out.println(0);

        int s2 = (totalSum- diff) /2;
        int dp[][] = new int[nums.length][s2+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);}

        tabular(nums,s2);




    }

    private static void tabular(int[] nums,int target) {

        int[][] dp = new int[nums.length][target + 1];
        int n = nums.length;

        //base case target =0
        dp[0][0] = 1;


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
}
