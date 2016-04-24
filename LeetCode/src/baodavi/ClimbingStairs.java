package baodavi;

/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
public class ClimbingStairs {
	
	// Let's DP it!
    public int climbStairs(int n) {
    	if(n < 0){
    		return 0;
    	}else if(n == 0 || n == 1){
    		return 1;
    	}
    	
    	int[] DP = new int[n + 1];
    	DP[0] = 1;
    	DP[1] = 1;
    	for(int i = 2; i < DP.length; i++){
    		DP[i] = DP[i-1] + DP[i-2];
    	}
    	
    	return DP[n];
    }
}
