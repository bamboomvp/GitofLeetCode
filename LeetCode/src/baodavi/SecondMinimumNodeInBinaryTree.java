package baodavi;

public class SecondMinimumNodeInBinaryTree {
//	
//	class Solution {
//	    int min1;
//	    long ans = Long.MAX_VALUE;
//
//	    public void dfs(TreeNode root) {
//	        if (root != null) {
//	            if (min1 < root.val && root.val < ans) {
//	                ans = root.val;
//	            } else if (min1 == root.val) {
//	                dfs(root.left);
//	                dfs(root.right);
//	            }
//	        }
//	    }
//	    public int findSecondMinimumValue(TreeNode root) {
//	        min1 = root.val;
//	        dfs(root);
//	        return ans < Long.MAX_VALUE ? (int) ans : -1;
//	    }
//	}
//	
	
	
	
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
        	return -1;
        }else{
        	return findSecondMinimumValueHelper(root);
        }
    }
    
    private int findSecondMinimumValueHelper(TreeNode curr){
    	if(curr.left == null && curr.right == null){
    		return -1;
    	}else{
    		int opt1, opt2;
    		if(curr.left.val != curr.right.val){
    			opt1 = (curr.left.val < curr.right.val) ? curr.right.val : curr.left.val;
    			opt2 = (curr.left.val < curr.right.val) ? findSecondMinimumValueHelper(curr.left) : findSecondMinimumValueHelper(curr.right);
    		}else{
    			opt1 = findSecondMinimumValueHelper(curr.left);
    			opt2 = findSecondMinimumValueHelper(curr.right);
    		}
    		if(opt1 == -1 && opt2 == -1)		return -1;
    		else if(opt1 == -1)					return opt2;
    		else if(opt2 == -1)					return opt1;
    		else										return (opt1 < opt2) ? opt1 : opt2;
    	}
    }
}
