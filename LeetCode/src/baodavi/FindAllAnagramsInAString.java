package baodavi;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList<>();
    	if(p.length() > s.length()){
    		return res;
    	}
    	int[] map = new int[26];
    	for(char ch : p.toCharArray()){
    		map[ch - 'a'] += 1;
    	}
    	int lower = 0, higher = p.length() - 1;
    	for(int i = lower; i <= higher; i++){
    		map[s.charAt(i) - 'a'] -= 1;
    	}
    	while(true){
    		if(findAnagramsHelper(map))	res.add(lower);
    		higher++;
    		if(higher < s.length()){
    			map[s.charAt(higher) - 'a'] -= 1;
    			map[s.charAt(lower++) - 'a'] += 1;
    		}else{
    			break;
    		}
    	}
    	return res;
    }
    
    private boolean findAnagramsHelper(int[] map){
    	for(int x : map){
    		if(x != 0)	return false;
    	}
    	return true;
    }
}
