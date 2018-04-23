package baodavi;

import java.util.Stack;

public class VerifyPreorderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
    	if(preorder == null || preorder.length() == 0){
    		return false;
    	}
        String[] tokens = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(String token : tokens){
        	while(token.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
        		stack.pop();
        		if(stack.empty())	return false;
        		stack.pop();
        	}
        	stack.push(token);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
