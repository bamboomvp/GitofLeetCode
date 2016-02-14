package baodavi;
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		if (prices.length == 1) {
			return 0;
		}

		int profit = 0;
		int timing = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[timing] > 0) {
				profit += (prices[i] - prices[timing]);
				timing = i;
			}

			if (prices[i] < prices[timing]) {
				timing = i;
			}
		}

		return profit;
	}
}
