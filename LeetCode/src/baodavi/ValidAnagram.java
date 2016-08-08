package baodavi;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] booking = new int[26];
        for(Character c : s.toCharArray()){
        	booking[c - 'a'] += 1;
        }
        
        for(Character c2 : t.toCharArray()){
        	booking[c2 - 'a'] -= 1;
        	if(booking[c2 - 'a'] < 0)
        		return false;
        }
        
        for(int i = 0; i < booking.length; i++){
        	if(booking[i] != 0)
        		return false;
        }
        
        return true;
    }
}
