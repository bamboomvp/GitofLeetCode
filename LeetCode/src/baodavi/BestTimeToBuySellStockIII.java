package baodavi;

public class BestTimeToBuySellStockIII {
	public int maxProfit(int[] prices) {
		// maxProfit1[i] - the sell can be at most ith day
		int[] maxProfit1 = new int[prices.length];
		int minBuy = 0;
		for(int i = 1; i < maxProfit1.length; i++){
			maxProfit1[i] = Math.max(maxProfit1[i - 1], prices[i] - prices[minBuy]);
			minBuy = (prices[i] < prices[minBuy]) ? i : minBuy;
		}
		// maxProfit2[j] - the buy should be at least the jth day 
		int[] maxProfit2 = new int[prices.length];
		int maxSell = maxProfit2.length - 1;
		for(int j = maxProfit2.length - 2; j >= 0; j--){
			maxProfit2[j] = Math.max(maxProfit2[j + 1], prices[maxSell] - prices[j]);
			maxSell = (prices[j] > prices[maxSell]) ? j : maxSell;
		}
		
		int globalProfit = 0;
		for(int k = 0; k < prices.length; k++){
			int localProfit = maxProfit1[k] + maxProfit2[k];
			globalProfit = Math.max(globalProfit, localProfit);
		}
		return globalProfit;
	}
}
