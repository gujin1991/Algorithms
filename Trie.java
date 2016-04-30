import java.util.*;

public class Trie {
	TrieNode trieNode = new TrieNode();
	LinkedList<TrieNode> queue = new LinkedList<TrieNode>();
	
	public void  buildFailNodeBFS() {
		buildFailNodeBFS(this.trieNode);
	}
	
	public void buildFailNodeBFS(TrieNode root) {
		queue.push(root);
		
		while(!queue.isEmpty()) {
			TrieNode cur = queue.pop();
			TrieNode failNode = null;
			
			for(int i = 0; i < 26; i++) {
				if (cur.childNodes[i] == null) {
					continue;
				}
				
				if(cur == root) {
					cur.childNodes[i].failNode = root;
				} else {
					failNode = cur.failNode;
					while(failNode != null) {
						if(failNode.childNodes[i] != null) {
							cur.childNodes[i].failNode = failNode.childNodes[i];
							break;
						}
						
						failNode = failNode.failNode;
					}
					
					if(failNode == null) {
						cur.childNodes[i].failNode = root;
					}
				}
				
				queue.push(cur.childNodes[i]);
			}
			
		}
	}
	
	public void AddTrieNode(String word, int id) {
		AddTrieNode(this.trieNode, word, id);
	}

	private void AddTrieNode(TrieNode root, String word, int id) {
		// TODO Auto-generated method stub
		if(word.length() == 0) {
			return;
		}
		
		int k = word.charAt(0) - 'a';
		//System.out.println(k);
		if(root.childNodes[k] == null) {
			root.childNodes[k] = new TrieNode();
		}
		
		String nextWord = word.substring(1);
		if(nextWord.length() == 0) {
			root.childNodes[k].freq++;
			root.childNodes[k].hashSet.add(id);
		}
		
		AddTrieNode(root.childNodes[k], nextWord, id);
	}

	public HashSet<Integer> searchAC(String s) {
		HashSet<Integer> hash = new HashSet<Integer>();
		searchAC(trieNode, s, hash);
		return hash;
	}

	private void searchAC(TrieNode root, String s, HashSet<Integer> hash) {
		// TODO Auto-generated method stub
		int freq = 0;
		TrieNode head = root;
		
		for(char c : s.toCharArray()) {
			int index = c - 'a';
			while(head.childNodes[index] == null && head != root) {
				head = head.failNode;
			}
			
			head = head.childNodes[index];
			if(head == null) {
				head = root;
			}
			
			TrieNode cur = head;
			while(cur != root && cur.freq != -1) {
				freq += cur.freq;
				
				for(int item : cur.hashSet) {
					hash.add(item);
				}
				
				cur.freq = -1;
				cur = cur.failNode;
			}
		}
		
	}
	
}
