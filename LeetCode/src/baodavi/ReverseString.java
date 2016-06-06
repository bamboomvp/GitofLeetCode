package baodavi;

public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() == 0)
        	return s;
        
        char[] charArr = s.toCharArray();
        int low = 0;
        int high = charArr.length - 1;
        while(low < high){
        	char tmp = charArr[low];
        	charArr[low] = charArr[high];
        	charArr[high] = tmp;
        	low++;
        	high--;
        }
        
        return String.copyValueOf(charArr);
    }
}
