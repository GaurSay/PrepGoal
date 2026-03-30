package Dynamic_prog.Strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcdeyha";
        String s2 = "aceywa";
        int m = s1.length();
        int n = s2.length();
        int dp[][]= new int[m][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
//        int ans = lcs_recursion(m - 1, n - 1, s1, s2, dp);
//        System.out.println(ans);
        tabular(s1,s2);


    }

    private static int lcs_recursion(int i, int j, String s1, String s2,int dp[][]) {
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j]=  1 + lcs_recursion(i-1,j-1,s1,s2,dp);
        }
        else{
            dp[i][j] =  Math.max(lcs_recursion(i-1,j,s1,s2,dp),lcs_recursion(i,j-1,s1,s2,dp));
        }

        return dp[i][j];

    }


    private static void tabular(String s1,String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp= new int[m+1][n+1];
        for(int i=0;i<=n;i++){
           dp[0][i] = 0;
        }

        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]=  1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[m][n]);

        int i=m;
        int j=n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] == dp[i][j]){
                i--;
            } else{
                j--;
            }
        }
        System.out.println(sb.reverse().toString());
    }


}
