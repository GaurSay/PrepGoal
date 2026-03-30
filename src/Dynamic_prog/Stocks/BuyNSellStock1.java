package Dynamic_prog.Stocks;

public class BuyNSellStock1 {

    public static void main(String[] args) {
        long[] prices = {7, 1, 5, 3, 6, 4};


        long maxProfit = 0;
        long mini = prices[0];

        for(int i=1;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,prices[i]-mini);
            mini = Math.min(prices[i],mini);
        }

        System.out.println(maxProfit);
    }
}
