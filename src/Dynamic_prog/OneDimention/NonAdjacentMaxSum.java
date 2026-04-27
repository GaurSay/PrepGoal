package Dynamic_prog.OneDimention;

import java.util.Arrays;

public class NonAdjacentMaxSum {

    public static void main(String[] args) {
       int arr[] =  {1, 2, 4};
       int arr1[] = {2, 1, 4, 9};

        System.out.println(maxSum(arr1,arr1.length-1));
        maxSumDP(arr1);
    }

    public static void maxSumDP(int num[]){
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

        System.out.println(dp[n]);

    }



    public static int maxSum(int num[],int i){
        if(i==0){
            return num[0];
        }
        if(i<0){
            return 0;
        }

        int take = num[i] + maxSum(num, i - 2);
        int notTake = maxSum(num,i-1);

        return Math.max(take,notTake);

    }
}
