package baodavi;

import java.util.ArrayList;
import java.util.List;

// Great use-case for Divide and Conquer!

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        String opt = "+-*";
        
        if(input == null || input.length() == 0)
        	return res;
        
        // Divide and Conquer!
        for(int i = 0; i < input.length(); i++){
        	if(opt.contains("" + input.charAt(i))){
        		String left = input.substring(0, i);
        		String right = input.substring(i + 1);
        		List<Integer> leftRes = diffWaysToCompute(left);
        		List<Integer> rightRes = diffWaysToCompute(right);
        		for(int l : leftRes){
        			for(int r : rightRes){
        				if(input.charAt(i) == '+'){
        					res.add(l + r);
        				}else if(input.charAt(i) == '-'){
        					res.add(l - r);
        				}else if(input.charAt(i) == '*'){
        					res.add(l * r);
        				}
        			}
        		}
        	}
        }
        
        if(res.size() == 0)
        	res.add(Integer.valueOf(input));
        
        return res;
    }
}
