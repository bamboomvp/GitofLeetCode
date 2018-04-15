package baodavi;

public class SetMatrixZeroes {
	/*
	1.��ȷ����һ�к͵�һ���Ƿ���Ҫ����
	2.ɨ��ʣ�µľ���Ԫ�أ����������0���ͽ���Ӧ�ĵ�һ�к͵�һ���ϵ�Ԫ�ظ�ֵΪ0
	3.���ݵ�һ�к͵�һ�е���Ϣ���Ѿ����Խ�ʣ�µľ���Ԫ�ظ�ֵΪ��������ֵ��
	4.����1��ȷ����״̬�������һ�к͵�һ�С�
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
