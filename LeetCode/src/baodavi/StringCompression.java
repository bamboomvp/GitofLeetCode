package baodavi;

public class StringCompression {
    public int compress(char[] chars) {
    	if(chars == null || chars.length == 0)	return 0;
        char currChar = chars[0];
        int slow = 1, fast = 1;
        while(fast < chars.length){
        	int cnt = 0;
        	while(fast < chars.length && chars[fast] == currChar){
        		cnt++;
        		fast++;
        	}
        	
        	if(cnt != 0){
        		cnt += 1;
            	String tmp = "";
            	while(cnt > 0){
            		tmp += cnt % 10;
            		cnt /= 10;
            	}
            	for(int x = tmp.length() - 1; x >= 0; x--){
            		chars[slow++] = tmp.charAt(x); 
            	}
        	}
        	
        	if(fast < chars.length){
	        	currChar = chars[fast];
	        	chars[slow++] = chars[fast++];
        	}
        }
        return slow;
    }
}
