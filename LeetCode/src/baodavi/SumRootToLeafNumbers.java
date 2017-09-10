package baodavi;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public int sumNumbers(TreeNode root) {
    	return sumNumbersHelper(root, new ArrayList<Integer>());
    }
    
    private int sumNumbersHelper(TreeNode root, List<Integer> numList){
    	if(root == null)	return 0;
    	else{
    		int runningTotal = 0;
    		numList.add(root.val);
    		if(root.left == null && root.right == null){
    			runningTotal = getNumberHelper(numList);
    		}else{
    			runningTotal += sumNumbersHelper(root.left, numList);
    			runningTotal += sumNumbersHelper(root.right, numList);
    		}
    		numList.remove(numList.size() - 1);
    		return runningTotal;
    	}
    }
    
    private int getNumberHelper(List<Integer> numList){
    	int num = 0;
    	for(int digit : numList){
    		num *= 10;
    		num += digit;
    	}
    	return num;
    }
}
