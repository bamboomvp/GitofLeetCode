package baodavi;

/*
��⣺

�������I���������Ҫ�������ظ���nodeɾ������ˣ���������I��ȥ�صķ���������˫ָ�룬��������һ���µ�ָ�룬
ָ��ǰ��ǰһ��node��ʹ��3��ָ�루prev��current��post������������ 

 �ʼ������Ҫ����һ��fakehead����fakehead��nextָ��head��Ȼ��ʹ���Ҹղ�˵����3��ָ�뷽������ʼ��3��ָ�룬���£� 

  ListNode ptr0 = fakehead; //prev
  ListNode ptr1 = fakehead.next; //current
  ListNode ptr2 = fakehead.next.next; //post

ͬʱ����Ҫ����һ�������͵��ж�flag���������жϵ�ǰ�Ƿ��������ظ������flag�ܰ���ʶ���Ƿ���Ҫɾ���ظ���

 ��û�������ظ�ֵ��flagΪfalse��ʱ��3��ָ��ͬʱ�����ƶ���

 ptr0 = ptr1;

 ptr1 = ptr2;

 ptr2 = ptr2.next; 

�������ظ�ֵʱ������flagΪtrue������ptr2һֱ�������ҵ���һ����ptr1ֵ���ȵ�λ��ʱֹͣ��
��ʱ��ptr1ָ���node��ֵ��һ���ظ�ֵ����Ҫɾ����������ʱ����Ҫ��ptr0��next���ϵ�ǰ��ptr2�������Ͱ������ظ�ֵ�Թ��ˡ�
Ȼ����ptr1��ptr2����Ų���������ҡ�

���ﻹ��Ҫע����ǣ���ptr2һֱ�����ҵĹ����У����п���ptr2==null�������������list����󼸸�Ԫ�����ظ��ģ�����1->2->3->3->null)��
��ʱptr1ָ���ֵ�϶�����Ҫ��ɾ���ģ�����Ҫ���⴦����ptr0��next����null�����ظ�ֵɾ����
�������˵����󼸸�Ԫ�ز��ظ�������Ҫ�����β�������͹��ˡ�

*/

public class RemoveDuplicatesFromSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	
    	// special case, linked list ONLY contains 0-1 element
    	if(head == null || head.next == null)
    		return head;
    	
    	// normal case, linked list contains 2+ elements
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	
    	ListNode ptr0 = fakeHead;
    	ListNode ptr1 = fakeHead.next;
    	ListNode ptr2 = fakeHead.next.next;
    	
    	boolean flag = false;
    	while(ptr2 != null){
    		if(ptr1.val == ptr2.val){
    			flag = true;
    			ptr2 = ptr2.next;
    			if(ptr2 == null)
    				ptr0.next = null;
    		}else{
    			if(flag){
    				ptr0.next = ptr2;
    				flag = false;
    			}else{
    				ptr0 = ptr1;
    			}
    			ptr1 = ptr2;
    			ptr2 = ptr2.next;
    		}
    	}
    	return fakeHead.next;
    }	
}
