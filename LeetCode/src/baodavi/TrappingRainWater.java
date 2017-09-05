package baodavi;

public class TrappingRainWater {
	// so-called DP
    public int trap1(int[] A) {
        int res = 0;
        if(A == null || A.length < 2)
        	return res;
        else{
        	int[] leftMaxHeight = new int[A.length];
        	int[] rightMaxHeight = new int[A.length];
        	for(int m = 0; m < A.length; m++){
        		if(m != 0)	leftMaxHeight[m] = Math.max(leftMaxHeight[m - 1], A[m]);
        		else	leftMaxHeight[m] = A[m];
        	}
        	for(int n = A.length - 1; n >= 0; n--){
        		if(n != A.length - 1)	rightMaxHeight[n] = Math.max(rightMaxHeight[n + 1], A[n]);
        		else	rightMaxHeight[n] = A[n];
        	}
        	for(int i = 0; i < A.length; i++){
        		if(i == 0) continue;
        		else if(i == A.length - 1) continue;
        		else{
        			int leftMax = leftMaxHeight[i - 1];
        			int rightMax = rightMaxHeight[i + 1];
        			int val = Math.min(leftMax, rightMax) - A[i];
        			if(val > 0)	res += val;
        		}
        	}
        	return res;
        }
    }
    
    public int trap2(int[] A) {
        return 0;
    }
    
    public int trap3(int[] A) {
        return 0;
    }
}
