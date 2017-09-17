package baodavi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)	return res;
    	
    	List<List<TreeNode>> layers = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	List<TreeNode> fringe = new ArrayList<>();
        	while(!queue.isEmpty()){
        		fringe.add(queue.poll());
        	}
        	layers.add(fringe);
        	for(TreeNode nodeInFringe : fringe){
        		if(nodeInFringe.left != null)		queue.offer(nodeInFringe.left);
        		if(nodeInFringe.right != null)	queue.offer(nodeInFringe.right);
        	}
        }
        for(List<TreeNode> layer : layers){
        	res.add(layer.get(layer.size() - 1).val);
        }
        return res;
    }
}
