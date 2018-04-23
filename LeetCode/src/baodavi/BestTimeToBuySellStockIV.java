package baodavi;

//但这道题还有个坑，就是如果k的值远大于prices的天数，
//比如k是好几百万，而prices的天数就为若干天的话，上面的DP解法就非常的没有效率，
//应该直接用Best Time to Buy and Sell Stock II 买股票的最佳时间之二的方法来求解
public class BestTimeToBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
        	return 0;
        }
        if(k >= prices.length){
        	return reducedMaxProfit(prices);
        }
        
        int len = prices.length;
        // state and init
        int[][] global = new int[len][k + 1];
        int[][] local = new int[len][k + 1];
        // func
        for(int day = 1; day < len; day++){
        	int diff = prices[day] - prices[day - 1];
        	for(int trans = 1; trans < k + 1; trans++){
        		local[day][trans] = Math.max(global[day - 1][trans - 1] + Math.max(diff, 0), 
        									local[day - 1][trans] + diff);
        		global[day][trans] = Math.max(global[day - 1][trans], local[day][trans]);
        	}
        }
        // answer
        return global[len - 1][k];        
    }
    
    private int reducedMaxProfit(int[] prices){
    	int res = 0; 
    	for(int i = 1; i < prices.length; i++){
    		if(prices[i] - prices[i - 1] > 0){
    			res += prices[i] - prices[i - 1];
    		}
    	}
    	return res;
    }
}
