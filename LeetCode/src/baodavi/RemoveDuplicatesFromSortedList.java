package baodavi;
public class RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;

		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			while (next != null && next.val == curr.val) {
				next = next.next;
			}
			curr.next = next;
			curr = next;
		}

		return head;
	}
}
