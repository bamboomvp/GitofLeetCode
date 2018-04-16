package baodavi;

import java.util.ArrayList;
import java.util.List;

public class MaximumBinaryTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }

	}
	
	public TreeNode constructMaximumBinaryTreeFancy(int[] nums) {
		List<TreeNode> stack = new ArrayList<>();
		for(int num : nums){
			TreeNode cur = new TreeNode(num);
			while(!stack.isEmpty() && stack.get(stack.size()-1).val < cur.val){
				cur.left = stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
			}
			if(!stack.isEmpty()){
				stack.get(stack.size()-1).right = cur;
			}
			stack.add(cur);
		}
		return stack.get(0);
	}
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTreeHelper(int[] nums, int start, int end){
    	if(start > end){
    		return null;
    	}else if(start == end){
    		return new TreeNode(nums[start]);
    	}else{
    		int maxIndex = start;
    		for(int i = start + 1; i <= end; i++){
    			if(nums[i] > nums[maxIndex]){
    				maxIndex = i;
    			}
    		}
    		TreeNode cur = new TreeNode(nums[maxIndex]);
    		cur.left = constructMaximumBinaryTreeHelper(nums, start, maxIndex - 1);
    		cur.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, end);
    		return cur;
    	}
    }
}
