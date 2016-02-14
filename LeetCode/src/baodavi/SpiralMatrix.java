package baodavi;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int rowLen = matrix.length;
		if (rowLen == 0) {
			return new ArrayList<Integer>();
		}
		int colLen = matrix[0].length;
		if (colLen == 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> res = new ArrayList<Integer>();
		int layers = 0;
		if (Math.min(rowLen, colLen) % 2 == 0)
			layers = Math.min(rowLen, colLen) / 2;
		else
			layers = (Math.min(rowLen, colLen) / 2) + 1;

		for (int currLayer = 0; currLayer < layers; currLayer++) {
			if (currLayer == rowLen - 1 - currLayer) {
				for (int i = currLayer; i <= colLen - 1 - currLayer; i++) {
					res.add(matrix[currLayer][i]);
				}
				return res;
			}

			if (currLayer == colLen - 1 - currLayer) {
				for (int j = currLayer; j <= rowLen - 1 - currLayer; j++) {
					res.add(matrix[j][currLayer]);
				}
				return res;
			}

			// top
			for (int i = currLayer; i < colLen - 1 - currLayer; i++) {
				res.add(matrix[currLayer][i]);
			}
			// right
			for (int j = currLayer; j < rowLen - 1 - currLayer; j++) {
				res.add(matrix[j][colLen - 1 - currLayer]);
			}
			// bottom
			for (int m = colLen - 1 - currLayer; m > currLayer; m--) {
				res.add(matrix[rowLen - 1 - currLayer][m]);
			}
			// left
			for (int n = rowLen - 1 - currLayer; n > currLayer; n--) {
				res.add(matrix[n][currLayer]);
			}
		}

		return res;
	}
}
