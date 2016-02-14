package baodavi;
import java.util.Stack;

public class BSTIterator {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Stack<TreeNode> myStack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			myStack.push(curr);
			curr = curr.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !myStack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode curr = myStack.pop();
		if (curr.right != null) {
			TreeNode currR = curr.right;
			while (currR != null) {
				myStack.push(currR);
				currR = currR.left;
			}
		}
		return curr.val;
	}
}
