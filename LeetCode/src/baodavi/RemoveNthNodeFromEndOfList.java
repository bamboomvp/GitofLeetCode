package baodavi;

public class RemoveNthNodeFromEndOfList {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode p1 = head;
    	ListNode p2 = head;
    	for(int i = n; i > 0; i--){
    		p2 = p2.next;
    	}
    	if(p2 == null){
    		// the head needs to be removed...
    		return p1.next;
    	}else{
	    	while(p2.next != null){
	    		p1 = p1.next;
	    		p2 = p2.next;
	    	}
	    	p1.next = p1.next.next;
	    	return head;
    	}
    }
}
