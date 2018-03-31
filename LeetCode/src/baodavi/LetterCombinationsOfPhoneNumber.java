package baodavi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<String, String> digitToLetters = new HashMap<>();
        digitToLetters.put("2", "abc");
        digitToLetters.put("3", "def");
        digitToLetters.put("4", "ghi");
        digitToLetters.put("5", "jkl");
        digitToLetters.put("6", "mno");
        digitToLetters.put("7", "pqrs");
        digitToLetters.put("8", "tuv");
        digitToLetters.put("9", "wxyz");
        
        List<String> res = new ArrayList<>();
        // edge cases
        if(digits == null || digits.length() == 0){
        	return res;
        }
        String curr = "";
        backTracking(digits, 0, digitToLetters, curr, res);
        return res;
    }
    
    private void backTracking(String digits, int index, Map<String, String> digitToLetters, String curr, List<String> res){
    	if(index == digits.length()){
    		res.add(curr);
    		return;
    	}
    	String currChar = String.valueOf(digits.charAt(index));
    	if(currChar == "0" || currChar == "1"){
    		backTracking(digits, index + 1, digitToLetters, curr, res);
    	}else{
    		for(char c : digitToLetters.get(currChar).toCharArray()){
    			backTracking(digits, index + 1, digitToLetters, curr + c, res);
    		}
    	}
    }
}
