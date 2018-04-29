package StringMatching;

import java.util.Stack;

public class Trie {

	TrieNode rootNode;
	int size;

	public Trie() {
		rootNode = new TrieNode();
		rootNode.isRoot = true;
	}

	public int dictionarySize() {
		return size;
	}

	public boolean isPresent(String word) {
		if (word.length() == 0)
			return true;

		TrieNode currentRoot = rootNode;
		for (int i =0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!currentRoot.children.containsKey(currentChar)) {
				return false;
			} else {
				currentRoot = currentRoot.children.get(currentChar);
			}
		}
		if (currentRoot.isTerminal) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(String word) {
		if (word.length() == 0)
			return;

		TrieNode currentRoot = rootNode;
		for (int i = 0; i < word.length() ; i++) {
			char currentChar = word.charAt(i);
			if (currentRoot.children.containsKey(currentChar)) {
				currentRoot = currentRoot.children.get(currentChar);
			} else  {
				TrieNode node = new TrieNode();
				node.data = currentChar;
				currentRoot.children.put(currentChar, node);
				currentRoot = node;
			}
		}

		if (!currentRoot.isTerminal) {
			currentRoot.isTerminal = true;
			size++;
		}
	}

	public void delete(String word) {
		if (!isPresent(word)) {
			return;
		}
		TrieNode currentRoot = rootNode;
		Stack<TrieNode> parents = new Stack<TrieNode>();
		
		for (int i =0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			parents.add(currentRoot);
			currentRoot = currentRoot.children.get(currentChar);
		}
		
		currentRoot.isTerminal = false;
		size--;
		
		TrieNode child = currentRoot;
		TrieNode parent = parents.pop();
		
		while (true) {
			if (!child.isTerminal && child.children.size() == 0) {
				parent.children.remove(child.data);
				child = parent;
				if (parents.isEmpty())
					break;
				parent = parents.pop();
			} else {
				break;
			}
		}
		
		
	}
	
	public static void main(String args[]) {
		Trie t = new Trie();
		t.insert("are");
		t.insert("do");
		t.insert("dote");
		System.out.println(t.size);
		t.insert("dot");
		System.out.println(t.size);
		System.out.println(t.isPresent("do"));
		t.delete("dot");
		System.out.println(t.isPresent("dot"));
		t.delete("are");
		System.out.println(t.isPresent("dot"));
		
	}

}
