package baodavi;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        if(s == null || s.length() == 0)	return len;
        else{
        	List<Integer> spaceIndice = new ArrayList<>();
        	char[] strCharArr = s.toCharArray();
        	for(int i = 0; i < strCharArr.length; i++){
        		if(strCharArr[i] == ' ')	spaceIndice.add(i);
        	}
        	
        	// special case, no space at all...
        	if(spaceIndice.isEmpty()){
        		len = s.length();
        	}
        	
        	int lastSpaceInd = s.length();
        	int prevSpaceInd;
        	while(!spaceIndice.isEmpty()){
        		prevSpaceInd = spaceIndice.remove(spaceIndice.size() - 1); // get last
        		if(lastSpaceInd - prevSpaceInd > 1){
        			len = lastSpaceInd - prevSpaceInd - 1;
        			lastSpaceInd = 0;
        			break;
        		}else{
        			lastSpaceInd = prevSpaceInd;
        		}
        	}
        	
        	// special case, the spaces used up but still have string...
        	if(lastSpaceInd != 0){
        		len = lastSpaceInd;
        	}
        	return len;
        }
    }
    
    public int lengthOfLastWordBetter(String s) {
    	if(s == null || s.length() == 0)	return 0;
    	int len = 0;
    	int lastInd = s.length() - 1;
    	for(; lastInd >= 0 && s.charAt(lastInd) == ' '; lastInd--)	;
    	for(; lastInd >= 0 && s.charAt(lastInd) != ' '; lastInd--)	len++;
    	return len;
    }
}
