package baodavi;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRecursively(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }	
    
    private TreeNode buildTreeRecursively(int[] inorder, int[] postorder, int leftIn, int rightIn, int leftPost, int rightPost){
    	if(leftIn > rightIn || leftPost > rightPost)
    		return null;
    	if(leftIn == rightIn && leftPost == rightPost)
    		return new TreeNode(postorder[rightPost]);
    	TreeNode root = new TreeNode(postorder[rightPost]);
    	for(int k = leftIn; k <= rightIn; k++){
    		if(postorder[rightPost] == inorder[k]){
    			root.left = buildTreeRecursively(inorder, postorder, leftIn, k - 1, leftPost, leftPost + (k - leftIn - 1));
    			root.right = buildTreeRecursively(inorder, postorder, k + 1, rightIn, leftPost + (k - leftIn - 1) + 1, rightPost - 1);
    		}
    	}
    	return root;
    }
}
