package Dynamic_prog.OneDimention;

import java.util.Arrays;

public class frogjumps {

    public static void main(String[] args) {
        // Define the heights array
        int[] height = {30, 10, 60, 10, 60, 50};

        // Compute and print the minimum energy
//        System.out.println(frogJump(height)); // Expected: 40

        System.out.println(frogJumps_K(height,2)); // Expected: 40
    }

    private static int frogJumps_K(int[] height,int k) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int ind = 1; ind < n; ind++) {
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(ind-j>=0){
                    min = Math.min(min,dp[ind - j] + Math.abs(height[ind] - height[ind - j]));
                }
            }
            dp[ind] = min;
        }

        return dp[n-1];

    }

    private static int frogJump(int[] height) {

        if (height == null || height.length == 0) return 0;

        int n = height.length;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int ind = 1; ind < n; ind++) {
            // Compute cost for a jump from ind-1
            int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);

            // Initialize jumpTwo with large value
            int jumpTwo = Integer.MAX_VALUE;

            // If possible, compute cost for a jump from ind-2
            if (ind > 1) {
                jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);
            }

            // Take the minimum of the two options
            dp[ind] = Math.min(jumpOne, jumpTwo);
        }

        // Return min energy to reach last stone
        return dp[n - 1];
    }
}
