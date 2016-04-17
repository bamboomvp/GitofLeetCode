package baodavi;

import java.util.HashMap;

// Prefix Tree
public class ImplementTrie {
	class TrieNode {
		
		char c;
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isLeaf;
		
	    public TrieNode() {}
	    
	    public TrieNode(char c){
	    	this.c = c;
	    }
	}

	public class Trie {
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

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
