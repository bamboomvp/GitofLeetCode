package baodavi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null)	return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
        	int currLen = q.size();
        	double subTotal = 0;
        	for(int i = 0; i < currLen; i++){
        		TreeNode currNode = q.poll();
        		subTotal += currNode.val;
        		if(currNode.left != null)		q.offer(currNode.left);
        		if(currNode.right != null)	q.offer(currNode.right);
        	}
        	res.add(subTotal / currLen);
        }
        return res;
    }
}
