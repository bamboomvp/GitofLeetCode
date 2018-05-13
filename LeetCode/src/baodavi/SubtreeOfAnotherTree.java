package baodavi;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isSubtreeFancy(TreeNode s, TreeNode t) {
		String tree1 = preOrder(s);
		String tree2 = preOrder(t);
		return tree1.indexOf(tree2) != -1;
	}
	
	private String preOrder(TreeNode node){
		if(node == null)	return "N";
		return "#" + node.val + preOrder(node.left) + preOrder(node.right);
	}
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if(s == null)	return false;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(s);
    	while(!queue.isEmpty()){
    		TreeNode curr = queue.remove();
    		if(isSubtreeHelper(curr, t))	return true;
    		if(curr.left != null)		queue.add(curr.left);
    		if(curr.right != null)	queue.add(curr.right);
    	}
    	return false;
    }
    
    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
    	if(s == null && t == null)	return true;
    	else if(s != null && t == null)		return false;
    	else if(s == null && t != null)		return false;
    	else{
    		if(s.val != t.val)	return false;
    		else{
    			return isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right);
    		}
    	}
    }
}
