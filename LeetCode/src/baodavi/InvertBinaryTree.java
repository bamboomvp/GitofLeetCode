package baodavi;

public class InvertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    
	public TreeNode invertTree(TreeNode root) {
		invertTreeHelper(root);
		return root;
    }
    
	private void invertTreeHelper(TreeNode root){
		if(root == null)
			return;
		invertTreeHelper(root.left);
		invertTreeHelper(root.right);
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;
	}
}
