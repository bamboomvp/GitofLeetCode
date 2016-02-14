package baodavi;
public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class MaxValObj {
		int maxVal;

		MaxValObj(int val) {
			this.maxVal = val;
		}

		public int getter() {
			return this.maxVal;
		}

		public void setter(int val) {
			this.maxVal = val;
		}
	}

	private int maxPathSumHelper(TreeNode root, MaxValObj localMax) {
		if (root == null) {
			return 0;
		}

		int maxLeft = maxPathSumHelper(root.left, localMax);
		int maxRight = maxPathSumHelper(root.right, localMax);
		int curr = root.val + Math.max(maxLeft, 0) + Math.max(maxRight, 0);
		if (curr > localMax.getter()) {
			localMax.setter(curr);
		}
		return root.val + Math.max(Math.max(maxLeft, maxRight), 0);
	}

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		MaxValObj maxVal = new MaxValObj(Integer.MIN_VALUE);
		maxPathSumHelper(root, maxVal);
		return maxVal.getter();
	}
}
