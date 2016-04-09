package baodavi;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	/*
	buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。
	sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。
	buy[i]  = max(sell[i-2] - price[i], buy[i-1]) 
	sell[i] = max(buy[i-1] + price[i], sell[i-1])
	
	我们还可以做进一步优化，由于i只依赖于i-1和i-2，所以我们可以在O(1)的空间复杂度完成算法
	*/
	
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, pre_buy = 0;
        int sell = 0, pre_sell = 0;
        for(int price : prices){
        	pre_buy = buy;
        	buy = Math.max(pre_sell - price, pre_buy);
        	pre_sell = sell;
        	sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}
