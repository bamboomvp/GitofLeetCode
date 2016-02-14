package baodavi;
public class PopulatingNextRightPointersInEachNodeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode currHead = root;
		while (currHead != null) {
			TreeLinkNode pre = currHead;
			TreeLinkNode NextHead = null;
			TreeLinkNode NextCurr = null;
			while (pre != null) {
				if (pre.left != null) {
					if (NextHead == null) {
						NextHead = pre.left;
						NextCurr = NextHead;
					} else {
						NextCurr.next = pre.left;
						NextCurr = NextCurr.next;
					}
				}
				if (pre.right != null) {
					if (NextHead == null) {
						NextHead = pre.right;
						NextCurr = NextHead;
					} else {
						NextCurr.next = pre.right;
						NextCurr = NextCurr.next;
					}
				}
				pre = pre.next;
			}

			currHead = NextHead;
		}
	}
}
