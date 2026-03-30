package Dynamic_prog.Strings;

public class MinInsertionsDeletionFromAtoB {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        //deletions - n -length(lcs)
        //insertions - m - length(lcs)
        // n+m - 2*length(lcs)

        int m = s1.length();
        int n = s2.length();
        System.out.println("Min Insertions From A to B : " + ((m+n)-(2*tabular(s1,s2))));
    }

    private static int tabular(String s1,String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int length = dp[m][n];
        return length;
    }
}
