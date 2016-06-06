package baodavi;

public class MergeTwoSortedLists {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
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
