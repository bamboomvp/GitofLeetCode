package baodavi;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

public class CoinChange {
	
	// too bad, brute-force recursion is dead!!!
	
//	private static int globalMin = Integer.MAX_VALUE;
//	
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        if(coinChangeHelper(coins, coins.length - 1, amount, 0)){
//        	return globalMin;
//        }else{
//        	return -1;
//        }
//    }
//    
//    private boolean coinChangeHelper(int[] coins, int currFaceIdx, int remaining, int localCnt){
//    	if(remaining == 0){
//    		if(localCnt < globalMin){
//    			globalMin = localCnt;
//    		}
//    		return true;
//    	}else if(currFaceIdx < 0){
//    		return false;
//    	}
//    	
//    	int maxNumForCurrFace = 0;
//    	int runningTotal = 0;
//    	while(runningTotal <= remaining){
//    		runningTotal += coins[currFaceIdx];
//    		maxNumForCurrFace++;
//    	}
//    	maxNumForCurrFace--;
//    	
//    	boolean flag = false;
//    	for(int k = maxNumForCurrFace; k >= 0; k--){
//    		if(coinChangeHelper(coins, currFaceIdx - 1, remaining - (k * coins[currFaceIdx]), localCnt + k)){
//    			flag = true;
//    		}
//    	}
//    	
//    	return flag;
//    }
	
	/*
	主要考虑动态规划Dynamic Programming来做，我们维护一个一维动态数组dp，其中dp[i]表示钱数为i时的最小硬币数的找零，递推式为：

	dp[i] = min(dp[i], dp[i - coins[j]] + 1);
	
	其中coins[j]为第j个硬币，而i - coins[j]为钱数i减去其中一个硬币的值，剩余的钱数在dp数组中找到值，然后加1和当前dp数组中的值做比较，取较小的那个更新dp数组。
	*/
	
	// Non-recursion
	public int coinChange1(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		
		for(int i = 1; i <= amount; i++){
			for(int j = 0; j < coins.length; j++){
				if(coins[j] <= i){
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
	// Recursion
	public int coinChange2(int[] coins, int amount) {
		int[] caching = new int[amount + 1];
		Arrays.fill(caching, Integer.MAX_VALUE);
		caching[0] = 0;
		return coinChangeDFS(coins, amount, caching);
	}
	
	private int coinChangeDFS(int[] coins, int amount, int[] caching){
		
		if(amount < 0)
			return -1;
		if(caching[amount] != Integer.MAX_VALUE)
			return caching[amount];
		
		for(int i = 0; i < coins.length; i++){
			int tmpRes = coinChangeDFS(coins, amount - coins[i], caching);
			if(tmpRes >= 0){
				caching[amount] = Math.min(caching[amount], tmpRes + 1);
			}
		}
		
		return caching[amount] = caching[amount] == Integer.MAX_VALUE ? -1 : caching[amount];
	}
	
}
