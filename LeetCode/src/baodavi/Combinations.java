package baodavi;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<>();
    	
    	if(n <= 0 || k <= 0 || n < k){
    		return res;
    	}else{
    		List<Integer> elem = new ArrayList<>();
    		combineHelper(n, k, 1, elem, res);
    	}
    	
    	return res;
    }
    
    private void combineHelper(int n, int k, int start, List<Integer> elem, List<List<Integer>> res){
    	if(elem.size() == k){
    		res.add(new ArrayList<>(elem));
    		return;
    	}
    	
    	if(k - elem.size() > (n - start + 1))
    		return; // short cut!
    	
    	for(int i = start; i <= n; i++){
			elem.add(i);
			combineHelper(n, k, i + 1, elem, res);
			elem.remove(elem.size() - 1);
    	}
    }
}
