package Dynamic_prog.TwoDimention;

import java.util.Arrays;

public class NinjaTechnique {

    public static void main(String[] args) {
       int points[][] =  {{10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}};

       int n = points.length;
       training(points,n);
       tabular(points,n);
    }

    private static void tabular(int[][] points, int n) {

        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));


        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task!= last) {
                        int activity = points[day][task] + dp[day-1][task];
                        dp[day][last]= Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        System.out.println(dp[n-1][3]);
    }



    private static int fun(int[][] points, int day,int last, int dp[][]) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;

            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }

            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + fun(points, day - 1, i, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

        private static void training(int[][] points, int n) {

            int[][] dp = new int[n][4];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            System.out.println(fun(points,n-1,3,dp));
        }


}
