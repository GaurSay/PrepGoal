package Dynamic_prog.Strings;

public class DistinctSubsequences {

    public static void main(String[] args) {
//        String s = "babgbag";
//        String t = "bag";
        String s = "axbxax";
        String t = "axa";
        System.out.println(tabular(s,t));
    }


    private static int tabular(String s1,String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        //if i==0 , return 0
        //if j==0 , return 1;
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
