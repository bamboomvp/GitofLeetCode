package baodavi;

import java.util.Arrays;
import java.util.List;

//These letters are vowels in English: A, E, I, O, U, and sometimes Y. 
//The letter Y can be a vowel (as in the words "cry", "sky", "fly" or "why"), 
//or it can be a consonant (as in "yellow", "yacht", "yam" or "yesterday"). 
//These five or six letters stand for about 20 vowel sounds in most English accents.

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)
        	return s;
        
        List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        char[] charArr = s.toCharArray();
        
        int left, right;
        left = 0;
        right = s.length() - 1;
        while(left < right){
        	while(left <= s.length() - 1 && !vowels.contains(charArr[left])){
        		left++;
        	}
        	while(right >= 0 && !vowels.contains(charArr[right])){
        		right--;
        	}
        	
        	if(left > s.length() - 1 || right < 0 || left >= right)
        		break;
        	else{
        		char tmp = charArr[left];
        		charArr[left] = charArr[right];
        		charArr[right] = tmp;
        		left++;
        		right--;
        	}
        }
        
        return String.copyValueOf(charArr);
    }
    
    public static void main(String args[]){
    	new ReverseVowelsOfAString().reverseVowels("hello");
    }
    
}
