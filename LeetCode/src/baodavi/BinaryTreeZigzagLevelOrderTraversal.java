package baodavi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		class Entry {
			public Entry(TreeNode node, int depth) {
				this.node = node;
				this.depth = depth;
			}

			TreeNode node;
			int depth;
		}
		Queue<Entry> myQueue = new LinkedList<Entry>();

		myQueue.add(new Entry(root, 0));
		while (!myQueue.isEmpty()) {
			Entry curr = myQueue.remove();
			if (curr.node != null) {
				if (res.size() <= curr.depth) {
					List<Integer> currL = new ArrayList<Integer>();
					res.add(currL);
				}
				if (curr.depth % 2 == 0)
					res.get(curr.depth).add(curr.node.val);
				else
					res.get(curr.depth).add(0, curr.node.val);
				myQueue.add(new Entry(curr.node.left, curr.depth + 1));
				myQueue.add(new Entry(curr.node.right, curr.depth + 1));
			}
		}

		return res;
	}

	public static void main(String[] args) {
		TreeNode root, left, right;
		root = new TreeNode(1);
		left = new TreeNode(2);
		right = new TreeNode(3);
		root.left = left;
		root.right = right;

		BinaryTreeZigzagLevelOrderTraversal instance = new BinaryTreeZigzagLevelOrderTraversal();
		instance.zigzagLevelOrder(root);
	}
}
