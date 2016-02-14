package baodavi;
import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private Map<TreeNode, Integer> cache = new HashMap<TreeNode, Integer>();

	private int heightHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (cache.containsKey(root)) {
			return cache.get(root);
		}

		int height = Math
				.max(heightHelper(root.left), heightHelper(root.right)) + 1;
		cache.put(root, height);
		return height;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int heightLeft = heightHelper(root.left);
		int heightRight = heightHelper(root.right);
		if (Math.abs(heightRight - heightLeft) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
}
