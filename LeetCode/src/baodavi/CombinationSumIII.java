package baodavi;

import java.util.ArrayList;
import java.util.List;

// each combination should be a unique set of numbers. - VERY IMPORTANT
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3Helper(0, k, n, nums, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void combinationSum3Helper(int start, int count, int target, int[] nums, List<Integer> candidate, List<List<Integer>> res){
    	// base cases...
    	if(target == 0 && count == 0){
    		res.add(new ArrayList<>(candidate));
    		return;
    	}else if(count <= 0){
    		return;
    	}
    	
    	for(int i = start; i < nums.length; i++){
    		if(target - nums[i] >= 0){ // if we can pick
	    		candidate.add(nums[i]); // if we pick nums[i]...
	    		combinationSum3Helper(i + 1, count - 1, target - nums[i], nums, candidate, res);
	    		candidate.remove(candidate.size() - 1);
    		}else{
    			break; // pruning
    		}
    	}
    }
}
