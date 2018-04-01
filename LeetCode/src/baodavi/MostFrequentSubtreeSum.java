package baodavi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	if(root == null){
    		return new int[0];
    	}
    	
        Map<Integer, Integer> sumCounts = new HashMap<>();
        findFrequentTreeSumHelper(root, sumCounts);
        
        List<Integer> resList = new ArrayList<>();
        int maxCnt =  Collections.max(sumCounts.values());
        for(int key : sumCounts.keySet()){
        	if(sumCounts.get(key) == maxCnt){
        		resList.add(key);
        	}
        }
        int[] res = new int[resList.size()];
        for(int i = 0; i < res.length; i++){
        	res[i] = resList.get(i);
        }
        return res;
    }
    
    private int findFrequentTreeSumHelper(TreeNode root, Map<Integer, Integer> sumCounts){
    	if(root == null){
    		return 0 ;
    	}
    	int leftSum = findFrequentTreeSumHelper(root.left, sumCounts);
    	int rightSum = findFrequentTreeSumHelper(root.right, sumCounts);
    	int currSum = leftSum + rightSum + root.val;
    	if(sumCounts.containsKey(currSum)){
    		sumCounts.put(currSum, sumCounts.get(currSum) + 1);
    	}else{
    		sumCounts.put(currSum, 1);
    	}
    	return currSum;
    }
}
