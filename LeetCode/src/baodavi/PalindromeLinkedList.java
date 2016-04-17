package baodavi;

public class PalindromeLinkedList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public class Magic{
		boolean res;
		ListNode magicNode;
		Magic(boolean res, ListNode node){
			this.res = res;
			this.magicNode = node;
		}
	}
	
    public boolean isPalindrome(ListNode head) {
    	int len = 0;
    	ListNode curr = head;
    	while(curr != null){
    		len++;
    		curr = curr.next;
    	}
    	
    	if(len == 0 || len == 1)
    		return true;
    	
    	return isPalindromeHelper(1, len, head).res;
    }
    
    private Magic isPalindromeHelper(int currIdx, int len, ListNode currPtr){
    	if(currIdx == len / 2){
    		ListNode magicPtr;
    		if(len % 2 == 0)
    			magicPtr = currPtr.next;
    		else
    			magicPtr = currPtr.next.next;
    		if(currPtr.val == magicPtr.val){
    			return new Magic(true, magicPtr.next);
    		}else{
    			return new Magic(false, null);
    		}
    	}
    	
    	Magic myMagic = isPalindromeHelper(currIdx + 1, len, currPtr.next);
    	if(myMagic.res){
    		if(currPtr.val == myMagic.magicNode.val){
    			myMagic.magicNode = myMagic.magicNode.next;
    		}else{
    			myMagic.res = false;
    			myMagic.magicNode = null;
    		}
    	}
    	return myMagic;
    }
    
    public static void main(String args[]){
    	PalindromeLinkedList obj = new PalindromeLinkedList();
    	PalindromeLinkedList.ListNode n1 = obj.new ListNode(0);
    	PalindromeLinkedList.ListNode n2 = obj.new ListNode(2);
    	PalindromeLinkedList.ListNode n3 = obj.new ListNode(2);
    	PalindromeLinkedList.ListNode n4 = obj.new ListNode(1);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	
    	obj.isPalindrome(n1);
    }
}
