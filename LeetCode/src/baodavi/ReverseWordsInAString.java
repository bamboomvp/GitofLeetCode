package baodavi;

public class ReverseWordsInAString {
	
	// һ��ʼ�븴���ˣ����뵽��stackȥ�ˣ���ʵ���ǰ�string split��������ʽ��Ȼ����ϲ������ˣ���������StringBuilder�ȽϷ��㡣
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
