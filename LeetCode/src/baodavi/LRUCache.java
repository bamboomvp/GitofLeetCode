package baodavi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	public class Node {
		Integer key;
		int val;
		Node pre;
		Node next;

		public Node(Integer key, int val) {
			this.key = key;
			this.val = val;
			pre = next = null;
		}
	}

	Map<Integer, Node> lookupMap;
	Node first, last;
	int capacity;

	public LRUCache(int capacity) {
		lookupMap = new HashMap<Integer, Node>();
		first = null;
		last = null;
		this.capacity = capacity;
	}

	public int get(int key) {
		if (lookupMap.containsKey((Object) key)) {
			Node curr = lookupMap.get((Object) key);

			// special case, only 1 element
			if (first == last) {
				return curr.val;
			} else {
				if(curr == first){
					return curr.val;
				}
				
				if (curr == last) {
					last = last.pre;
				}

				if (curr.pre != null) {
					curr.pre.next = curr.next;
				}
				if (curr.next != null) {
					curr.next.pre = curr.pre;
				}

				curr.pre = null;
				curr.next = first;
				first.pre = curr;
				first = curr;

				return curr.val;
			}
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (!lookupMap.containsKey((Object) key)) {
			if (lookupMap.size() == capacity) {
				lookupMap.remove((Object) last.key);

				// special case, only 1 element
				if (first == last) {
					first = last = null;
				} else {
					last.pre.next = null;
					last = last.pre;
				}
			}
			Node tmp = new Node(key, value);
			lookupMap.put(tmp.key, tmp);

			tmp.pre = null;
			tmp.next = first;
			if (first != null) {
				first.pre = tmp;
			}
			first = tmp;

			if (last == null) {
				last = first;
			}
		}else{
			Node curr = lookupMap.get((Object) key);
			curr.val = value;
			if(curr == first){
				return;
			}else{
				if(curr == last){
					last = last.pre;
				}
				
				curr.pre.next = curr.next;
				
				if (curr.next != null) {
					curr.next.pre = curr.pre;
				}

				curr.pre = null;
				curr.next = first;
				first.pre = curr;
				first = curr;
			}
		}
	}
	
	public static void main(String[] argv){
		//[set(2,1),set(3,2),get(3),get(2),set(4,3),get(2),get(3),get(4)]

		LRUCache ins = new LRUCache(2);
		ins.set(2, 1);
		ins.set(3, 2);
		ins.get(3);
		ins.get(2);
		ins.set(4, 3);
		ins.get(2);
		ins.get(3);
		ins.get(4);
	}
}
