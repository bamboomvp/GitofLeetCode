package baodavi;

public class ReverseNodesInKGroup {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        int count = k + 1;
        while(count > 0 && end != null){
        	count--;
        	end = end.next;
        	if(count == 0){
        		ListNode newHead = reverseList(pre.next, end);
        		ListNode tmpPre = pre.next;
        		pre.next.next = end;
        		pre.next = newHead;
        		pre = tmpPre;
        		if(end == null){
        			break;
        		}else{
	        		end = pre;
	        		count = k + 1;
        		}
        	}
        }
        
        return dummy.next;
    }
    
    public ListNode reverseList(ListNode head, ListNode end) {
    	ListNode pre = null, cur = head;
    	while(cur != end){
    		ListNode next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	return pre;
    }
}
