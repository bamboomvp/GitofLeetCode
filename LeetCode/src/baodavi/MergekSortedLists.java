package baodavi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private ListNode merge2Lists(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} else {
			ListNode newHead;
			ListNode newCurr;

			if (a.val <= b.val) {
				newHead = a;
				a = a.next;
			} else {
				newHead = b;
				b = b.next;
			}
			newCurr = newHead;

			while (a != null && b != null) {
				if (a.val <= b.val) {
					newCurr.next = a;
					newCurr = newCurr.next;
					a = a.next;
				} else {
					newCurr.next = b;
					newCurr = newCurr.next;
					b = b.next;
				}
			}

			if (a != null) {
				newCurr.next = a;
			} else {
				newCurr.next = b;
			}

			return newHead;
		}
	}

	private ListNode mergeKListsHelper(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		} else if (lists.size() == 1) {
			return lists.get(0);
		} else {
			List<ListNode> newList = new ArrayList<ListNode>();
			for (int i = 0; i < lists.size(); i += 2) {
				if (i + 1 < lists.size())
					newList.add(merge2Lists(lists.get(i), lists.get(i + 1)));
				else
					newList.add(merge2Lists(lists.get(i), null));
			}
			return mergeKListsHelper(newList);
		}
	}

	private ListNode mergeKListsHelper2(List<ListNode> lists) {

		if (lists.size() == 0) {
			return null;
		} else if (lists.size() == 1) {
			return lists.get(0);
		}

		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						if (o1.val < o2.val) {
							return -1;
						} else if (o1.val == o2.val) {
							return 0;
						} else {
							return 1;
						}
					}
				});

		ListNode newHead = null;
		ListNode newCurr = null;
		for (int i = 0; i < lists.size(); i++) {
			ListNode currN = lists.get(i);
			if (currN != null) {
				minHeap.add(currN);
			}
		}

		boolean flagFirst = true;
		while (!minHeap.isEmpty()) {
			ListNode heapTop = minHeap.remove();
			if (flagFirst) {
				newHead = heapTop;
				newCurr = newHead;
				flagFirst = false;
			} else {
				newCurr.next = heapTop;
				newCurr = newCurr.next;
			}
			if (heapTop.next != null) {
				minHeap.add(heapTop.next);
			}
		}

		return newHead;
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		// return mergeKListsHelper(lists);
		return mergeKListsHelper2(lists);
	}
}
