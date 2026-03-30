package Dynamic_prog.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequencePrint {

    public static void main(String[] args) {
//        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int nums[] = {1,7,8,4,5,6,-1,9};
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        newtabular(nums,nums.length);
    }

    private static void newtabular(int[] nums, int length) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp,1);
        int lis = 1;

        int lastIndex = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev=0;prev<i;prev++){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

            if(dp[i]>max){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();


        ans.add(nums[lastIndex]);
//        System.out.print("debug " + nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
          lastIndex = hash[lastIndex];
          ans.add(nums[lastIndex]);
        }


        for(int i =ans.size()-1;i>=0;i--){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
