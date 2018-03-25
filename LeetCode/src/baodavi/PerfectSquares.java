package baodavi;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
//    	如果一个数x可以表示为一个任意数a加上一个平方数bｘb，
//    	也就是x=a+bｘb，那么能组成这个数x最少的平方数个数，
//    	就是能组成a最少的平方数个数加上1（因为b*b已经是平方数了）。
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i = 1; i * i <= n; i++){
    		dp[i * i] = 1;
    	}
    	for(int a = 0; a <= n; a++){
    		for(int b = 1; a + b * b <= n; b++){
    			dp[a  + b * b] = Math.min(dp[a] + 1, dp[a  + b * b]);
    		}
    	}
    	return dp[n];
    }
}
