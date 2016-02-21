package baodavi;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
/*	Given two strings s and t, determine if they are isomorphic.

	Two strings are isomorphic if the characters in s can be replaced to get t.

	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

	For example,
	Given "egg", "add", return true.

	Given "foo", "bar", return false.

	Given "paper", "title", return true.

	Note:
	You may assume both s and t have the same length.*/
    public boolean isIsomorphic(String s, String t) {
        
    	if(s.length() != t.length())
    		return false;
    	
    	Map<Character, Character> tbl1 = new HashMap<>();
    	Map<Character, Character> tbl2 = new HashMap<>();
    	
    	for(int i = 0; i < s.length(); i++){
    		char s_char = s.charAt(i);
    		char t_char = t.charAt(i);
    		
    		if(tbl1.containsKey(s_char) && tbl1.get(s_char) != t_char)
    			return false;
    		else
    			tbl1.put(s_char, t_char);
    		
    		if(tbl2.containsKey(t_char) && tbl2.get(t_char) != s_char)
    			return false;
    		else
    			tbl2.put(t_char, s_char);
    	}
    	
    	return true;
    }
}
