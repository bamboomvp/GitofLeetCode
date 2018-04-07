package baodavi;

public class CountCompleteTreeNodes {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	 }
	 
    public int countNodes(TreeNode root) {
       return countNodesHelper(root, -1, -1);
    }
    
    private int countNodesHelper(TreeNode root, int lheight, int rheight){
    	if(lheight == -1){
    		lheight = 0;
    		TreeNode curr = root;
    		while(curr != null){
    			lheight++;
    			curr = curr.left;
    		}
    	}
    	if(rheight == -1){
    		rheight = 0;
    		TreeNode curr = root;
    		while(curr != null){
    			rheight++;
    			curr = curr.right;
    		}
    	}
    	if(lheight == rheight)	return (1 << lheight) - 1;
    	return 1 + countNodesHelper(root.left, lheight - 1, -1) + countNodesHelper(root.right, -1, rheight - 1);
    }
}
