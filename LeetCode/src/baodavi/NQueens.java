package baodavi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

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
