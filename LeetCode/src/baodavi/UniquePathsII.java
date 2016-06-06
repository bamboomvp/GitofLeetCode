package baodavi;

public class UniquePathsII {
	// DP it out!
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
    	if(obstacleGrid == null || obstacleGrid[0] == null)
    		return 0;
    	
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
        if(m < 1 || n < 1)
        	return 0;
        else if(obstacleGrid[0][0] == 1)
        	return 0;
    	
    	int[][] DP = new int[m][n];
        DP[0][0] = 1; // initial value
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(obstacleGrid[i][j] == 1)
        			continue;
        		
        		if(i == 0 && j == 0)
        			continue;
        		else{
        			int val1, val2;
        			val1 = val2 = 0;
        			if(i != 0 && obstacleGrid[i - 1][j] == 0)
        				val1 = DP[i - 1][j];
        			if(j != 0 && obstacleGrid[i][j - 1] == 0)
        				val2 = DP[i][j - 1];
        			DP[i][j] = val1 + val2;
        		}
        	}
        }
        return DP[m - 1][n - 1];
    }
}
