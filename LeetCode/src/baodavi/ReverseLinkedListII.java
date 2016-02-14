package baodavi;
public class ReverseLinkedListII {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private void reverseHelper(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		ListNode next = curr.next;
		while (true) {
			curr.next = pre;
			pre = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			} else {
				return;
			}
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		if (m == n) {
			return head;
		}

		ListNode before = null;
		ListNode last = head;
		ListNode after = null;
		int count = 1;
		while (true) {
			if (count < m) {
				before = last;
			}
			if (count == n) {
				after = last.next;
				break;
			}
			last = last.next;
			count++;
		}

		last.next = null;
		if (before == null) {
			reverseHelper(head);
		} else {
			reverseHelper(before.next);
		}

		if (before == null) {
			head.next = after;
			return last;
		} else {
			before.next.next = after;
			before.next = last;
			return head;
		}
	}
}
