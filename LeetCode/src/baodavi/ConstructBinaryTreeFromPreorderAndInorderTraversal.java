package baodavi;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursively(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }	
    
    private TreeNode buildTreeRecursively(int[] preorder, int[] inorder, int lp, int rp, int li, int ri){
    	if(lp > rp || li > ri)
    		return null;
    	if(lp == rp && li == ri)
    		return new TreeNode(preorder[lp]);
    	TreeNode root = new TreeNode(preorder[lp]);
    	for(int k = li; k <= ri; k++){
    		if(preorder[lp] == inorder[k]){
    			root.left = buildTreeRecursively(preorder, inorder, lp + 1, lp + (k - li), li, k - 1);
    			root.right = buildTreeRecursively(preorder, inorder, lp + (k - li) + 1, rp, k + 1, ri);
    		}
    	}
    	return root;
    }
}
