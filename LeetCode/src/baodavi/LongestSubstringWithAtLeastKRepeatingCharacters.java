package baodavi;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstringI(String s, int k) {
        int res = 0, i = 0, n = s.length();
        while(i + k <= n){
        	int[] map = new int[26];
        	int mask = 0, max_idx = i;
        	for(int j = i; j < n; j++){
        		int t = s.charAt(j) - 'a';
        		map[t]++;
        		if(map[t] < k)		mask |= (1 << t);
        		else					mask &= (~(1 << t));
        		if(mask == 0){
        			res = Math.max(res, j - i + 1);
        			max_idx = j;
        		}
        	}
        	i = max_idx + 1;
        }
        return res;
    }
    
    public int longestSubstringII(String s, int k) {
    	return longestSubstringSub(s, k, 0, s.length() - 1);  
    }
    
    private int longestSubstringSub(String s, int k, int start, int end){  
        if(start > end) return 0;  
        int[] count = new int[26];  
        for(int i = start; i <= end; i++){  
            count[s.charAt(i) - 'a']++;  
        }  
        for(int i = 0; i < 26; i++){  
            if(count[i] > 0 && count[i] < k){  
                int pos = s.indexOf((char)(i + 'a'), start);  
                return Math.max(longestSubstringSub(s, k, start, pos - 1), longestSubstringSub(s, k, pos + 1, end));  
            }  
        }  
        return end - start + 1;  
    }
}
