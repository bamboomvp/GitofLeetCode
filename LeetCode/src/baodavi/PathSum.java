package baodavi;
public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean hasPathSumHelper(TreeNode root, int sum, int curr) {
		// leaf node
		if (root.left == null && root.right == null) {
			return sum == curr;
		}

		boolean left, right;
		if (root.left != null) {
			left = hasPathSumHelper(root.left, sum, curr + root.left.val);
		} else {
			left = false;
		}
		if (root.right != null) {
			right = hasPathSumHelper(root.right, sum, curr + root.right.val);
		} else {
			right = false;
		}

		return left || right;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		return hasPathSumHelper(root, sum, root.val);
	}
}
