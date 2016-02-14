package baodavi;

public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		ListNode helperHead = new ListNode(0);
		helperHead.next = head;
		ListNode lastGuard = helperHead;
		ListNode runner = helperHead;
		while (runner.next != null) {
			if (runner.next.val < x) {
				if (runner == lastGuard) {
					runner = runner.next;
				} else {
					ListNode tmp = runner.next.next;
					runner.next.next = lastGuard.next;
					lastGuard.next = runner.next;
					runner.next = tmp;
				}
				lastGuard = lastGuard.next;
			} else {
				runner = runner.next;
			}
		}

		return helperHead.next;
	}
}
