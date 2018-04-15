package baodavi;

public class SetMatrixZeroes {
	/*
	1.先确定第一行和第一列是否需要清零
	2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
	3.根据第一行和第一列的信息，已经可以讲剩下的矩阵元素赋值为结果所需的值了
	4.根据1中确定的状态，处理第一行和第一列。
	*/
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			if(i == 0)	firstRow = true;
        			if(j == 0)	firstCol = true;
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstCol) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
