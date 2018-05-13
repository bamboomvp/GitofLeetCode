package baodavi;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int idx = 0; idx < nums.length; idx++){
        	if(!map.containsKey(nums[idx])){
        		map.put(nums[idx], idx);
        	}else{
        		if(idx - map.get(nums[idx]) <= k)	return true;
        		else	map.put(nums[idx], idx);
        	}
        }
        return false;
    }
}
