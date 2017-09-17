package baodavi;

public class ConvertSortedListToBinarySearchTree {
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	public TreeNode sortedListToBSTRef1(ListNode head) {
	    if(head == null)	return null;
	    else return toBST(head, null);
	}
	private TreeNode toBST(ListNode head, ListNode tail /* exclusive */){
		ListNode slow = head;
		ListNode fast = head;
		if(head == tail)	return null;
		
		// get to the middle element
		while(fast != tail && fast.next != tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode thead = new TreeNode(slow.val);
		thead.left = toBST(head, slow);
		thead.right = toBST(slow.next, tail);
		return thead;
	}
	
	private ListNode node;
	
	public TreeNode sortedListToBSTRef2(ListNode head) {
	    if(head == null)	return null;
	    else{
	    	int size = 0;
	    	ListNode runner = head;
	    	while(runner != null){
	    		runner = runner.next;
	    		size++;
	    	}
	    	node = head;
	    	return inorderHelper(0, size - 1);
	    }
	}
	private TreeNode inorderHelper(int start, int end){
		if(start > end){
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode left = inorderHelper(start, mid - 1);
		TreeNode treenode = new TreeNode(node.val);
		node = node.next;
		TreeNode right = inorderHelper(mid + 1, end);
		treenode.left = left;
		treenode.right = right;
		return treenode;
	}
}
