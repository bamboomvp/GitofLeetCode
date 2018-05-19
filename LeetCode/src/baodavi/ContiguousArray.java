package baodavi;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
    	// key - subarray sum
    	// val - ending index
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i] == 1 ? 1 : -1;
        	if(map.containsKey(sum)){
        		maxLen = Math.max(maxLen, i - map.get(sum));
        	}else{
        		map.put(sum, i);
        	}
        }
        return maxLen;
    }
}
