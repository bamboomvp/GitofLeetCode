package baodavi;

//������⻹�и��ӣ��������k��ֵԶ����prices��������
//����k�Ǻü����򣬶�prices��������Ϊ������Ļ��������DP�ⷨ�ͷǳ���û��Ч�ʣ�
//Ӧ��ֱ����Best Time to Buy and Sell Stock II ���Ʊ�����ʱ��֮���ķ��������
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
