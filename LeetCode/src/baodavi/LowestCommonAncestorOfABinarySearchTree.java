package baodavi;
public class LowestCommonAncestorOfABinarySearchTree {
	
	// lowest common ancestor (LCA) of two given nodes in the BST.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
        	return root;
        if((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
        	return root;
        if(root.val > p.val && root.val > q.val)
        	return lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val)
        	return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}
