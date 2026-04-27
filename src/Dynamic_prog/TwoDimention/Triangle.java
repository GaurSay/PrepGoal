package Dynamic_prog.TwoDimention;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(3, 6, 7));
        triangle.add(Arrays.asList(8, 9, 6, 10));
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(minimumPathSum(triangle));
        System.out.println(func(0,0,triangle,dp));
    }

    private static int func(int i, int j,List<List<Integer>> triangle,int dp[][]) {
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        dp[i][j] =  triangle.get(i).get(j)
                + Math.min(func(i+1,j,triangle,dp),func(i+1,j+1,triangle,dp));
        return dp[i][j];

    }

    private static int minimumPathSum(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[triangle.size()][n];

        for(int i= 0;i<n;i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d = dp[i+1][j] +  triangle.get(i).get(j);
                int dg = dp[i+1][j+1] + triangle.get(i).get(j);
                dp[i][j] = Math.min(d,dg);
            }
        }

        return dp[0][0];

    }
}
