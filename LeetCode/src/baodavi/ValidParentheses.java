package baodavi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> myStack = new Stack<>();
		Map<Character, Character> myMap = new HashMap<>();
		myMap.put(')', '(');
		myMap.put(']', '[');
		myMap.put('}', '{');
		for (char currC : s.toCharArray()) {
			if (currC == '(' || currC == '[' || currC == '{') {
				myStack.push(currC);
			} else {
				if (!myStack.isEmpty() && myStack.peek() == myMap.get(currC)) {
					myStack.pop();
				} else {
					return false;
				}
			}
		}
		return myStack.isEmpty();
	}
}
