package baodavi;
public class ValidateBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private class Pair {
		public boolean check;
		public Integer min;
		public Integer max;

		public Pair(boolean check, Integer min, Integer max) {
			super();
			this.check = check;
			this.min = min;
			this.max = max;
		}
	}

	private Integer checkNull(Integer val, Integer defaultVal) {
		if (val == null)
			return defaultVal;
		else
			return val;
	}

	private boolean checkLHelper(Integer max, Integer val) {
		if (max == null)
			return true;
		else {
			return max < val;
		}
	}

	private boolean checkRHelper(Integer min, Integer val) {
		if (min == null)
			return true;
		else {
			return min > val;
		}
	}

	private Pair isValidBSTHelper(TreeNode root) {
		if (root == null) {
			return new Pair(true, null, null);
		} else if (root.left == null && root.right == null) {
			return new Pair(true, root.val, root.val);
		} else {
			Pair checkL = isValidBSTHelper(root.left);
			Pair checkR = isValidBSTHelper(root.right);
			return new Pair(checkL.check && checkR.check
					&& checkLHelper(checkL.max, root.val)
					&& checkRHelper(checkR.min, root.val), checkNull(
					checkL.min, root.val), checkNull(checkR.max, root.val));
		}
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root).check;
	}
}
