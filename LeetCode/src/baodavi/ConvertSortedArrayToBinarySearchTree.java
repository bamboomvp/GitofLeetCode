package baodavi;

public class ConvertSortedArrayToBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null || nums.length == 0)	return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end){
    	if(start == end)			return new TreeNode(nums[start]);
    	else if(start > end)		return null;
    	else{
        	int mid = start + (end - start) / 2;
        	TreeNode curr = new TreeNode(nums[mid]);
        	curr.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        	curr.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        	return curr;    		
    	}
    }
}
