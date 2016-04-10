package baodavi;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
	
	// lowest common ancestor (LCA) of two given nodes in the BST.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();
        generatePath(root, p, path1);
        generatePath(root, q, path2);
        TreeNode lca = null;
        while(!path1.isEmpty() && !path2.isEmpty()){
        	TreeNode nextNode = path1.remove(path1.size() - 1);
        	if(nextNode == path2.remove(path2.size() - 1))
        		lca = nextNode;
        	else
        		break;
        }
        	
        return lca;
    }
    
    private boolean generatePath(TreeNode curr, TreeNode node, List<TreeNode> path){
    	if(curr == null || node == null)
    		return false;
    	
    	if(curr == node){
    		path.add(curr);
    		return true;
    	}else{
    		if(generatePath(curr.left, node, path) || generatePath(curr.right, node, path)){
    			path.add(curr);
    			return true;
    		}else{
    			return false;
    		}
    	}
    }
    
    /*
    
    思路
    我们可以用深度优先搜索，从叶子节点向上，标记子树中出现目标节点的情况。如果子树中有目标节点，标记为那个目标节点，如果没有，标记为null。显然，如果左子树、右子树都有标记，说明就已经找到最小公共祖先了。如果在根节点为p的左右子树中找p、q的公共祖先，则必定是p本身。

    换个角度，可以这么想：如果一个节点左子树有两个目标节点中的一个，右子树没有，那这个节点肯定不是最小公共祖先。如果一个节点右子树有两个目标节点中的一个，左子树没有，那这个节点肯定也不是最小公共祖先。只有一个节点正好左子树有，右子树也有的时候，才是最小公共祖先。

    代码
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //发现目标节点则通过返回值标记该子树发现了某个目标结点
            if(root == null || root == p || root == q) return root;
            //查看左子树中是否有目标结点，没有为null
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            //查看右子树是否有目标节点，没有为null
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
            if(left!=null&&right!=null) return root;
            //如果发现了目标节点，则继续向上标记为该目标节点
            return left == null ? right : left;
        }
    }
    
    */
}
