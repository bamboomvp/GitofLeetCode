package baodavi;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }else{
        	int[] dp = new int[nums.length];
        	Arrays.fill(dp, 1);
        	int max = dp[0];
        	for(int i = 0; i < dp.length; i++){
        		for(int j = 0; j < i; j++){
        			if(nums[j] < nums[i]){
        				dp[i] = Math.max(dp[i], dp[j] + 1);
        			}
        		}
        		if(dp[i] > max){
        			max = dp[i];
        		}
        	}
        	return max;
        }
    }
}
