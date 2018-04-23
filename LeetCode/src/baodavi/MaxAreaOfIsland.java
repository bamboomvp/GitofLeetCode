package baodavi;

import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0){
        	return res;
        }
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
    			int localRes = maxAreaOfIslandHelper(grid, i, j, visited);
    			res = Math.max(res, localRes);
        	}
        }
        return res;
    }
    
    private int maxAreaOfIslandHelper(int[][] grid, int i, int j, Set<String> visited) {
    	if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
    		return 0;
    	}else if(grid[i][j] == 0){
    		return 0;
    	}else if(visited.contains(i + "," + j)){
    		return 0;
    	}
    	int cnt = 1;
    	visited.add(i + "," + j);
    	cnt += maxAreaOfIslandHelper(grid, i - 1, j, visited);
    	cnt += maxAreaOfIslandHelper(grid, i + 1, j, visited);
    	cnt += maxAreaOfIslandHelper(grid, i, j - 1, visited);
    	cnt += maxAreaOfIslandHelper(grid, i, j + 1, visited);
    	return cnt;
    }
}
