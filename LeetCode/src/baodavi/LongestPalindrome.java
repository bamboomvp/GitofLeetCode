package baodavi;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] occurance = new int[52];
        for(char c : s.toCharArray()){
        	if(c >= 'A' && c <= 'Z'){
        		occurance[c - 'A'] += 1;
        	}else if(c >= 'a' && c <= 'z'){
        		occurance[c - 'a' + 26] += 1;
        	}
        }
        boolean plusOneFlag = false;
        int res = 0;
        for(int i = 0; i < occurance.length; i++){
        	if(!plusOneFlag && occurance[i] % 2 != 0){
        		plusOneFlag = true;
        	}
        	res += (occurance[i] / 2) * 2;
        }
        return res + (plusOneFlag ? 1 : 0);
    }
}
