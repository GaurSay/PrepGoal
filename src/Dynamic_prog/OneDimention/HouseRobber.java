package Dynamic_prog.OneDimention;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 9 };

        int[] sub1 = Arrays.copyOfRange(arr, 0, arr.length-1);
        int[] sub2 = Arrays.copyOfRange(arr, 1, arr.length);
        System.out.println(Math.max(maxSumDP(sub1),maxSumDP(sub2)));
    }

    public static int maxSumDP(int num[]){
        int n = num.length;
        int dp[] = new int[num.length+1];

        Arrays.fill(dp,-1);

        dp[0] = 0;
        dp[1] = num[0];

        for(int i=2;i<dp.length;i++){
            int take = num[i-1] + dp[i-2];
            int nottake = dp[i-1];
            dp[i] = Math.max(take,nottake);
        }

        return dp[n];

    }
}
