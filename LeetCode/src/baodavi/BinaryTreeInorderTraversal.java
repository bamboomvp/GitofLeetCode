package baodavi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Stack<TreeNode> myStack = new Stack<>();
		TreeNode curr = root;
		while (curr != null) {
			myStack.push(curr);
			curr = curr.left;
		}
		while (!myStack.isEmpty()) {
			TreeNode now = myStack.pop();
			res.add(now.val);
			TreeNode toAdd = now.right;
			while (toAdd != null) {
				myStack.push(toAdd);
				toAdd = toAdd.left;
			}
		}

		return res;
	}
}
