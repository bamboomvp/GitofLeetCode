package baodavi;

public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 != null && root2 != null) {
			if (root1.val != root2.val) {
				return false;
			}
			return isSymmetricHelper(root1.left, root2.right)
					&& isSymmetricHelper(root1.right, root2.left);
		} else {
			return false;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricHelper(root.left, root.right);
	}
}
