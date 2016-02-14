package baodavi;
public class RotateImage {
	public void rotate(int[][] matrix) {
		int layers = matrix.length / 2;
		for (int l = 0; l < layers; l++) {
			int moves = matrix.length - (l * 2) - 1;
			int limit = matrix.length - l - 1;
			for (int i = 0; i < moves; i++) {
				int tmp = matrix[l][l + i];
				matrix[l][l + i] = matrix[limit - i][l];
				matrix[limit - i][l] = matrix[limit][limit - i];
				matrix[limit][limit - i] = matrix[l + i][limit];
				matrix[l + i][limit] = tmp;
			}
		}
	}
}
