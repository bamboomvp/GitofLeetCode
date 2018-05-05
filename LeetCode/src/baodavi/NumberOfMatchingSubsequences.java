package baodavi;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {
	
	// Trie + DFS
	class TrieNode{
		TrieNode[] children = new TrieNode[26];
		boolean isWord = false;
		int cnt = 0;
	}
	TrieNode root = new TrieNode();
	void insertWord(String word){
		TrieNode curr = this.root;
		for(char c : word.toCharArray()){
			int idx = c - 'a';
			if(curr.children[idx] == null)
				curr.children[idx] = new TrieNode();
			curr = curr.children[idx];
		}
		curr.isWord = true;
		curr.cnt++;
	}
	
	public int numMatchingSubseqUPDATE(String S, String[] words) {
	    for(String word : words)
	        insertWord(word);
	    return DFS(S, 0, root);
	}
	
	private int DFS(String S, int start, TrieNode curr){
		int cnt = 0;
		if(curr.isWord)		cnt += curr.cnt;
		if(start >= S.length())		return cnt; // no need to continue search
		for(int i = 0; i < 26; i++){
			if(curr.children[i] != null){
				int nextStart = S.indexOf((char)(i + 'a'), start);
				if(nextStart != -1)
					cnt += DFS(S, nextStart + 1, curr.children[i]);
			}
		}
		return cnt;
	}
	
	
	
	
	
	
    public int numMatchingSubseq(String S, String[] words) {
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
        	if(!map.containsKey(word)){
        		map.put(word, 0);
        	}
        	map.put(word, map.get(word) + 1);
        }
        for(String word : map.keySet()){
        	if(isSubsequence(S, word))
        		cnt += map.get(word);
        }
        return cnt;
    }
    
    private boolean isSubsequence(String S, String word){
    	if(word.length() == 0)		return true;
    	int i = 0, j = 0;
    	while(i < S.length() && j < word.length()){
    		if(S.charAt(i) == word.charAt(j))	j++;
    		i++;
    	}
    	return j == word.length();
    }
}
