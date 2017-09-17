package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> curr = new ArrayList<>();
    	if(nums == null || nums.length == 0)	return res;
    	
    	Arrays.sort(nums);
    	// iterate through subset starting from 1 to full-set...
    	for(int len = 1; len <= nums.length; len++){
    		dfs(nums, 0, len, curr, res);
    	}
    	res.add(new ArrayList<Integer>());
    	return res;
    }
    
    private void dfs(int[] nums, int start, int len, List<Integer> curr, List<List<Integer>> res){
    	if(curr.size() == len){
    		res.add(new ArrayList<Integer>(curr));
    		return;
    	}
    	for(int i = start; i < nums.length; i++){
    		curr.add(nums[i]);
    		dfs(nums, i + 1, len, curr, res);
    		curr.remove(curr.size() - 1);
    		// get rid of duplicates
    		while(i < nums.length - 1 && nums[i] == nums[i + 1])	
    			i++;
    	}
    }
}
