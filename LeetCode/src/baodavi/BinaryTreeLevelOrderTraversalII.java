package baodavi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	int depth = calcLevels(root);
    	for(int i = 0; i < depth; i++){
    		res.add(new ArrayList<Integer>());
    	}
    	levelOrderBottomHelper(root, 0, res);
    	return res;
    }
    
    private int calcLevels(TreeNode root){
    	if(root == null)	return 0;
    	else{
    		int dleft = calcLevels(root.left);
    		int dright = calcLevels(root.right);
    		return Math.max(dleft, dright) + 1;
    	}
    }
    
    private void levelOrderBottomHelper(TreeNode root, int currDepth, List<List<Integer>> res){
    	if(root == null)	return;
    	else{
    		levelOrderBottomHelper(root.left, currDepth + 1, res);
    		levelOrderBottomHelper(root.right, currDepth + 1, res);
    		List<Integer> currRes = res.get(res.size() - 1 - currDepth);
    		currRes.add(root.val);
    	}
    }
    
    // BFS
    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	List<List<Integer>> res = new ArrayList<>();
    	
    	if(root == null)	return res;
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		int currLevelSize = queue.size();
    		List<Integer> subList = new ArrayList<>();
    		for(int i = 0; i < currLevelSize; i++){
    			if(queue.peek().left != null)	queue.offer(queue.peek().left);
    			if(queue.peek().right != null)	queue.offer(queue.peek().right);
    			subList.add(queue.poll().val);
    		}
    		res.add(0, subList);
    	}
    	return res;
    }
}
