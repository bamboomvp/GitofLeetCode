package baodavi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
	
	// brute-force + sort
	public String longestWordNew(String[] words) {
		Set<String> wordSet = new HashSet<>();
		for(String word : words){
			wordSet.add(word);
		}
		Arrays.sort(words, new Comparator<String>(){
			@Override
			public int compare(String arg0, String arg1) {
				if(arg0.length() == arg1.length()){
					return arg0.compareTo(arg1);
				}else{
					return arg1.length() - arg0.length();
				}
			}
		});
		for(String word : words){
			boolean found = true;
			for(int k = 1; k < word.length(); k++){
				if(!wordSet.contains(word.substring(0, k))){
					found = false;
					break;
				}
			}
			if(found)	return word;
		}
		return "";
	}
	
	
	
	
	class TrieNode{
		public char val;
		public TrieNode[] children;
		public boolean isWord;
		public TrieNode(char val){
			this.val = val;
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}
	
	class Trie{
		public TrieNode root;
		public String longestWord;
		public Trie(){
			this.root = new TrieNode('-');
			this.longestWord = "";
		}
		public void addWord(String word){
			TrieNode currNode = this.root;
			for(char currChar : word.toCharArray()){
				TrieNode nextNode;
				if(currNode.children[currChar - 'a'] == null){
					nextNode = new TrieNode(currChar);
					currNode.children[currChar - 'a'] = nextNode;
				}else{
					nextNode = currNode.children[currChar - 'a'];
				}
				currNode = nextNode;
			}
			currNode.isWord = true;
		}
		public void traverseAndUpdateLongest(){
			traverseAndUpdateLongestHelper(this.root, "");
		}
		private void traverseAndUpdateLongestHelper(TrieNode currNode, String currStr){
			if(currStr.length() > this.longestWord.length()){
				this.longestWord = currStr;
			}
			for(TrieNode nextNode : currNode.children){
				if(nextNode != null && nextNode.isWord){
					traverseAndUpdateLongestHelper(nextNode, currStr + nextNode.val);
				}
			}
		}
	}
	
    public String longestWord(String[] words) {
        Trie myTrie = new Trie();
        for(String word : words){
        	myTrie.addWord(word);
        }
        myTrie.traverseAndUpdateLongest();
        return myTrie.longestWord;
    }
}
