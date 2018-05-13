package baodavi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	if(root == null)	return res;
    	Queue<TreeNode> queue = new LinkedList<>();
    	List<TreeNode> edge = new ArrayList<>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		while(!queue.isEmpty()){
    			edge.add(queue.remove());
    		}
    		int levelMax = Integer.MIN_VALUE;
    		for(TreeNode currNode : edge){
    			levelMax = Math.max(levelMax, currNode.val);
    			if(currNode.left != null)	queue.add(currNode.left);
    			if(currNode.right != null)	queue.add(currNode.right);
    		}
    		edge.clear();
    		res.add(levelMax);
    	}
    	return res;
    }
}
