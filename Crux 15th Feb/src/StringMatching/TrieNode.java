package StringMatching;

import java.util.HashMap;

public class TrieNode {
	char data;
	HashMap<Character, TrieNode> children;
	boolean isTerminal;
	boolean isRoot;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
	
}
