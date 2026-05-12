package Dynamic_prog.Subsequences;

public class subset_equal_subset_sum {

    public static void main(String[] args) {
        int target = 10;
        int[] nums = {2, 3, 3, 3, 4, 5};
        // find for sum/2
        tabular(nums,target/2);
    }

    private static void tabular(int nums[],int target){
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
        System.out.println(dp[n-1][target]);

    }
}
