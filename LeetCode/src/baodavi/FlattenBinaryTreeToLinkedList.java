package baodavi;

public class FlattenBinaryTreeToLinkedList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private TreeNode flattenHelper(TreeNode root) {
		if (root == null) {
			return null; // special case
		}

		TreeNode leftChildLast = flattenHelper(root.left);
		TreeNode rightChildLast = flattenHelper(root.right);

		if (root.left == null && root.right == null) {
			return root;
		} else if (root.left == null) {
			return rightChildLast;
		} else {
			TreeNode tmp = root.right;
			root.right = root.left;
			leftChildLast.right = tmp;
			root.left = null;
			if (tmp == null)
				return leftChildLast;
			else
				return rightChildLast;
		}
	}

	public void flatten(TreeNode root) {
		flattenHelper(root);
	}
	
	public static void main(String[] args){
		FlattenBinaryTreeToLinkedList ins = new FlattenBinaryTreeToLinkedList();
		TreeNode root = ins.new TreeNode(1);
		root.left = ins.new TreeNode(2);
		root.left.left = ins.new TreeNode(3);
//		root.left.right = ins.new TreeNode(4);
//		root.right = ins.new TreeNode(5);
//		root.right.right = ins.new TreeNode(6);
		
		ins.flatten(root);
		int a = 1;
	}
}
