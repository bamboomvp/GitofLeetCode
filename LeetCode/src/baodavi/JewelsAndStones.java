package baodavi;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[26 * 2];
        for(char c : J.toCharArray()){
        	if(c >= 'a' && c <= 'z')	jewels[c - 'a'] = true;
        	else								jewels[c - 'A' + 26] = true;
        }
        
        int cnt = 0;
        for(char x : S.toCharArray()){
        	if(x >= 'a' && x <= 'z' && jewels[x - 'a'])		cnt++;
        	else if(x >= 'A' && x <= 'Z' && jewels[x - 'A' + 26])						cnt++;
        }
        return cnt;
    }
}
