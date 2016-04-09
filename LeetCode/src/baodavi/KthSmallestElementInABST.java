package baodavi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABST {
	
	 // Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> treeToList = new ArrayList<>();
        traverse(root, treeToList);
        return treeToList.get(k - 1);
    }
    
    private void traverse(TreeNode root, List<Integer> list){
    	if(root == null)
    		return;
    	traverse(root.left, list);
    	list.add(root.val);
    	traverse(root.right, list);
    }
    
    // use stack
    public int kthSmallestNo1(TreeNode root, int k) {
    	if(root == null)
    		return 0;
    	
    	Stack<TreeNode> topFringe = new Stack<>();
    	TreeNode curr = root;
    	while(curr != null){
    		topFringe.push(curr);
    		curr = curr.left;
    	}
    	
    	int val = 0;
    	int x = 1;
    	while(!topFringe.isEmpty()){
    		TreeNode currNode = topFringe.pop();
    		if(x == k){
    			val = currNode.val;
    			break;
    		}else{
    			x++;
    			TreeNode right = currNode.right;
    			while(right != null){
    				topFringe.push(right);
    				right = right.left;
    			}
    		}
    	}
    	
    	return val;
    }
    
    // use subtree node number counting
    public int kthSmallestNo2(TreeNode root, int k) {
    	int leftCnt = findNodesNumSum(root.left);
    	if(leftCnt + 1 == k){
    		return root.val;
    	}else if(leftCnt + 1 < k){
    		return kthSmallestNo2(root.right, k - leftCnt - 1);
    	}else{
    		return kthSmallestNo2(root.left, k);
    	}
    }
    
    private int findNodesNumSum(TreeNode root){
    	if(root == null)
    		return 0;
    	return findNodesNumSum(root.left) + findNodesNumSum(root.right) + 1;
    }
    
    /*
    Follow up:
    	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
    */
//    public int kthSmallestFollowUp(TreeNode root, int k) {
//    	如果BST节点TreeNode的属性可以扩展，则再添加一个属性leftCnt，记录左子树的节点个数
//
//    	记当前节点为node
//
//    	当node不为空时循环：
//
//    	若k == node.leftCnt + 1：则返回node
//
//    	否则，若k > node.leftCnt：则令k -= node.leftCnt + 1，令node = node.right
//
//    	否则，node = node.left
//    }
}
