package baodavi;
public class BestTimetoBuyandSellStockIII {

	public int maxProfitHelper(int[] prices, int low, int high) {

		if (low == high) {
			return 0;
		}

		int globalProfit, localProfit;
		int localBuy, localSell, localMin;

		globalProfit = localProfit = prices[low];
		localBuy = localSell = localMin = low;

		for (int i = low + 1; i <= high; i++) {
			if (prices[i] - prices[localMin] > localProfit) {
				localBuy = localMin;
				localSell = i;
				localProfit = prices[localSell] - prices[localBuy];
				globalProfit = Math.max(globalProfit, localProfit);
			}

			if (prices[i] < prices[localMin]) {
				localMin = i;
			}
		}

		return globalProfit;
	}

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		if (prices.length == 1) {
			return 0;
		}

		int globalMax = 0;
		for (int i = 0; i < prices.length; i++) {
			int profitOne = maxProfitHelper(prices, 0, i);
			int profitTwo = maxProfitHelper(prices, i, prices.length - 1);

			globalMax = Math.max(profitOne, profitTwo);
		}

		return globalMax;
	}
}
