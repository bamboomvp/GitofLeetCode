package baodavi;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
			return null;
		else if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		else{
			int carry = 0;
			ListNode dummyHead = new ListNode(0);
			ListNode prevNode = dummyHead;
			while(l1 != null && l2 != null){
				int sum = l1.val + l2.val + carry;
				ListNode curNode = new ListNode(sum % 10);
				prevNode.next = curNode;
				prevNode = curNode;
				carry = sum / 10;
				
				l1 = l1.next;
				l2 = l2.next;
			}
			
			ListNode remaining = null;
			if(l1 != null)
				remaining = l1;
			if(l2 != null)
				remaining = l2;
			
			while(remaining != null){
				int sum = remaining.val + carry;
				ListNode curNode = new ListNode(sum % 10);
				prevNode.next = curNode;
				prevNode= curNode;
				carry = sum / 10;
				
				remaining = remaining.next;
			}
			
			if(carry > 0){
				ListNode curNode = new ListNode(carry);
				prevNode.next = curNode;
				prevNode= curNode;
			}
			
			return dummyHead.next;
		}
	}
}
