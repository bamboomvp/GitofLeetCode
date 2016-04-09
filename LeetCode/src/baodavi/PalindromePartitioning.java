package baodavi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
  */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	
    	List<String> resItem = new ArrayList<>();
    	List<List<String>> res = new ArrayList<>();
    	
    	Map<String, Boolean> caching = new HashMap<>();
    	
    	if(s == null || s.length() == 0){
    		return res;
    	}
    	
    	partitionBacktrace(s, 0, resItem, res, caching);
    	return res;
    }
    
    private void partitionBacktrace(String s, int start, List<String> resItem, List<List<String>> res, Map<String, Boolean> caching){
    	
    	if(start == s.length()){
    		res.add(new ArrayList<String>(resItem));
    		return;
    	}
    	
    	for(int i = start; i < s.length(); i++){
    		String subStr = s.substring(start, i + 1);
    		if(checkPalindrome(subStr, caching)){
    			resItem.add(subStr);
    			partitionBacktrace(s, i + 1, resItem, res, caching);
    			resItem.remove(resItem.size() - 1);
    		}
    	}
    }
    
    private boolean checkPalindrome(String s, Map<String, Boolean> caching){
    	if(caching.containsKey(s)){
    		return caching.get(s);
    	}
    	int low = 0, high = s.length() - 1;
    	boolean res = true;
    	while(low < high){
    		if(s.charAt(low) != s.charAt(high)){
    			res = false;
    			break;
    		}
    		low++;
    		high--;
    	}
    	caching.put(s, res);
    	return res;
    }
}
