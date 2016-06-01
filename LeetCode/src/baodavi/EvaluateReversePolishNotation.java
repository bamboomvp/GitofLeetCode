package baodavi;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
        	if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
        		int i2 = stack.pop();
        		int i1 = stack.pop();
        		switch(s){
        		case "+":
        			stack.push(i1 + i2);
        			break;
        		case "-":
        			stack.push(i1 - i2);
        			break;
        		case "*":
        			stack.push(i1 * i2);
        			break;
        		case "/":
        			stack.push(i1 / i2);
        			break;
        		}
        	}else{
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.pop();
    }
}
