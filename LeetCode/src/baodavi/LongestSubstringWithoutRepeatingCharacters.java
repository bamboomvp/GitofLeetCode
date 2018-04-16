package baodavi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring1(String s) {
    	// sliding window
    	Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int max = 0; // init to ZERO!!!
        while(i < s.length() && j < s.length()){
        	if(!set.contains(s.charAt(j))){
        		set.add(s.charAt(j));
        		max = Math.max(max, j - i + 1);
        		j++;
        	}else{
        		set.remove(s.charAt(i++));
        	}
        }
        return max;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        // sliding window optimized
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
