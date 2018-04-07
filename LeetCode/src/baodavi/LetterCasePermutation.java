package baodavi;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
    	List<String> res = new ArrayList<>();
    	if(S == null || S.length() == 0){
    		res.add(S);
    		return res;
    	}
    	char[] chars = new char[S.length()];
    	letterCasePermutationHelper(S, 0, chars, res);
    	return res;
    }
    
    private void letterCasePermutationHelper(String S, int index, char[] chars, List<String> res){
    	if(index == S.length()){
    		res.add(String.copyValueOf(chars));
    		return;
    	}
    	if(S.charAt(index) >= 'A' && S.charAt(index) <= 'Z'){
    		chars[index] = S.charAt(index);
    		letterCasePermutationHelper(S, index + 1, chars, res);
    		chars[index] = (char) (S.charAt(index) + ('a' - 'A'));
    		letterCasePermutationHelper(S, index + 1, chars, res);
    	}else if(S.charAt(index) >= 'a' && S.charAt(index) <= 'z'){
    		chars[index] = S.charAt(index);
    		letterCasePermutationHelper(S, index + 1, chars, res);
    		chars[index] = (char) (S.charAt(index) - ('a' - 'A'));
    		letterCasePermutationHelper(S, index + 1, chars, res);
    	}else{
    		chars[index] = S.charAt(index);
    		letterCasePermutationHelper(S, index + 1, chars, res);
    	}
    }
}
