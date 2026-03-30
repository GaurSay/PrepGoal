package Dynamic_prog.Strings;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        int m = s1.length();
        int n = s2.length();
        tabular(s1,s2);
    }



    private static void tabular(String s1,String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp= new int[m+1][n+1];
        int max = Integer.MIN_VALUE;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]=  1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);

//        int i=m;
//        int j=n;
//        StringBuilder sb = new StringBuilder();
//        while(i > 0 && j > 0){
//            if(s1.charAt(i-1) == s2.charAt(j-1)){
//                sb.append(s1.charAt(i-1));
//                i--;
//                j--;
//            }
//            else if(dp[i-1][j] == dp[i][j]){
//                i--;
//            } else{
//                j--;
//            }
//        }
//        System.out.println(sb.reverse().toString());
    }
}
