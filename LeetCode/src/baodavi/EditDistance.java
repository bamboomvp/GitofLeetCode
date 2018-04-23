package baodavi;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // init
        dp[0][0] = 0;
        for(int i = 1; i <= word1.length(); i++)
        	dp[i][0] = i; // cost of edit the first ith chars in word1 to empty string (word2)
        for(int j = 1; j <= word2.length(); j++)
        	dp[0][j] = j; // cost of get the first jth chars in word2 from empty string (word1)
        for(int i = 1; i <= word1.length(); i++){
        	for(int j = 1; j <= word2.length(); j++){
        		// delete the ith char of word1
        		int cost_del = dp[i - 1][j] + 1;
        		// add additional char to word1 to match the jth char of word2
        		int cost_add = dp[i][j - 1] + 1;
        		// potential cost of edit ith char of word1 to become jth char of word2
        		int cost_edit;
        		if(word1.charAt(i - 1) == word2.charAt(j - 1)){
        			cost_edit = dp[i - 1][j - 1];
        		}else{
        			cost_edit = dp[i - 1][j - 1] + 1;
        		}
        		dp[i][j] = Math.min(Math.min(cost_del, cost_add), cost_edit);
        	}
        }
        return dp[word1.length()][word2.length()];
    }
}
