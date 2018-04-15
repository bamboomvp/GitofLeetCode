package baodavi;

public class ReverseLinkedList {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}	
	
	// best recursive
	public ListNode reverseList(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	
    public ListNode reverseListIteratively(ListNode head) {
    	ListNode pre = null, cur = head;
    	while(cur != null){
    		ListNode next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	return pre;
    }
    
    public ListNode reverseListRecursively(ListNode head) {
    	if(head == null)	return null;
        ListNode runner = head;
        while(runner.next != null){
        	runner = runner.next;
        }
        reverseListRecursivelyHelper(head);
        return runner;
    }
    
    private ListNode reverseListRecursivelyHelper(ListNode node){
    	if(node.next == null){
    		return node;
    	}
    	ListNode tailOfSubList = reverseListRecursivelyHelper(node.next);
    	tailOfSubList.next = node;
    	node.next = null;
    	return node;
    }
}
