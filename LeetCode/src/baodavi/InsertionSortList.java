package baodavi;

public class InsertionSortList {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}	
	
    public ListNode insertionSortList(ListNode head) {
        
    	if(head == null)
    		return null;
    	
    	ListNode dummyHead = new ListNode(-999);
        
        ListNode curr = head;
        ListNode currNext = curr.next;
        while(curr != null){
        	ListNode insert = dummyHead;
        	boolean insertFlag = false;
        	while(insert.next != null){
        		if(curr.val < insert.next.val){
        			curr.next = insert.next;
        			insert.next = curr;
        			insertFlag = true;
        			break;
        		}else
        			insert = insert.next;
        	}
        	if(!insertFlag){
        		curr.next = null;
        		insert.next = curr;
        	}
        	
        	if(currNext == null)
        		break;
        	else{
        		curr = currNext;
        		currNext = currNext.next;
        	}
        }
        
        return dummyHead.next;
    }
    
    public static void main(String args[]){
    	InsertionSortList x = new InsertionSortList();
    	
    	ListNode n1 = x.new ListNode(2);
    	ListNode n2 = x.new ListNode(1);
    	n1.next = n2;
    	x.insertionSortList(n1);
    }
}
