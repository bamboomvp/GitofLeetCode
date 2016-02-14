package baodavi;
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		// rule 1 - Each row must have the numbers 1-9 occuring just once
		for (int i = 0; i < 9; i++) {
			boolean[] checking = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					;
				} else {
					if (checking[(board[i][j] - '1')] == true) {
						return false;
					} else {
						checking[(board[i][j] - '1')] = true;
					}
				}
			}
		}

		// rule 2 - Each column must have the numbers 1-9 occuring just once
		for (int m = 0; m < 9; m++) {
			boolean[] checking = new boolean[9];
			for (int n = 0; n < 9; n++) {
				if (board[n][m] == '.') {
					;
				} else {
					if (checking[(board[n][m] - '1')] == true) {
						return false;
					} else {
						checking[(board[n][m] - '1')] = true;
					}
				}
			}
		}

		// rule 3 - And the numbers 1-9 must occur just once in each of the 9
		// sub-boxes of the grid
		for (int k = 0; k < 9; k++) {
			boolean[] checking = new boolean[9];
			int x = (k / 3) * 3;
			int y = (k % 3) * 3;
			for (int dx = 0; dx < 3; dx++) {
				for (int dy = 0; dy < 3; dy++) {
					if (board[x + dx][y + dy] == '.') {
						;
					} else {
						if (checking[(board[x + dx][y + dy] - '1')] == true) {
							return false;
						} else {
							checking[(board[x + dx][y + dy] - '1')] = true;
						}
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] argv) {
		// [".........","......3..","...18....","...7.....","....1.97.",".........","...36.1..",".........",".......2."]
		String[] input = new String[] { ".........", "......3..", "...18....",
				"...7.....", "....1.97.", ".........", "...36.1..",
				".........", ".......2." };
		char[][] board = new char[input.length][0];
		int i = 0;
		for (String s : input) {
			board[i] = s.toCharArray();
			i++;
		}
		new ValidSudoku().isValidSudoku(board);
	}
}
