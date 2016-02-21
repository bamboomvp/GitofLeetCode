package baodavi;

public class ReverseWordsInAString {
	
	// 一开始想复杂了，还想到用stack去了，其实就是把string split成数组形式，然后倒序合并就行了，这里利用StringBuilder比较方便。
	public String reverseWords(String s){
        if(s == null || s.length() == 0) return "";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i >= 0; i--){
            if(!arr[i].equals(""))
                sb.append(arr[i]).append(" "); 
        }
        if(sb.length() == 0) return "";
        else return sb.substring(0, sb.length()-1);
	}
	
    public String reverseWords_WRONG(String s) {
    	
    	StringBuilder sb1 = new StringBuilder();
    	StringBuilder sb2 = new StringBuilder();
    	StringBuilder sbRes = new StringBuilder();
    	
    	for(char x : s.toCharArray()){
    		sb1.insert(0, x);
    	}
    	
    	String intermediate = sb1.toString();
    	for(char y : intermediate.toCharArray()){
    		if(y == ' '){
    			sbRes.append(sb2.toString());
    			sb2.setLength(0);
    		}else{
    			sb2.insert(0, y);
    		}
    	}
    	
    	return sbRes.toString();
    }
}
