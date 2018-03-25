package baodavi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BurstBalloons {
	
	public int maxCoinsDP(int[] nums) {
		int n = nums.length;
		int[] numsPadding = new int[n + 2]; // padding, balloon - 1 and balloon n
		numsPadding[0] = 1;
		numsPadding[n + 1] = 1;
		for(int i = 1; i <= n; i++)	numsPadding[i] = nums[i - 1];
		
		int[][] dp = new int[n + 2][n + 2];
		for(int l = 1; l <= n; l++){
			for(int i = 1; i <= n - l + 1; i++){
				int j = i + l - 1;
				for(int k = i; k <= j; k++){
					dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] +
							numsPadding[i - 1]*numsPadding[k]*numsPadding[j + 1] + 
							dp[k + 1][j]);
				}
			}
		}
		return dp[1][n];
	}
	
	// recursion... Time Limit Exceeded...
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }else if(nums.length == 1){
        	return nums[0];
        }else if(nums.length == 2){
        	return (nums[0] * nums[1]) + (nums[0] < nums[1] ? nums[1] : nums[0]);
        }else{
        	Map<String, Integer> cache = new HashMap<>();
        	List<Integer> numsInList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        	return maxCoinsHelper(numsInList, cache);
        }
    }
    
    private int maxCoinsHelper(List<Integer> nums, Map<String, Integer> cache){
    	String key = nums.toString();
    	if(cache.containsKey(key)){
    		return cache.get(key);
    	}else{
    		int subMax = 0;
    		if(nums.size() == 3){
    			// base case
    			subMax += nums.get(0) * nums.get(1) * nums.get(2);
    			subMax += nums.get(0) * nums.get(2);
    			subMax += nums.get(0) < nums.get(2) ?  nums.get(2) : nums.get(0);
    		}else{
	    		for(int index = 0; index < nums.size(); index++){
	    			int subMaxLocal1, subMaxLocal2;
	    			subMaxLocal1 = nums.get(index);
	    			if(index != 0)	subMaxLocal1 *= nums.get(index - 1);
	    			if(index != nums.size() - 1)	subMaxLocal1 *= nums.get(index + 1);
	    			int hold = nums.remove(index);
	    			subMaxLocal2 = maxCoinsHelper(nums, cache);
	    			nums.add(index, hold);
	    			if(subMaxLocal1 + subMaxLocal2 > subMax){
	    				subMax = subMaxLocal1 + subMaxLocal2;
	    			}
	    		}
    		}
    		cache.put(key, subMax);
    		return subMax;
    	}
    }
}
