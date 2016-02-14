package baodavi;
public class ReorderList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void reorderList(ListNode head) {

		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		// split original list into halves
		ListNode runner1 = head;
		ListNode runner2 = head;

		while (true) {
			ListNode tmp = runner1;
			runner1 = runner1.next;
			runner2 = runner2.next.next;

			if (runner2 == null) {
				tmp.next = null;
				break;
			}

			if (runner2.next == null) {
				ListNode tmp2 = runner1;
				runner1 = runner1.next;
				tmp2.next = null;
				break;
			}
		}

		// reverse the 2nd half
		ListNode pre = null;
		ListNode curr = runner1;
		ListNode next = curr.next;
		while (true) {
			curr.next = pre;
			pre = curr;
			curr = next;
			if (next == null) {
				break;
			} else {
				next = next.next;
			}
		}

		// merge the two lists
		ListNode l1 = head;
		ListNode l2 = pre;
		ListNode n1, n2;
		while (true) {
			n1 = l1.next;
			n2 = l2.next;
			l1.next = l2;
			l2.next = n1;
			if (n1 == null || n2 == null) {
				break;
			} else {
				l1 = n1;
				l2 = n2;
			}
		}
	}
}
