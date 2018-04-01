package baodavi;

public class SumOfLeftLeaves {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
    public int sumOfLeftLeaves(TreeNode root) {
    	return sumOfLeftLeavesHelper(root, false);
    }
    
    private int sumOfLeftLeavesHelper(TreeNode root, boolean isLeft) {
    	if(root == null){
    		return 0;
    	}else if(root.left == null && root.right == null){
    		if(isLeft)	return root.val;
    		else	return 0;
    	}
    	return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }
}
