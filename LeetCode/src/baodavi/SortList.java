package baodavi;

public class SortList {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}	
	
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        int len = 0;
        ListNode curr = head;
        while(curr != null){
        	len++;
        	curr = curr.next;
        }
        
        return sortListDivideAndConquer(head, len);
    }
    
    private ListNode sortListDivideAndConquer(ListNode head, int len){
    	if(len == 1)
    		return head;
    	
    	ListNode h1, h2, runner;
    	int cnt = 0;
    	runner = head;
    	while(cnt < (len/2 - 1)){
    		cnt++;
    		runner = runner.next;
    	}
    	h1 = head;
    	h2 = runner.next;
    	runner.next = null; // break it!
    	ListNode h1new = sortListDivideAndConquer(h1, len / 2);
    	ListNode h2new = sortListDivideAndConquer(h2, (len / 2) + (len % 2));
    	ListNode headNew = mergeTwoLists(h1new, h2new);
    	
    	return headNew;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    	ListNode dummyHead = new ListNode(-999);
    	ListNode ptrX = dummyHead;
    	ListNode ptr1 = l1;
    	ListNode ptr2 = l2;
    	while(ptr1 != null && ptr2 != null){
    		if(ptr1.val < ptr2.val){
    			ptrX.next = ptr1;
    			ptrX = ptrX.next;
    			ptr1 = ptr1.next;
    		}else{
    			ptrX.next = ptr2;
    			ptrX = ptrX.next;
    			ptr2 = ptr2.next;
    		}
    	}
    	
    	if(ptr1 != null)
    		ptrX.next = ptr1;
    	else if(ptr2 != null)
    		ptrX.next = ptr2;
    	else
    		;
    	
    	return dummyHead.next;
    }
}
