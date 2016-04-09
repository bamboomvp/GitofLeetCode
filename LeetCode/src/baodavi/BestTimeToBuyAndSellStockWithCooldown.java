package baodavi;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	/*
	buy[i]��ʾ�ڵ�i��֮ǰ���һ���������򣬴�ʱ��������档
	sell[i]��ʾ�ڵ�i��֮ǰ���һ��������������ʱ��������档
	buy[i]  = max(sell[i-2] - price[i], buy[i-1]) 
	sell[i] = max(buy[i-1] + price[i], sell[i-1])
	
	���ǻ���������һ���Ż�������iֻ������i-1��i-2���������ǿ�����O(1)�Ŀռ临�Ӷ�����㷨
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
