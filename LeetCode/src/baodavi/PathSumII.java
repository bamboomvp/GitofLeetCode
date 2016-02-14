package baodavi;
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private void pathSumHelper(TreeNode root, int sum, int curr,
			List<Integer> currPath, List<List<Integer>> res) {
		// leaf node
		if (root.left == null && root.right == null) {
			if (sum == curr) {
				res.add(new ArrayList<Integer>(currPath));
			}
			currPath.remove(currPath.size() - 1);
			return;
		}

		if (root.left != null) {
			currPath.add(root.left.val);
			pathSumHelper(root.left, sum, curr + root.left.val, currPath, res);
		}

		if (root.right != null) {
			currPath.add(root.right.val);
			pathSumHelper(root.right, sum, curr + root.right.val, currPath, res);
		}

		currPath.remove(currPath.size() - 1);
		return;
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> currPath = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		currPath.add(root.val);
		pathSumHelper(root, sum, root.val, currPath, res);

		return res;
	}
}
