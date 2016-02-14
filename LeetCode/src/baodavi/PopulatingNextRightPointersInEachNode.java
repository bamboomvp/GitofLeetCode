package baodavi;
public class PopulatingNextRightPointersInEachNode {
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
		TreeLinkNode nextHead = root.left;
		while (nextHead != null) {
			TreeLinkNode pre = currHead;
			while (pre != null) {
				pre.left.next = pre.right;
				if (pre.next != null)
					pre.right.next = pre.next.left;
				pre = pre.next;
			}
			currHead = nextHead;
			nextHead = nextHead.left;
		}
	}
}
