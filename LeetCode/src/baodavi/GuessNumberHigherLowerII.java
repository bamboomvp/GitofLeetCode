package baodavi;

public class GuessNumberHigherLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int len = 2; len <= n; len++){
        	for(int start = 1; start + len - 1 <= n; start++){
        		if(len == 2){
        			dp[start][start + len - 1] = start;
        		}else if(len == 3){
        			dp[start][start + len - 1] = start + 1;
        		}else{
        			dp[start][start + len - 1] = Integer.MAX_VALUE;
        			for(int k = start + 1; k < start + len - 1; k++){
        				int localMaxCost = k + Math.max(dp[start][k - 1], dp[k + 1][start + len - 1]);
        				dp[start][start + len - 1] = Math.min(dp[start][start + len - 1], localMaxCost);
        			}
        			dp[start][start + len - 1] = Math.min(dp[start][start + len - 1], start + dp[start + 1][start + len - 1]);
        			dp[start][start + len - 1] = Math.min(dp[start][start + len - 1], start + len - 1 + dp[start][start + len - 2]);
        		}
        	}
        }
        return dp[1][n];
    }
}
