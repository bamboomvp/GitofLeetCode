package baodavi;

import java.util.Stack;

public class ConvertBSTToGreaterTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private int runningSum = 0;
    public TreeNode convertBST1(TreeNode root) {
        if(root != null){
        	convertBST1(root.right);
        	this.runningSum += root.val;
        	root.val = this.runningSum;
        	convertBST1(root.left);
        }
        return root;
    }
    
    // with Stack
    public TreeNode convertBST2(TreeNode root) {
    	int runningSum = 0;
    	TreeNode curr = root;
    	Stack<TreeNode> stack = new Stack<>();
    	while(!stack.isEmpty() || curr != null){
    		while(curr != null){
    			stack.add(curr);
    			curr = curr.right;
    		}
    		
    		curr = stack.pop();
    		runningSum += curr.val;
    		curr.val = runningSum;
    		
    		curr = curr.left;
    	}
    	return root;
    }
    
//    public TreeNode convertBST3(TreeNode root) {
//    	
//    }
}
