package baodavi;

public class SwapNodesInPairs {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	 }
	 
	 public ListNode swapPairs(ListNode head) {
		 if(head == null){
			 return null;
		 }
		 ListNode dummy = new ListNode(-1);
		 dummy.next = head;
		 ListNode pre = dummy;
		 ListNode p1 = head;
		 ListNode p2 = head.next;
		 while(p2 != null){
			 p1.next = p2.next;
			 p2.next = p1;
			 pre.next = p2;
			 pre = p1;
			 p1 = p1.next;
			 if(p1 == null){
				 break;
			 }
			 p2 = p1.next;
		 }
		 return dummy.next;
	 }	 
}
