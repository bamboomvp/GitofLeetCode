package baodavi;
public class IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA, lenB;
		lenA = lenB = 0;

		ListNode currA = headA;
		while (currA != null) {
			lenA++;
			currA = currA.next;
		}

		ListNode currB = headB;
		while (currB != null) {
			lenB++;
			currB = currB.next;
		}

		currA = headA;
		currB = headB;
		if (lenA > lenB) {
			int steps = lenA - lenB;
			while (steps != 0) {
				currA = currA.next;
				steps--;
			}
		}

		if (lenB > lenA) {
			int steps = lenB - lenA;
			while (steps != 0) {
				currB = currB.next;
				steps--;
			}
		}

		while (currA != null && currB != null) {
			if (currA == currB) {
				return currA;
			} else {
				currA = currA.next;
				currB = currB.next;
			}
		}

		return null;
	}

}
