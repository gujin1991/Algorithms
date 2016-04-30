import java.util.*;
public class AC自动机 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.AddTrieNode("say", 1);
		trie.AddTrieNode("she", 2);
		trie.AddTrieNode("shr", 3);
		trie.AddTrieNode("her", 4);
		trie.AddTrieNode("he", 5);
		trie.buildFailNodeBFS(); 
		String s = "yasherhs"; 
		HashSet<Integer> hashSet = trie.searchAC(s);
		Iterator<Integer> iter = hashSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
