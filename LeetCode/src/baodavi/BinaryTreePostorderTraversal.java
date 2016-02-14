package baodavi;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private void postorderTraversalHelper(TreeNode root, List<Integer> list) {
		if (root != null) {
			postorderTraversalHelper(root.left, list);
			postorderTraversalHelper(root.right, list);
			list.add(root.val);
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		postorderTraversalHelper(root, res);
		return res;
	}
}
