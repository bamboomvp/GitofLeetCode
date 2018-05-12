package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	 
    // Encodes a tree to a single string.
	// pre-order traverse
    public String serialize(TreeNode root) {
    	if(root == null)	return "#,";
    	String serialized = root.val + ",";
    	serialized += serialize(root.left);
    	serialized += serialize(root.right);
    	return serialized;
    }
    
    // level traverse, non-recursive
    public String serializeII(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		TreeNode curr = queue.poll();
    		if(curr == null){
    			sb.append("#,");
    		}else{
    			sb.append(String.valueOf(curr.val) + ",");
    			queue.offer(curr.left);
    			queue.offer(curr.right);
    		}
    	}
    	return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        return deserializeHelper(tokenList);
    }
    
    private TreeNode deserializeHelper(List<String> tokenList){
    	if(tokenList.get(0).equals("#")){
    		tokenList.remove(0);
    		return null;
    	}
    	TreeNode curr = new TreeNode(Integer.valueOf(tokenList.get(0)));
    	tokenList.remove(0);
    	curr.left = deserializeHelper(tokenList);
    	curr.right = deserializeHelper(tokenList);
    	return curr;
    }
    
    public TreeNode deserializeII(String data) {
    	if(data == null || data.isEmpty())	return null;
    	
    	String[] vals = data.split(",");
    	int[] numOfNulls = new int[vals.length];
    	TreeNode[] nodes = new TreeNode[vals.length];
    	
    	for(int i = 0; i < vals.length; i++){
    		if(i > 0)	numOfNulls[i] = numOfNulls[i - 1];
    		if(vals[i].equals("#")){
    			nodes[i] = null;
    			numOfNulls[i]++;
    		}else{
    			nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
    		}
    	}
    	
    	for(int i = 0; i < vals.length; i++){
    		if(nodes[i] == null)	continue;
    		nodes[i].left = nodes[2 * (i - numOfNulls[i]) + 1];
    		nodes[i].right = nodes[2 * (i - numOfNulls[i]) + 2];
    	}
    	
    	return nodes[0];
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
