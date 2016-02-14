package baodavi;
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		if (prices.length == 1) {
			return 0;
		}

		int globalProfit, localProfit;
		int localBuy, localSell, localMin;

		globalProfit = localProfit = 0;
		localBuy = localSell = localMin = 0;

		for (int i = 1; i < prices.length; i++) {
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
}
