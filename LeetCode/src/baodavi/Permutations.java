package baodavi;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // backtracking
    	ArrayList<List<Integer>> res = new ArrayList<>();
    	
    	if(nums == null || nums.length == 0){
    		ArrayList<Integer> tmp = new ArrayList<>();
    		res.add(tmp);
    		return res;
    	}
    	
    	permuteHelper(0, nums, res);
    	return res;
    }
    
    private void permuteHelper(int i, int[] nums, ArrayList<List<Integer>> res){
    	if(i == nums.length){
    		ArrayList<Integer> tmp = new ArrayList<>();
    		for(int j = 0; j < nums.length; j++){
    			tmp.add(nums[j]);
    		}
    		res.add(tmp);
    		return;
    	}
    	
    	for(int j = i; j < nums.length; j++){
    		swap(i, j, nums);
    		permuteHelper(i + 1, nums, res);
    		swap(i, j, nums);
    	}
    }
    
    private void swap(int i, int j, int[] nums){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
