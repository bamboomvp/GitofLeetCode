package baodavi;
import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

	private class Pair {
		public int low;
		public int high;

		public Pair(int l, int h) {
			this.low = l;
			this.high = h;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair thatObj = (Pair) o;
				return this.low == thatObj.low && this.high == thatObj.high;
			}
			return false;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.low;
			result = prime * result + this.high;
			return result;
		}
	}

	private Map<Pair, Integer> book = new HashMap<Pair, Integer>();

	private int numTreesHelper(int low, int high) {
		if (low == high) {
			return 1;
		}

		Pair hashedKey = new Pair(low, high);
		if (book.containsKey(hashedKey)) {
			return book.get(hashedKey);
		}

		int options = 0;
		for (int k = low + 1; k < high; k++) {
			options += numTreesHelper(low, k - 1) * numTreesHelper(k + 1, high);
		}
		options += numTreesHelper(low + 1, high);
		options += numTreesHelper(low, high - 1);

		book.put(new Pair(low, high), options);
		return options;
	}

	public int numTrees(int n) {
		return numTreesHelper(1, n);
	}
}
