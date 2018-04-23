package baodavi;

public class BestTimeToBuySellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
        // optimize the space
    	int sold = 0, hold = -prices[0];
    	for(int i = 1; i < prices.length; i++){
    		int tmp = sold;
    		sold = Math.max(sold, hold + prices[i] - fee);
    		hold = Math.max(hold, tmp - prices[i]);
    	}
    	return sold;
    }
}
