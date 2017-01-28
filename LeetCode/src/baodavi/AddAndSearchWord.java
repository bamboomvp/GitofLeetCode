package baodavi;

import java.util.HashMap;

/* Test the Eclipse commit from Bamboo-PC 01/28 */
// Data structure design
/* Test new commit from my MacPro 01/28 */
public class AddAndSearchWord {
	public class WordDictionary {
		class TrieNode {
			char c;
			HashMap<Character, TrieNode> children = new HashMap<>();
			boolean isLeaf;
			
		    public TrieNode() {}
		    
		    public TrieNode(char c){
		    	this.c = c;
		    }
		}
		
		// WordDictionary class is essentially a Trie
	    private TrieNode root;
	    public WordDictionary() {
	        root = new TrieNode();
	    }

	    // Adds a word into the data structure.
	    public void addWord(String word) {
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

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	    	return searchHelper(word, 0, root);
	    }
	    
	    private boolean searchHelper(String word, int currInd, TrieNode startNode){
	    	if(currInd == word.length())
	    		return startNode.isLeaf;
	    	
	    	HashMap<Character, TrieNode> children = startNode.children;
	    	 
	    	 char currChar = word.charAt(currInd);
	    	 if(currChar == '.'){
	    		 for(TrieNode currNode : children.values()){
	    			 if(searchHelper(word, currInd + 1, currNode)){
	    				 return true;
	    			 }
	    		 }
	    		 return false;
	    	 }else{
	    		 if(children.containsKey(currChar)){
	    			 return searchHelper(word, currInd + 1, children.get(currChar));
	    		 }else{
	    			 return false;
	    		 }
	    	 }
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
