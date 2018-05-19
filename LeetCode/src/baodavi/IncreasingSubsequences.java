package baodavi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> curr = new ArrayList<>();
    	Set<String> set = new HashSet<>();
    	findSubsequencesHelper(nums, Integer.MIN_VALUE, -1, set, curr, res);
    	return res;
    }
    
    private void findSubsequencesHelper(int[] nums, int prev, int prevIdx, Set<String> set, List<Integer> curr, List<List<Integer>> res){
    	if(curr.size() >= 2){
    		String strForm = list2StrUtil(curr);
    		if(!set.contains(strForm)){
    			res.add(new ArrayList<>(curr));
    			set.add(strForm);
    		}
    	}
    	for(int i = prevIdx + 1; i < nums.length; i++){
    		if(nums[i] >= prev){
    			curr.add(nums[i]);
    			findSubsequencesHelper(nums, nums[i], i, set, curr, res);
    			curr.remove(curr.size() - 1);
    		}
    	}
    }
    
    private String list2StrUtil(List<Integer> curr){
    	String str ="";
    	for(int x : curr){
    		str += String.valueOf(x) + ",";
    	}
    	return str.substring(0, str.length() - 1);
    }
}
