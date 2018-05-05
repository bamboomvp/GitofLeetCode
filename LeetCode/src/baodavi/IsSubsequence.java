package baodavi;

public class IsSubsequence {
	
	// 我们可以用两个指针分别指向字符串s和t，然后如果字符相等，则i和j自增1，反之只有j自增1，最后看i是否等于s的长度，等于说明s已经遍历完了，而且字符都有在t中出现过
	
    public boolean isSubsequence(String s, String t) {
    	// first validation
        int[] freqCnt = new int[26];
        for(char currChar : t.toCharArray()){
        	freqCnt[currChar - 'a'] += 1;
        }
        int[] compareFreqCnt = new int[26];
        for(char currChar : s.toCharArray()){
        	compareFreqCnt[currChar - 'a'] += 1;
        }
        for(int k = 0; k < 26; k++){
        	if(freqCnt[k] - compareFreqCnt[k] < 0)
        		return false;
        }
        
        int ind = 0;
        for(char currChar : s.toCharArray()){
        	while(ind < t.length() && t.charAt(ind) != currChar){
        		ind++;
        	}
        	if(ind >= t.length())		return false;
        	else							ind++;
        }
        return true;
    }
}
