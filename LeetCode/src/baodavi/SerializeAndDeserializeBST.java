package baodavi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	 
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
	    // non-recursive, use stack
		if(root == null)	return "";
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			sb.append(cur.val).append(',');
			if(cur.right != null)	stack.push(cur.right);
			if(cur.left != null)	stack.push(cur.left);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if(data == null || data.isEmpty())	return null;
	    Queue<Integer> queue = new LinkedList<>();
	    for(String s : data.split(","))
	    	queue.add(Integer.parseInt(s));
	    return deserializeHelper(Integer.MAX_VALUE, queue);
	}
	
	private TreeNode deserializeHelper(int max, final Queue<Integer> queue) {
		if(queue.isEmpty())		return null;
		TreeNode root = new TreeNode(queue.remove());
		if(!queue.isEmpty() && queue.peek() < root.val)
			root.left = deserializeHelper(root.val, queue);
		if(!queue.isEmpty() && queue.peek() > root.val && queue.peek() < max)
			root.right = deserializeHelper(max, queue);
		return root;
	}
}
