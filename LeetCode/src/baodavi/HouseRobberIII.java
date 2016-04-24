package baodavi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

public class HouseRobberIII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public class HashValPair {
		int val1;
		int val2;
		HashValPair(){
			this.val1 = 0;
			this.val2 = 0;
		}
	}
	
	private Map<TreeNode, HashValPair> hashMap = new HashMap<>();
	
	public int rob(TreeNode root) {
		return Math.max(robHelper(root, true), robHelper(root, false));
	}
	
	private int robHelper(TreeNode node, boolean robIt){
		if(node == null)
			return 0;
		
		if(this.hashMap.containsKey(node)){
			if(robIt && this.hashMap.get(node).val1 > 0)
				return this.hashMap.get(node).val1;
			else if(!robIt && this.hashMap.get(node).val2 > 0)
				return this.hashMap.get(node).val2;
		}
		
		if(robIt){
			int res = node.val + robHelper(node.left, false) + robHelper(node.right, false);
			if(this.hashMap.containsKey(node)){
				this.hashMap.get(node).val1 = res;
			}else{
				HashValPair hehe = new HashValPair();
				hehe.val1 = res;
				this.hashMap.put(node, hehe);
			}
			return res;
		}else{
			int case1 = robHelper(node.left, true) + robHelper(node.right, true);
			int case2 = robHelper(node.left, false) + robHelper(node.right, false);
			int case3 = robHelper(node.left, true) + robHelper(node.right, false);
			int case4 = robHelper(node.left, false) + robHelper(node.right, true);
			int res = Collections.max(Arrays.asList(case1,case2,case3,case4));
			if(this.hashMap.containsKey(node)){
				this.hashMap.get(node).val2 = res;
			}else{
				HashValPair hehe = new HashValPair();
				hehe.val2 = res;
				this.hashMap.put(node, hehe);
			}			
			
			return res;
		}
	}
	
	/*
	题意：给定一棵二叉树，求能获取的权值最大和（相邻的不能同时取）

	思路: 树形dp

	显然有：

	rob_root = max(rob_L + rob_R , no_rob_L + no_nob_R + root.val)
	no_rob_root = rob_L + rob_R
	*/
    public int robAdvanced(TreeNode root) {
        return dfs(root)[0];
    }
    
    private int[] dfs(TreeNode root) {
        int dp[]={0,0};
        if(root != null){
            int[] dp_L = dfs(root.left);
            int[] dp_R = dfs(root.right);
            dp[1] = dp_L[0] + dp_R[0];
            dp[0] = Math.max(dp[1] ,dp_L[1] + dp_R[1] + root.val);
        }
        return dp;
    }	
}
