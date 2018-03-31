package baodavi;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<Integer> appending = new ArrayList<>();
    	List<String> result = new ArrayList<>();
    	if(root == null){
    		return result;
    	}else{
    		appending.add(root.val);
    		binaryTreePaths(root, appending, result);
    		return result;
    	}
    }	
    
    private void binaryTreePaths(TreeNode root, List<Integer> appending, List<String> res) {
    	if(root.left == null && root.right == null){
    		String str = "";
    		for(Integer val : appending){
    			str += val + "->";
    		}
    		res.add(str.substring(0, str.length() - 2));
    		return;
    	}else{
    		if(root.left != null){
    			appending.add(root.left.val);
    			binaryTreePaths(root.left, appending, res);
    			appending.remove(appending.size() - 1);
    		}
    		if(root.right != null){
    			appending.add(root.right.val);
    			binaryTreePaths(root.right, appending, res);
    			appending.remove(appending.size() - 1);
    		}
    	}
    }
}
