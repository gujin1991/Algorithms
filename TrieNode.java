import java.util.*;
public class TrieNode {
	TrieNode[] childNodes;
	int freq;
	char nodeChar;
	TrieNode failNode = null;;
	HashSet<Integer> hashSet = new HashSet<Integer>();
	
	public TrieNode() {
		this.freq = 0;
		this.childNodes = new TrieNode[26];
	}
	
}
