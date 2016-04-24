package baodavi;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> hehe = new HashMap<>();
        for(char c : secret.toCharArray()){
        	if(hehe.containsKey(c)){
        		hehe.put(c, hehe.get(c) + 1);
        	}else{
        		hehe.put(c, 1);
        	}
        }
        
        int bulls = 0;
        int cows = 0;
        
        for(int i = 0; i < guess.length(); i++){
        	if(guess.charAt(i) == secret.charAt(i)){
        		bulls++;
        		hehe.put(secret.charAt(i), hehe.get(secret.charAt(i)) - 1);
        	}
        }
        
        for(int i = 0; i < guess.length(); i++){
        	if(guess.charAt(i) != secret.charAt(i)){
        		if(hehe.containsKey(guess.charAt(i))){
        			if(hehe.get(guess.charAt(i)) > 0){
        				cows++;
        				hehe.put(guess.charAt(i), hehe.get(guess.charAt(i)) - 1);
        			}
        		}
        	}
        }
        
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
    
//    public String getHint2(String secret, String guess) {
//        int m[256] = {0}, bulls = 0, cows = 0;
//        for (int i = 0; i < secret.size(); ++i) {
//            if (secret[i] == guess[i]) ++bulls;
//            else ++m[secret[i]];
//        }
//        for (int i = 0; i < secret.size(); ++i) {
//            if (secret[i] != guess[i] && m[guess[i]]) {
//                ++cows;
//                --m[guess[i]];
//            }
//        }
//        return to_string(bulls) + "A" + to_string(cows) + "B";
//    }
    
//    string getHint3(string secret, string guess) {
//        int m[256] = {0}, bulls = 0, cows = 0;
//        for (int i = 0; i < secret.size(); ++i) {
//            if (secret[i] == guess[i]) ++bulls;
//            else {
//                if (m[secret[i]]++ < 0) ++cows;
//                if (m[guess[i]]-- > 0) ++ cows;
//            }
//        }
//        return to_string(bulls) + "A" + to_string(cows) + "B";
//    }    
}
