package baodavi;

public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	// Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)	return true;
        else if(p != null && q != null && p.val == q.val){
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else	return false;
    }
}
