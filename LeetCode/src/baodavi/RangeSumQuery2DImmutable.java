package baodavi;

/*
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ¡Ü row2 and col1 ¡Ü col2.
 */

public class RangeSumQuery2DImmutable {
	
	private int[][] DP;
	
    public RangeSumQuery2DImmutable(int[][] matrix) {
    	
    	// edge cases...
    	if(matrix == null)
    		return;
    	else if(matrix.length <= 0)
    		return;
    	else if(matrix[0].length <= 0)
    		return;
    	
        DP = new int[matrix.length][matrix[0].length];
        int sum1, sum2;
        sum1 = sum2 = 0;
        for(int row = 0; row < matrix.length; row++){
        	sum1 += matrix[row][0];
        	DP[row][0] = sum1;
        }
        for(int col = 0; col < matrix[0].length; col++){
        	sum2 += matrix[0][col];
        	DP[0][col] = sum2;
        }
        
        for(int i = 1; i < matrix.length; i++){
        	for(int j = 1; j < matrix[0].length; j++){
        		DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + matrix[i][j];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0){
        	return DP[row2][col2];
        }else if(row1 == 0){
        	return DP[row2][col2] - DP[row2][col1-1];
        }else if(col1 == 0){
        	return DP[row2][col2] - DP[row1-1][col2];
        }else{
        	return DP[row2][col2] - DP[row1-1][col2] - DP[row2][col1-1] + DP[row1-1][col1-1];
        }
    }
}

//Your NumMatrix object will be instantiated and called as such:
//NumMatrix numMatrix = new NumMatrix(matrix);
//numMatrix.sumRegion(0, 1, 2, 3);
//numMatrix.sumRegion(1, 2, 3, 4);