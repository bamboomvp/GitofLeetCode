package baodavi;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        boolean[][] dp = new boolean[nums.length][nums.length];
        for(int len = 1; len <= nums.length; len++){
        	for(int start = 0; start + len - 1 < nums.length; start++){
        		if(len == 1){
        			dp[start][start] = true;
        		}else if(len == 2){
        			dp[start][start + 1] = true;
        		}else{
//        			if()
        		}
        	}
        }
    }
}
