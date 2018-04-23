package baodavi;

// **********************
public class PredictTheWinner {
    public boolean PredictTheWinnerFunc(int[] nums) {
        int[][] rangeSum = new int[nums.length][nums.length];
        int[][] maxScore = new int[nums.length][nums.length];
        for(int len = 1; len <= nums.length; len++){
        	for(int start = 0; start + len - 1 < nums.length; start++){
        		if(len == 1)				rangeSum[start][start + len - 1] = nums[start];
        		else						rangeSum[start][start + len - 1] = nums[start] + rangeSum[start + 1][start + len - 1];
        	}
        	for(int start = 0; start + len - 1 < nums.length; start++){
        		if(len == 1)				maxScore[start][start + len - 1] = nums[start];
        		else{
        			// get the front-end
        			int candidate1 = nums[start] + (rangeSum[start + 1][start + len - 1] - maxScore[start + 1][start + len - 1]);
        			// get the tail value
        			int candidate2 = nums[start + len - 1] + (rangeSum[start][start + len - 2] - maxScore[start][start + len - 2]);
        			maxScore[start][start + len - 1] = Math.max(candidate1, candidate2);
        		}
        	}
        }
        return maxScore[0][nums.length - 1] * 2 >= rangeSum[0][nums.length - 1];
    }
    
    public boolean PredictTheWinnerFunc2(int[] nums) {
    	int n = nums.length;
    	int[][] dp = new int[n][n];
    	for(int i = 0; i < n; i++){
    		for(int j = 0; j < n; j++){
    			dp[i][j] = -1;
    		}
    	}
    	return canWinHelper(nums, 0, n - 1, dp) >= 0;
    }
    
    private int canWinHelper(int[] nums, int start, int end, int[][] dp){
    	if(dp[start][end] == -1){
    		if(start == end){
    			dp[start][end] = nums[start];
    		}else{
    			dp[start][end] = Math.max(nums[start] - canWinHelper(nums, start + 1, end, dp), 
    													nums[end] - canWinHelper(nums, start, end - 1, dp));
    		}
    	}
    	return dp[start][end];
    }
}
