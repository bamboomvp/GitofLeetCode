package baodavi;

import java.util.Stack;

public class MergeTwoBinaryTrees {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if(t1 == null && t2 == null)	return null;
    	TreeNode mergedNode = new TreeNode(0);
    	if(t1 == null){
    		mergedNode.val = t2.val;
    		mergedNode.left = mergeTrees(null, t2.left);
    		mergedNode.right = mergeTrees(null, t2.right);
    	}else if(t2 == null){
    		mergedNode.val = t1.val;
    		mergedNode.left = mergeTrees(t1.left, null);
    		mergedNode.right = mergeTrees(t1.right, null);
    	}else{
    		mergedNode.val = t1.val + t2.val;
    		mergedNode.left = mergeTrees(t1.left, t2.left);
    		mergedNode.right = mergeTrees(t1.right, t2.right);
    	}
    	return mergedNode;
    }
    
    // reuse node t1, make it the merged one
    public TreeNode mergeTreesUseStack(TreeNode t1, TreeNode t2) {
    	if(t1 == null)	return t2;
    	if(t2 == null)	return t1;
    	Stack<TreeNode[]> stack = new Stack<>();
    	stack.push(new TreeNode[]{t1, t2});
    	while(!stack.isEmpty()){
    		TreeNode[] curr = stack.pop();
    		curr[0].val += curr[1].val;
    		if(curr[0].left == null){
    			curr[0].left = curr[1].left;
    		}else{
    			if(curr[1].left != null){
    				stack.push(new TreeNode[]{curr[0].left, curr[1].left});
    			}
    		}
    		if(curr[0].right == null){
    			curr[0].right = curr[1].right;
    		}else{
    			if(curr[1].right != null){
    				stack.push(new TreeNode[]{curr[0].right, curr[1].right});
    			}
    		}
    	}
    	return t1;
    }
}
