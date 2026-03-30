package Dynamic_prog.Strings;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s1 = "groot";
        String s2 = "brute";

        tabular(s1,s2);
    }


    private static void tabular(String s1,String s2) {
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
        System.out.println(length);

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
                sb.append(s1.charAt(i-1));
                i--;
            } else{
                sb.append(s2.charAt(j-1));
                j--;
            }
        }
        if(i==0){
            sb.append(s2.charAt(0));
        }
        else{
            sb.append(s1.charAt(0));
        }
        System.out.println(sb.reverse().toString());
    }
}
