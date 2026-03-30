package Dynamic_prog.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSubset {

    public static void main(String[] args) {
        int nums[] = {1, 16,7,8,4};

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.sort(nums);
        int[] hash = new int[n];
        int lastIndex = 0;
        int max = 0;

        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev=0;prev<i;prev++){
                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]){
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
