package baodavi;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	 class RandomListNode {
	     int label;
	     RandomListNode next, random;
	     RandomListNode(int x) { this.label = x; }
	 };
	 
	// my original way - error prone, 9/12 test cases passed
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null)	return null;
    	
        Map<Integer, RandomListNode> randNodePos1 = new HashMap<>();
        Map<RandomListNode, Integer> randNodePos2 = new HashMap<>();
        Map<Integer, RandomListNode> randNodeRef = new HashMap<>();
        RandomListNode newHead = null;
        RandomListNode runner = null;
        int index = 0;
        while(head.next != null || newHead == null){
        	// initial case
        	if(newHead == null){
        		newHead = new RandomListNode(head.label);
        		runner = newHead;
        		if(head.random != null){
        			randNodePos1.put(0, head.random);
        			randNodePos2.put(head, 0);
        			randNodeRef.put(0, newHead);
        		}
        	}else{
        		RandomListNode newNode = new RandomListNode(head.next.label);
        		runner.next = newNode;
        		runner = runner.next;
        		head = head.next;
        		if(head.random != null){
        			randNodePos1.put(index, head.random);
        			randNodePos2.put(head, index);
        			randNodeRef.put(index, runner);
        		}
        	}
        	index++;
        }
        runner = newHead;
        index = 0;
        while(runner != null){
        	if(randNodePos1.containsKey(index)){
        		runner.random = randNodeRef.get(randNodePos2.get(randNodePos1.get(index)));
        	}
        	runner = runner.next;
        	index++;
        }
        return newHead;
    }
    
    // ONLY 1 mapping
    public RandomListNode copyRandomListRefI(RandomListNode head) {
    	if(head == null)	return null;
    	
    	Map<RandomListNode, RandomListNode> mapping = new HashMap<>();
    	
    	// loop 1 - copy all the nodes
    	RandomListNode runner = head;
    	while(runner != null){
    		mapping.put(runner, new RandomListNode(runner.label));
    		runner = runner.next;
    	}
    	
    	// loop 2 - assign next and random pointers
    	runner = head;
    	while(runner != null){
    		mapping.get(runner).next = mapping.get(runner.next);
    		mapping.get(runner).random = mapping.get(runner.random);
    		runner = runner.next;
    	}
    	
    	return mapping.get(head);
    }
    
    // black magic - O(1) space 
    public RandomListNode copyRandomListRefII(RandomListNode head) {
    	RandomListNode runner = head;
    	RandomListNode next = null;
    	
    	// First round: make copy of each node,
    	// and link them together side-by-side in a single list.    	
    	while(runner != null){
    		next = runner.next;
    		RandomListNode copy = new RandomListNode(runner.label);
    		copy.next = next;
    		runner.next = copy;
    		runner = next;
    	}
    	
    	// Second round: assign random pointers for the copy nodes.
    	runner = head;
    	while(runner != null){
    		if(runner.random != null){
    			runner.next.random = runner.random.next;
    		}
    		runner = runner.next.next;
    	}
    	
    	// Third round: restore the original list, and extract the copy list.
    	runner = head;
    	RandomListNode pseudoHead = new RandomListNode(0);
    	RandomListNode dupNode, dupRunner;
    	dupRunner = pseudoHead;
    	while(runner != null){
    		next = runner.next.next;
    		// extract the duplicated list
    		dupNode = runner.next;
    		dupRunner.next = dupNode;
    		dupRunner = dupNode;
    		// restore the original list
    		runner.next = next;
    		runner = next;
    	}
    	
    	return pseudoHead.next;
    }
}






























