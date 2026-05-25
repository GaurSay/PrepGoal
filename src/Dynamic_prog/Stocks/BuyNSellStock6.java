package Dynamic_prog.Stocks;

public class BuyNSellStock6 {

    public static void main(String[] args) {
        long[] prices = {7, 1, 5, 3, 6, 4};
        int fees = 2;
        // in this only we have to reduce the fees when the transaction is done !!
        System.out.println(findMaxProfit(0,0,prices.length,prices,fees));
        tabular(prices,fees);
    }

    private static void tabular(long[] prices,int fees) {

        int n = prices.length;

        long dp[][] = new long[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){ // buy
                    dp[i][j] = Math.max((-prices[i] +  dp[i+1][1]), dp[i+1][0]);
                } else{
                    dp[i][j] = Math.max((prices[i] - fees +  dp[i+1][0]), dp[i+1][1]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    private static long findMaxProfit(int index, int buy, int n, long[] prices,int fees) {

        if(index == n){
            return 0;
        }
        long profit = 0;
        if(buy==0){
            profit = Math.max((-prices[index] + findMaxProfit(index+1,1,n,prices,fees)),
                    findMaxProfit(index + 1, 0, n, prices,fees));
        } else{
            profit = Math.max((prices[index] -fees + findMaxProfit(index+1,0,n,prices,fees)),
                    findMaxProfit(index + 1, 1, n, prices,fees));
        }

        return profit;
    }
}
