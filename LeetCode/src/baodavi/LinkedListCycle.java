package baodavi;
public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode runner1 = head;
		ListNode runner2 = head;
		while (runner1 != null && runner2 != null) {
			runner1 = runner1.next;
			if (runner2.next == null) {
				return false;
			}
			runner2 = runner2.next.next;
			if (runner1 == runner2) {
				return true;
			}
		}
		return false;
	}
}
