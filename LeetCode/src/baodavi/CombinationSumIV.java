package baodavi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    public int combinationSum4Memorization(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> cache = new HashMap<>();
        return combinationSum4MemorizationHelper(nums, target, cache);
    }
    
    private int combinationSum4MemorizationHelper(int[] nums, int target, Map<Integer, Integer> cache){
    	if(target == 0)	return 1;
    	
    	if(cache.containsKey(target)){
    		return cache.get(target);
    	}else{
    		int cnt = 0;
    		for(int i = 0; i < nums.length; i++){
    			if(target - nums[i] >= 0){
    				cnt += combinationSum4MemorizationHelper(nums, target - nums[i], cache);
    			}else{
    				break;
    			}
    		}
    		cache.put(target, cnt);
    		return cnt;
    	}
    }
    
    public int combinationSum4DP(int[] nums, int target) {
    	// dp[i] = dp[target - nums[1]] + dp[target - nums[2]] + ...
    	Arrays.sort(nums);
    	int[] dp = new int[target + 1];
    	dp[0] = 1;
    	for(int i = 1; i <= target; i++){
    		for(int j = 0; j < nums.length; j++){
    			if(i - nums[j] >= 0){
    				dp[i] += dp[i - nums[j]];
    			}else{
    				break;
    			}
    		}
    	}
    	return dp[target];
    }
}
