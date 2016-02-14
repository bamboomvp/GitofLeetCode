package baodavi;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();

		TreeNode curr = root;
		while (curr != null || !s.isEmpty()) {
			if (curr == null) {
				curr = s.pop();
			}

			res.add(curr.val);
			if (curr.right != null) {
				s.push(curr.right);
			}
			curr = curr.left;
		}

		return res;
	}
}
