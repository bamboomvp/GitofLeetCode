package baodavi;

public class NQueensII {
    public int totalNQueens(int n) {
        int[] tracking = new int[n];
        return searchDFS(n, 0, tracking);
    }
    
	private int searchDFS(int n, int i, int[] tracking){
		if(i == n){
			return 1;
		}
		int cnt = 0;
		for(int j = 0; j < n; j++){
			if(!isValid(tracking, i, j)){
				continue;
			}
			tracking[i] = j;
			cnt += searchDFS(n, i + 1, tracking);
		}
		return cnt;
	}
	
	private boolean isValid(int[] tracking, int i, int j){
		for(int k = 0; k < i; k++){
			if(j == tracking[k])						return false;
			else if(i - j == k - tracking[k])	return false;
			else if(i + j == k + tracking[k])	return false;
		}
		return true;
	}    
}
