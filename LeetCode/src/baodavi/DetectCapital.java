package baodavi;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        // case 1
    	boolean case1 = true;
    	for(char c : word.toCharArray()){
    		if(c < 'A' || c > 'Z'){
    			case1 = false;
    			break;
    		}
    	}
    	if(case1)	return true;
    	
    	// case 2
    	boolean case2 = true;
    	for(char c : word.toCharArray()){
    		if(c < 'a' || c > 'z'){
    			case2 = false;
    			break;
    		}
    	}
    	if(case2)	return true;
    	
    	// case3
    	if(word.length() > 1 && (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')){
    		boolean case3 = true;
    		for(int i = 1; i < word.length(); i++){
    			if(word.charAt(i) < 'a' || word.charAt(i) > 'z'){
    				case3 = false;
    				break;
    			}
    		}
    		if(case3)	return true;
    	}
    	
    	return false;
    }
}
