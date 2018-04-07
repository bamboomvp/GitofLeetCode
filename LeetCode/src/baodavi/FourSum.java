package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums == null || nums.length == 0){
    		return res;
    	}
    	Arrays.sort(nums);
    	for(int i = nums.length - 1; i > 2; i--){
    		if(i == nums.length - 1 || nums[i] != nums[i + 1]){
    			List<List<Integer>> resThreeSum = threeSum(nums, i - 1, target - nums[i]);
    			for(int j = 0; j < resThreeSum.size(); j++){
    				resThreeSum.get(j).add(nums[i]);
    			}
    			res.addAll(resThreeSum);
    		}
    	}
    	return res;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int end, int target){
    	List<List<Integer>> res = new ArrayList<>();
    	for(int i = end; i > 1; i--){
    		if(i == end || nums[i] != nums[i + 1]){
    			List<List<Integer>> resTwoSum = twoSum(nums, i - 1, target - nums[i]);
    			for(int j = 0; j < resTwoSum.size(); j++){
    				resTwoSum.get(j).add(nums[i]);
    			}
    			res.addAll(resTwoSum);
    		}
    	}
    	return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int end, int target){
    	List<List<Integer>> res = new ArrayList<>();
    	int p1 = 0;
    	int p2 = end;
    	while(p1 < p2){
    		if(nums[p1] + nums[p2] == target){
    			List<Integer> combo = new ArrayList<>();
    			combo.add(nums[p1]);
    			combo.add(nums[p2]);
    			res.add(combo);
    			p1++;
    			p2--;
    			// skip possible duplicates...
    			while(p1 < p2 && nums[p1] == nums[p1-1])		p1++;
    			while(p1 < p2 && nums[p2] == nums[p2+1])	p2--;
    		}else if(nums[p1] + nums[p2] > target){
    			p2--;
    		}else{
    			p1++;
    		}
    	}
    	return res;
    }
}
