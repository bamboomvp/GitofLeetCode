package baodavi;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0){
        	return 0;
        }else if(A.length == 1 || A.length == 2){
        	return 0;
        }else{
        	boolean[][] dp = new boolean[A.length][A.length];
        	int cnt = 0;
        	for(int len = 3; len <= A.length; len++){
        		for(int start = 0; start + len - 1 < A.length; start++){
        			if(len == 3){
        				dp[start][start + len - 1] = A[start] - A[start + 1] == A[start + 1] - A[start + 2];
        			}else{
        				if(dp[start][start + len - 2]){
        					dp[start][start + len - 1] = A[start] - A[start + 1] == A[start + len - 2] - A[start + len - 1];
        				}
        			}
        			if(dp[start][start + len - 1])	cnt++;
        		}
        	}
        	return cnt;
        }
    }
}
