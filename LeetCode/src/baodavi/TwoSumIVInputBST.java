package baodavi;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputBST {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  
    public boolean findTarget(TreeNode root, int k) {
    	Set<Integer> set = new HashSet<>();
    	return findTargetHelper(root, k, set);
    }
    
    private boolean findTargetHelper(TreeNode root, int k, Set<Integer> set){
    	if(root == null)								return false;
    	else if(set.contains(k - root.val))		return true;
    	else{
    		set.add(root.val);
    		return findTargetHelper(root.left, k, set) || findTargetHelper(root.right, k, set);
    	}
    }
}
