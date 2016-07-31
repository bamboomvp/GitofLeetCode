package baodavi;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return 0;
        else if(matrix[0].length == 0)
        	return 0;
        else{
        	int m = matrix.length; 		// number of rows
        	int n = matrix[0].length; 		// number of cols
        	int max = 0;
        	int[][] dp = new int[m][n];
        	
        	// assignment for the 1st cols
        	for(int i = 0; i < m; i++){
        		dp[i][0] = matrix[i][0] - '0';
        		max = Math.max(max, dp[i][0]);
        	}
        	// assignment for the 1st rows
        	for(int j = 0; j < n; j++){
        		dp[0][j] = matrix[0][j] - '0';
        		max = Math.max(max, dp[0][j]);
        	}
        	// DP starts
        	for(int x = 1; x < m; x++){
        		for(int y = 1; y < n; y++){
        			if(matrix[x][y] == '1')
        				dp[x][y] = Math.min(dp[x-1][y-1], Math.min(dp[x-1][y], dp[x][y-1])) + 1;
        			else
        				dp[x][y] = 0;
        			max = Math.max(max, dp[x][y]);
        		}
        	}
        	
        	return max * max;
        }
    }
}
