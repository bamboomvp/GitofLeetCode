package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class CombinationSumII {
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
    	
    	int limit = 0;
    	int hehe = index;
    	while(hehe != candidates.length){
    		if(candidates[hehe] == candidates[index])
    			limit++;
    		hehe++;
    	}
    	
    	for(int times = 0; (remaining - (candidates[index] * times) >= 0) && (times <= limit) ; times++){
    		for(int n = 0; n < times; n++){
    			tmp.add(candidates[index]);
    		}
    		combinationSumHelper(candidates, remaining - (candidates[index] * times), index+limit, tmp, res);
    		for(int n = 0; n < times; n++){
    			tmp.remove(tmp.size() - 1);
    		}    		
    	}
    }
}
