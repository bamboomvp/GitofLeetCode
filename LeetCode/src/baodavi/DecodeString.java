package baodavi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DecodeString {
	public static void main(String[] args){
		DecodeString obj = new DecodeString();
		System.out.println(obj.decodeString("3[a]2[bc]"));
	}
	
    public String decodeString(String s) {
        Stack<Integer> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        StringBuilder sb = new StringBuilder();
        List<String> tmpList = new ArrayList<>();
        int idx = 0;
        while(idx < s.length()){
        	if(s.charAt(idx) >= '0' && s.charAt(idx) <= '9'){
        		int firstLeftBracket = s.indexOf('[', idx);
        		int k = Integer.parseInt(s.substring(idx, firstLeftBracket));
        		stackNum.push(k);
        		idx = firstLeftBracket;
        	}else if(s.charAt(idx) == '['){
        		stackStr.push("[");
        		idx++;
        	}else if(s.charAt(idx) == ']'){
        		tmpList.clear();
        		sb.setLength(0);
        		while(!stackStr.peek().equals("[")){
        			tmpList.add(stackStr.pop());
        		}
        		Collections.reverse(tmpList);
        		int repeat = stackNum.pop();
        		for(int k = 0; k < repeat; k++){
        			for(String str : tmpList){
        				sb.append(str);
        			}
        		}
        		String newStr = sb.toString();
        		stackStr.pop();
        		stackStr.push(newStr);
        		idx++;
        	}else{ // those actual encoded strings
        		stackStr.push(String.valueOf(s.charAt(idx)));
        		idx++;
        	}
        }
        tmpList.clear();
        sb.setLength(0);
        while(!stackStr.isEmpty()){
        	tmpList.add(stackStr.pop());
        }
        Collections.reverse(tmpList);
        for(String str : tmpList){
        	sb.append(str);
        }
        return sb.toString();
    }
}
