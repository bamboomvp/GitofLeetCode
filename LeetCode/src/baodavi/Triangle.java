package baodavi;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.isEmpty()) {
			return Integer.MAX_VALUE;
		}

		int numRows = triangle.size();
		int numCols = triangle.get(numRows - 1).size();
		// actually, only needs space O(n), we can override the previous layer
		int[][] bookkeeping = new int[numRows][numCols];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == 0) {
					bookkeeping[i][j] = triangle.get(i).get(j);
				} else if (j == 0) {
					bookkeeping[i][j] = triangle.get(i).get(j)
							+ bookkeeping[i - 1][j];
				} else if (j == i) {
					bookkeeping[i][j] = triangle.get(i).get(j)
							+ bookkeeping[i - 1][j - 1];
				} else {
					bookkeeping[i][j] = triangle.get(i).get(j)
							+ Math.min(bookkeeping[i - 1][j - 1],
									bookkeeping[i - 1][j]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int k = 0; k < numCols; k++) {
			min = Math.min(min, bookkeeping[numRows - 1][k]);
		}

		return min;
	}

	public int minimumTotal2(List<List<Integer>> triangle) {
		if (triangle == null || triangle.isEmpty()) {
			return 0;
		}

		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int[] minSum = new int[triangle.size()];
		for (int col = 0; col < triangle.size(); col++) {
			minSum[col] = triangle.get(triangle.size() - 1).get(col);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				minSum[j] = Math.min(minSum[j], minSum[j + 1])
						+ triangle.get(i).get(j);
			}
		}

		return minSum[0];
	}
}
