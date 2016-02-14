package baodavi;
import java.util.ArrayList;
import java.util.List;


public class BinaryTreeLevelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public void levelOrderHelper(TreeNode root, List<List<Integer>> currRes, int h) {
        if (root == null) {
            return;
        } else {
            if (currRes.size() <= h) {
                List<Integer> innerList = new ArrayList<Integer>();
                innerList.add(root.val);
                currRes.add(innerList);
            } else {
                currRes.get(h).add(root.val);
            }
            levelOrderHelper(root.left, currRes, h + 1);
            levelOrderHelper(root.right, currRes, h + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrderHelper(root, res, 0);
        return res;
    }
}
