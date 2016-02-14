package baodavi;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		Set<ListNode> table = new HashSet<ListNode>();
		ListNode curr = head;
		while (curr != null) {
			if (table.contains(curr)) {
				return curr;
			} else {
				table.add(curr);
				curr = curr.next;
			}
		}
		return null;
	}
}
