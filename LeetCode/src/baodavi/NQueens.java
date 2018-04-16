package baodavi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	
	// UPDATE 2018, fancy
    public List<List<String>> solveNQueensFancy(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] tracking = new int[n]; // tracking[i] means the ith row Queue puts on tracking[i]th column
        searchDFS(n, 0, tracking, res);
        return res;
    }
	
	private void searchDFS(int n, int i, int[] tracking, List<List<String>> res){
		if(i == n){
			res.add(drawBoard(tracking));
			return;
		}
		
		for(int j = 0; j < n; j++){
			if(!isValid(tracking, i, j)){
				continue;
			}
			tracking[i] = j;
			searchDFS(n, i + 1, tracking, res);
		}
	}
	
	private boolean isValid(int[] tracking, int i, int j){
		for(int k = 0; k < i; k++){
			if(j == tracking[k])						return false;
			else if(i - j == k - tracking[k])	return false;
			else if(i + j == k + tracking[k])	return false;
		}
		return true;
	}
	
	private List<String> drawBoard(int[] tracking){
		List<String> board = new ArrayList<>();
		for(int i = 0; i < tracking.length; i++){
			String oneRow = "";
			for(int j = 0; j < tracking.length; j++){
				if(j == tracking[i])		oneRow += "Q";
				else							oneRow += ".";
			}
			board.add(oneRow);
		}
		return board;
	}
	
	
	
	
	
	private boolean checking(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) == Math.abs(y1 - y2);
	}

	private void solveNQueensHelper(List<Integer> curr, int level, int total,
			List<String[]> res) {
		if (level == total) {
			String[] sol = new String[total];
			for (int k = 0; k < curr.size(); k++) {
				String tmpStr = "";
				for (int x = 0; x < total; x++) {
					if (x != curr.get(k)) {
						tmpStr += ".";
					} else {
						tmpStr += "Q";
					}
				}
				sol[k] = new String(tmpStr);
			}
			res.add(sol);
			return;
		}

		for (int i = 0; i < total; i++) {
			if (!curr.contains(i)) {
				boolean flag = true;
				for (int j = 0; j < curr.size(); j++) {
					if (checking(j, curr.get(j), level, i)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					curr.add(i);
					solveNQueensHelper(curr, level + 1, total, res);
					curr.remove((Object) i);
				}
			}
		}
	}

	public List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
		solveNQueensHelper(new ArrayList<Integer>(), 0, n, res);
		return res;
	}
	
	public static void main(String[] args){
		NQueens ins = new NQueens();
		List<String[]> res = ins.solveNQueens(4);
		for(String[] row : res){
			System.out.println(Arrays.toString(row));
		}
	}
}
