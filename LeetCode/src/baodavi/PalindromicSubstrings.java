package baodavi;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int len = 1; len <= s.length(); len++){
        	for(int start = 0; start + len <= s.length(); start++){
        		if(len == 1)	dp[start][start+len-1] = true;
        		else if(len == 2){
        			if(s.charAt(start) == s.charAt(start + 1))	dp[start][start+len-1] = true;
        			else dp[start][start+len-1] = false;
        		}else{
        			if(s.charAt(start) == s.charAt(start + len - 1))	dp[start][start+len-1] = dp[start+1][start+len-2];
        			else	dp[start][start+len-1] = false;
        		}
        		// free riding...
        		if(dp[start][start+len-1])	cnt++;
        	}
        }
        return cnt;
    }
}
