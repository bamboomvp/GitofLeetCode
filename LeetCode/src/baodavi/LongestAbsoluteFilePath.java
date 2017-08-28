package baodavi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int maxLength = 0;
        if(input == null || input.length() == 0){
        	return maxLength;
        }
        char[] inputArr = input.toCharArray();
        Map<Integer, Integer> keeping = new HashMap<>();
        int currLayer = 0;
        boolean isFile = false;
        int runningLengthCnt = 0;
        for(int i = 0; i < inputArr.length; i++){
        	if(inputArr[i] == '.'){
        		runningLengthCnt++;
        		isFile = true;
        	}else if(inputArr[i] == '\n'){
        		int nextIdx = parseBackslashNAndT(inputArr, i);
        		// careful special case!!!
        		int nextLayer = nextIdx - i - 1;
        		if(nextLayer > currLayer){
        			if(!isFile){
        				keeping.put(currLayer, runningLengthCnt);
        			}
        			currLayer = nextLayer;
        			isFile = false;
        			i = nextIdx - 1;
        		}else{
        			if(isFile){
        				int newLength = runningLengthCnt + currLayer;
        				maxLength = Math.max(maxLength, newLength);
        			}
        			currLayer = nextLayer;
        			runningLengthCnt = (currLayer != 0) ? keeping.get(currLayer - 1) : 0;
        			isFile = false;
        			i = nextIdx - 1;
        		}
        	}else{
        		runningLengthCnt++;
        	}
        }
        if(isFile){
        	int newLength = runningLengthCnt + currLayer;
        	maxLength = Math.max(maxLength, newLength);
        }
        
        return maxLength;
    }
    
    private int parseBackslashNAndT(char[] inputArr, int currInd){
    	int nextInd = currInd + 1;
    	while(inputArr[nextInd] == '\t'){
    		nextInd++;
    	}
    	return nextInd;
    }
    
    public int lengthLongestPathRef(String input) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                res = Math.max(res, m.get(level) + len);
            } else {
                m.put(level + 1, m.get(level) + len + 1);
            }
        }
        return res;
    }
    
    class DirOrFileItem{
    	public int layer;
    	public int length;
    	public DirOrFileItem(int layer, int length){
    		this.layer = layer;
    		this.length = length;
    	}
    }
    
    public int lengthLongestPathUseStack(String input) {
        int maxLength = 0;
        if(input == null || input.length() == 0){
        	return maxLength;
        }
        Stack<DirOrFileItem> stack = new Stack<>();
        for(String substr : input.split("\n")){
        	int layer = substr.lastIndexOf("\t") + 1;
        	int length = substr.substring(layer).length();
        	boolean isFile = substr.contains(".");
    		boolean flag = false;
    		while(!stack.isEmpty()){
    			DirOrFileItem peek = stack.peek();
    			if(peek.layer < layer){
    				DirOrFileItem newPeek = new DirOrFileItem(layer, peek.length + length);
    				stack.push(newPeek);
    				flag = true;
    				break;
    			}else{
    				stack.pop();
    			}
    		}
    		if(!flag){
	    		DirOrFileItem item = new DirOrFileItem(layer, length);
	    		stack.push(item);
    		}
    		if(isFile){
    			maxLength = Math.max(maxLength, stack.peek().length + stack.peek().layer);
    		}
        }
        return maxLength;
    }
    
    public static void main(String args[]){
    	LongestAbsoluteFilePath instance = new LongestAbsoluteFilePath();
//    	instance.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    	System.out.println(instance.lengthLongestPathRef("dir\n    file.txt"));
    }
}
