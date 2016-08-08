package baodavi;

public class RecoverBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode prev, swap, swap2;
	private boolean flag;
	
	public void recoverTree(TreeNode root) {
		prev = swap = swap2 = null;
		flag = false;
		recoverTreeHelper(root);
		if(!flag){
			int tmp = swap.val;
			swap.val = swap2.val;
			swap2.val = tmp;
		}
	}
	
	private void recoverTreeHelper(TreeNode root){
		if(root == null)
			return;
		recoverTreeHelper(root.left);
		if(prev == null)
			prev = root;
		else{
			if(prev.val > root.val){
				if(swap == null){
					swap = prev;
					swap2 = root;
				}else{
					int tmp = root.val;
					root.val = swap.val;
					swap.val = tmp;
					flag = true;
				}
			}
			prev = root;
		}
		recoverTreeHelper(root.right);
	}
}
