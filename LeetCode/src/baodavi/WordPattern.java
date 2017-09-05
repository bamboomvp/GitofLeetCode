package baodavi;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<String, String> jection1 = new HashMap<>();
        Map<String, String> jection2 = new HashMap<>();
        
        String[] strArr = str.split(" ");
        if(pattern.length() != strArr.length)		return false;
        
        for(int i = 0; i < pattern.length(); i++){
        	String key1 = pattern.substring(i, i + 1);
        	String key2 = strArr[i];
        	if(jection1.containsKey(key1)){
        		String valStored = jection1.get(key1);
        		if(!valStored.equals(key2))	return false;
        	}else{
        		jection1.put(key1, key2);
        	}
        	if(jection2.containsKey(key2)){
        		String valStored = jection2.get(key2);
        		if(!valStored.equals(key1))	return false;
        	}else{
        		jection2.put(key2, key1);
        	}
        }
        
        return true;
    }
}
