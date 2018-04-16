package baodavi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII {
	
	// Trie Implementation
	class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isLeaf = false;
	    public TrieNode() {}
	    public TrieNode(char c){
	    	this.c = c;
	    }
	}
	class Trie {
	    private TrieNode root;
	    public Trie() {
	        root = new TrieNode();
	    }
	    // Inserts a word into the trie.
	    public void insert(String word) {
	        HashMap<Character, TrieNode> children = root.children;
	        for(int i = 0; i < word.length(); i++){
	        	char c = word.charAt(i);
	        	TrieNode t;
	        	if(children.containsKey(c)){
	        		t = children.get(c);
	        	}else{
	        		t = new TrieNode(c);
	        		children.put(c, t);
	        	}
	        	children = t.children;
	        	// set leaf node
	        	if(i == word.length() - 1)
	        		t.isLeaf = true;
	        }
	    }
	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	 HashMap<Character, TrieNode> children = root.children;
	    	 TrieNode t = null;
	    	 for(int i = 0; i < word.length(); i++){
	    		 char c = word.charAt(i);
	    		 if(children.containsKey(c)){
	    			 t = children.get(c);
	    			 children = t.children;
	    		 }else{
	    			 return false;
	    		 }
	    	 }
	    	 return t.isLeaf;
	    }
	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	 HashMap<Character, TrieNode> children = root.children;
	    	 TrieNode t = null;
	    	 for(int i = 0; i < prefix.length(); i++){
	    		 char c = prefix.charAt(i);
	    		 if(children.containsKey(c)){
	    			 t = children.get(c);
	    			 children = t.children;
	    		 }else{
	    			 return false;
	    		 }
	    	 }
	    	 return true;	        
	    }
	}
	
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
        	trie.insert(word);
        }
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++){
        		findWordsHelper(i, j, "" + board[i][j], trie, board, visited, res);
        	}
        }
        return res;
    }
    
    private void findWordsHelper(int i, int j, String prefix, Trie trie, char[][] board, boolean[][] visited, List<String> res){
    	if(visited[i][j])	return; // shortcut
    	if(!trie.startsWith(prefix))	return; // shortcut
    	if(trie.search(prefix) && !res.contains(prefix)){ // get one result
    		res.add(prefix);
    	}
		visited[i][j] = true;
		if(i - 1 >= 0){
			findWordsHelper(i - 1, j, prefix + board[i - 1][j], trie, board, visited, res);
		}
		if(i + 1 <= board.length - 1){
			findWordsHelper(i + 1, j, prefix + board[i + 1][j], trie, board, visited, res);
		}
		if(j - 1 >= 0){
			findWordsHelper(i, j - 1, prefix + board[i][j - 1], trie, board, visited, res);
		}
		if(j + 1 <= board[0].length - 1){
			findWordsHelper(i, j + 1, prefix + board[i][j + 1], trie, board, visited, res);
		}
		visited[i][j] = false;
    }
}
