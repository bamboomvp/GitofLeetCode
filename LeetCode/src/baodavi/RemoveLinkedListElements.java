package baodavi;

public class RemoveLinkedListElements {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode runner = dummyHead;
        while(runner != null && runner.next != null){
        	while(runner.next != null || runner.next.val == val){
        		runner.next = runner.next.next;
        	}
        	runner = runner.next;
        }
        return dummyHead.next;
    }
}
