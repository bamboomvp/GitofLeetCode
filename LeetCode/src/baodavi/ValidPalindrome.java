package baodavi;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
        	return true;
        else if(s.length() == 1)
        	return true;
        else{
        	int low = 0;
        	int high = s.length() - 1;
        	while(low < high){
        		while(low < s.length() && !Character.isLetterOrDigit(s.charAt(low))){
        			low++;
        		}
        		while(high >= 0 && !Character.isLetterOrDigit(s.charAt(high))){
        			high--;
        		}
        		
        		if(low >= high || low >= s.length() || high < 0)
        			break;
        		else{
        			if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
        				return false;
        			else{
        				low++;
        				high--;
        			}
        		}
        	}
        	return true;
        }
    }
}
