package baodavi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	private class Node {
		public String currVal;
		public List<String> vals;
		public int path;

		public Node(String currVal, List<String> vals, int path) {
			this.currVal = currVal;
			this.vals = vals;
			this.path = path;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				return currVal == ((Node) o).currVal
						&& vals.equals(((Node) o).vals)
						&& path == ((Node) o).path;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int prime = 31;
			int res = 1;
			for (String val : vals) {
				res = res * prime + val.hashCode();
			}
			res += currVal.hashCode();
			res += path;
			return res;
		}
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();

		// special case, check before processing
		if (!dict.contains(start) || !dict.contains(end)) {
			return res;
		}

		Queue<Node> toSearch = new LinkedList<Node>();
		Set<Node> searched = new HashSet<Node>();
		int globalMin = 0;

		List<String> init = new ArrayList<String>();
		init.add(start);
		Node initNode = new Node(start, init, 1);
		toSearch.add(initNode);
		searched.add(initNode);
		while (!toSearch.isEmpty()) {
			Node curr = toSearch.remove();

			for (int i = 0; i < curr.currVal.length(); i++) {
				char[] currCharArr = curr.currVal.toCharArray();
				boolean shortCut = false;
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					String candidate = new String(currCharArr);

					// short-cut
					if (!dict.contains(candidate)
							|| c == curr.currVal.charAt(i))
						continue;

					List<String> newVals = new ArrayList<String>(curr.vals);
					newVals.add(candidate);
					Node next = new Node(candidate, newVals, curr.path + 1);

					if (next.currVal.equals(end)
							&& (next.path == globalMin || globalMin == 0)) {
						res.add(next.vals);
						globalMin = next.path;
						shortCut = true;
						break;
					}

					if (!searched.contains(next)
							&& (next.path < globalMin || globalMin == 0)) {
						toSearch.add(next);
						searched.add(next);
					}
				}
				if (shortCut) {
					break;
				}
			}
		}

		return res;
	}
}
