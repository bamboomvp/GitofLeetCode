package baodavi;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] occurances = new int[26];
        for(char c : s.toCharArray()){
        	occurances[c - 'a'] += 1;
        }
        for(char c2 : t.toCharArray()){
        	if(occurances[c2 - 'a'] == 0){
        		return c2;
        	}
        	occurances[c2 - 'a'] -= 1;
        }
        return 'a';
    }
}
