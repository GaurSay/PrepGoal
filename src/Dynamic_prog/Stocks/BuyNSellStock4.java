package Dynamic_prog.Stocks;

public class BuyNSellStock4 {


    public static void main(String[] args) {
        long[] prices = {7, 1, 5, 3, 6, 4};
        int k = 2;
        // in this K is variable that is it.
        System.out.println(findMaxProfit(0, 0, prices.length, prices, k));
        tabular(prices);
    }

    private static void tabular(long[] prices) {

        int n = prices.length;
        int k = 2;
        long dp[][][] = new long[n + 1][2][k+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int c = 1; c<=k; c++) {
                    if (j == 0) { // buy
                        dp[i][j][c] = Math.max((-prices[i] + dp[i + 1][1][c]), dp[i + 1][0][c]);
                    } else {
                        dp[i][j][c] = Math.max((prices[i] + dp[i + 1][0][c-1]), dp[i + 1][1][c]);
                    }
                }
            }
        }

        System.out.println(dp[0][0][2]);
    }


    private static long findMaxProfit(int index, int buy, int n, long[] prices, int k) {

        if (index == n || k==0) {
            return 0;
        }

        long profit = 0;
        if (buy == 0) {
            profit = Math.max((-prices[index] + findMaxProfit(index + 1, 1, n, prices, k)),
                    findMaxProfit(index + 1, 0, n, prices, k));
        } else {
            profit = Math.max((prices[index] + findMaxProfit(index + 1, 0, n, prices, k - 1)),
                    findMaxProfit(index + 1, 1, n, prices, k));
        }

        return profit;
    }
}
