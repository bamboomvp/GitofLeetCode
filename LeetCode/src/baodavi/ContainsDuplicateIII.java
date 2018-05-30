package baodavi;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	
	public boolean containsNearbyAlmostDuplicateUPDATE(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0 || k <= 0){
			return false;
		}
		
		final TreeSet<Long> values = new TreeSet<>();
		for(int ind = 0; ind < nums.length; ind++){
			Long ceiling = values.ceiling((long) nums[ind]);
			Long floor = values.floor((long) nums[ind]);
			if((ceiling != null && ceiling - nums[ind] <= t) || (floor != null && nums[ind] - floor <= t))
				return true;
			values.add((long) nums[ind]);
			if(ind >= k){
				values.remove((long) nums[ind - k]);
			}
		}
		return false;
	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++){
        	for(int j = i + 1; j - i <= k && j < nums.length; j++){
        		if((nums[i] >= 0 && nums[j] >= 0) || (nums[i] < 0 && nums[j] < 0)){
        			if(Math.abs(nums[i] - nums[j]) <= t)	return true;
        			else continue;
        		}else{
        			if(nums[i] >= 0){
        				if(t - nums[i] < 0)	continue;
        				else{
        					if(nums[i] - t > nums[j])	continue;
        					else	return true;
        				}
        			}else{ // nums[j] >= 0
        				if(t - nums[j] < 0)	continue;
        				else{
        					if(nums[j] - t > nums[i])	continue;
        					else	return true;
        				}
        			}
        		}
        	}
        }
        return false;
    }
}
