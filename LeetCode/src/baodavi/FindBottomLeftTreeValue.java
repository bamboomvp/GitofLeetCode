package baodavi;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public int findBottomLeftValueBFS(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
        	int len = q.size();
        	for(int i = 0; i < len; i++){
        		TreeNode curr = q.poll();
        		if(i == 0)	res = curr.val;
        		if(curr.left != null)		q.offer(curr.left);
        		if(curr.right != null)	q.offer(curr.right);
        	}
        }
        return res;
    }
    
    int maxDepth = -1;
    int resVal = -1;
    public int findBottomLeftValueDFS(TreeNode root) {
    	dfs(root, 0);
    	return resVal;
    }
    private void dfs(TreeNode curr, int currDepth){
    	if(curr == null)	return;
    	if(currDepth > maxDepth){
    		maxDepth = currDepth;
    		resVal = curr.val;
    	}
    	dfs(curr.left, currDepth + 1);
    	dfs(curr.right, currDepth + 1);
    }
}
