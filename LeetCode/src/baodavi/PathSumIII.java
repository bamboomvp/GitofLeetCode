package baodavi;

public class PathSumIII {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	private int numOfPaths = 0;
    public int pathSum(TreeNode root, int sum) {
    	pathSumTraversal(root, sum);
    	return this.numOfPaths;
    }
    private void pathSumTraversal(TreeNode root, int sum){
    	if(root == null){
    		return;
    	}
    	pathSumHelper(root, sum, 0);
    	pathSumTraversal(root.left, sum);
    	pathSumTraversal(root.right, sum);
    }
    private void pathSumHelper(TreeNode root, int sum, int currSum){
    	if(root == null){
    		return;
    	}
    	if(currSum + root.val == sum){
    		this.numOfPaths++;
    	}
    	pathSumHelper(root.left, sum, currSum + root.val);
    	pathSumHelper(root.right, sum, currSum + root.val);
    }
}
