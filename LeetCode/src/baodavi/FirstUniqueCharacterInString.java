package baodavi;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] marked = new int[26];
        for(char c : s.toCharArray()){
        	marked[c - 'a'] += 1;
        }
        for(int i = 0; i < s.length(); i++){
        	if(marked[s.charAt(i) - 'a'] == 1)
        		return i;
        }
        return -1;
    }
}
