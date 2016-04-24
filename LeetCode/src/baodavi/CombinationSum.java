package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]
*/ 

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(candidates);
    	combinationSumHelper(candidates, target, 0, new ArrayList<Integer>(), res);
    	return res;
    }
    
    private void combinationSumHelper(int[] candidates, int remaining, int index, List<Integer> tmp, List<List<Integer>> res){
    	if(remaining == 0){
    		res.add(new ArrayList<Integer>(tmp));
    		return;
    	}
    	
    	if(index == candidates.length){
    		return;
    	}
    	
    	for(int times = 0; remaining - (candidates[index] * times) >= 0; times++){
    		for(int n = 0; n < times; n++){
    			tmp.add(candidates[index]);
    		}
    		combinationSumHelper(candidates, remaining - (candidates[index] * times), index+1, tmp, res);
    		for(int n = 0; n < times; n++){
    			tmp.remove(tmp.size() - 1);
    		}    		
    	}
    }
    
    public static void main(String args[]){
    	new CombinationSum().combinationSum(new int[]{1}, 1);
    }
}
