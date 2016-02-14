package baodavi;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	private class Node {
		public String val;
		public int path;

		public Node(String val, int path) {
			this.val = val;
			this.path = path;
		}
	}

	public int ladderLength(String start, String end, Set<String> dict) {
		if (!dict.contains(start) || !dict.contains(end)) {
			return 0;
		}

		Queue<Node> toSearch = new LinkedList<Node>();
		Set<String> searched = new HashSet<String>();

		toSearch.add(new Node(start, 1));
		searched.add(start);
		while (!toSearch.isEmpty()) {
			Node curr = toSearch.remove();

			for (int i = 0; i < curr.val.length(); i++) {
				char[] currCharArr = curr.val.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					String candidate = new String(currCharArr);
					if (candidate.equals(end)) {
						return curr.path + 1;
					}

					if (!searched.contains(candidate)
							&& dict.contains(candidate)) {
						Node next = new Node(candidate, curr.path + 1);
						toSearch.add(next);
						searched.add(next.val);
					}
				}
			}
		}

		return 0;
	}
}
