package baodavi;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
    		return new ArrayList<>();
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
        boolean[][] pacificFlow = new boolean[m][n];
        boolean[][] atlanticFlow = new boolean[m][n];
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		boolean[][] visited = new boolean[m][n];
        		dfs(i, j, i, j, matrix, pacificFlow, atlanticFlow, visited);
        	}
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(pacificFlow[i][j] && atlanticFlow[i][j])
        			res.add(new int[]{i, j});
        	}
        }
        return res;
    }
    
    private void dfs(int i, int j, int x, int y, int[][] matrix, boolean[][] pacificFlow, boolean[][] atlanticFlow, boolean[][] visited){
    	if(i == 0 || j == 0)														pacificFlow[x][y] = true;
    	if(i == matrix.length - 1 || j == matrix[0].length - 1)		atlanticFlow[x][y] = true;
    	if(pacificFlow[i][j])													pacificFlow[x][y] = true;
    	if(atlanticFlow[i][j])													atlanticFlow[x][y] = true;
    	if(pacificFlow[x][y] && atlanticFlow[x][y])
    		return; // shortcut, no need to search
    	visited[i][j] = true;
    	// go up?
    	if(i - 1 >= 0 && !visited[i - 1][j] && matrix[i - 1][j] <= matrix[i][j])
    		dfs(i - 1, j, x, y, matrix, pacificFlow, atlanticFlow, visited);
    	// go down?
    	if(i + 1 <= matrix.length - 1 && !visited[i + 1][j] && matrix[i + 1][j] <= matrix[i][j])
    		dfs(i + 1, j, x, y, matrix, pacificFlow, atlanticFlow, visited);
    	// go left?
    	if(j - 1 >= 0 && !visited[i][j - 1] && matrix[i][j - 1] <= matrix[i][j])
    		dfs(i, j - 1, x, y, matrix, pacificFlow, atlanticFlow, visited);
    	// go right?
    	if(j + 1 <= matrix[0].length - 1 && !visited[i][j + 1] && matrix[i][j + 1] <= matrix[i][j])
    		dfs(i, j + 1, x, y, matrix, pacificFlow, atlanticFlow, visited);
    }
}
