package baodavi;

public class MinimumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    public int minDepth(TreeNode root) {
        if(root == null)	return 0;
        else if(root.left == null && root.right == null)	return 1;
        else{
        	int leftDepth = minDepth(root.left);
        	int rightDepth = minDepth(root.right);
        	int deltaDepth;
        	if(leftDepth == 0)	deltaDepth = rightDepth;
        	else if(rightDepth == 0)	deltaDepth = leftDepth;
        	else	deltaDepth = Math.min(leftDepth, rightDepth);
        	return deltaDepth + 1;
        }
    }
}
