package baodavi;

import java.util.HashSet;
import java.util.Set;

public class InterleavingString {
	
	public boolean isInterleaveDP(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
        	return false;
        }
        int n = s1.length() + 1;
        int m = s2.length() + 1;
        boolean[][] dp = new boolean[n][m];
        // init
        dp[0][0] = true;
        for(int i = 1; i < n; i++){
        	dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i -1)); 
        }
        for(int j = 1; j < m; j++){
        	dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j -1)); 
        }
        // func
        for(int i = 1; i < n; i++){
        	for(int j = 1; j < m; j++){
        		dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) 
        				|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
        	}
        }
        // answer
        return dp[n - 1][m - 1];
	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
        	return false;
        }
        Set<Integer> failCases = new HashSet<>();
        return isInterleaveHelper(s1, s1.length() - 1, s2, s2.length() - 1, s3, s3.length() - 1, failCases);
    }
    
    private boolean isInterleaveHelper(String s1, int i, String s2, int j, String s3, int k, Set<Integer> failCases){
    	int key = i * s3.length() + j;
    	if(failCases.contains(key))	return false;
    	// base cases
    	if(i < 0){
    		return s2.substring(0, j + 1).equals(s3.substring(0, k + 1));
    	}else if(j < 0){
    		return s1.substring(0, i + 1).equals(s3.substring(0, k + 1));
    	}
    	
    	if((s3.charAt(k) == s1.charAt(i) && isInterleaveHelper(s1, i - 1, s2, j, s3, k - 1, failCases)) || 
    		(s3.charAt(k) == s2.charAt(j) && isInterleaveHelper(s1, i, s2, j - 1, s3, k - 1, failCases)))
    		return true;
    	else{
    		failCases.add(key);
    		return false;
    	}
//    	if(s3.charAt(k) != s1.charAt(i) && s3.charAt(k) != s2.charAt(j)){
//    		return false;
//    	}else if(s3.charAt(k) != s1.charAt(i)){
//    		return isInterleaveHelper(s1, i, s2, j - 1, s3, k - 1);
//    	}else if(s3.charAt(k) != s2.charAt(j)){
//    		return isInterleaveHelper(s1, i - 1, s2, j, s3, k - 1);
//    	}else{
//    		return isInterleaveHelper(s1, i, s2, j - 1, s3, k - 1) || isInterleaveHelper(s1, i - 1, s2, j, s3, k - 1);
//    	}
    }
}
