package Dynamic_prog.Stocks;

public class BuyNSellStock2 {

    public static void main(String[] args) {
        long[] prices = {7, 1, 5, 3, 6, 4};

//        System.out.println(findMaxProfit(0,0,prices.length,prices));
        tabular(prices);
    }

    private static void tabular(long[] prices) {

        int n = prices.length;

        long dp[][] = new long[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){ // buy
                    dp[i][j] = Math.max((-prices[i] +  dp[i+1][1]), dp[i+1][0]);
                } else{
                    dp[i][j] = Math.max((prices[i] +  dp[i+1][0]), dp[i+1][1]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    private static long findMaxProfit(int index, int buy, int n, long[] prices) {

        if(index == n){
            return 0;
        }
        long profit = 0;
        if(buy==0){
            profit = Math.max((-prices[index] + findMaxProfit(index+1,1,n,prices)),
                    findMaxProfit(index + 1, 0, n, prices));
        } else{
            profit = Math.max((prices[index] + findMaxProfit(index+1,0,n,prices)),
                    findMaxProfit(index + 1, 1, n, prices));
        }

        return profit;
    }
}
