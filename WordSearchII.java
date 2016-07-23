package July22th;
import java.util.*;

public class WordSearchII {
	private int[] dx = {1,0,-1,0};
    private int[] dy = {0,1,0,-1};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> target = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;
        Trie trieTree = new Trie(new TrieNode());
        
        for(String word : words) {
            trieTree.insert(word);
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                search(board, i, j, trieTree.root, target);
            }
        }
        
        return target;
    }
    
    
    private void search(char[][] board, int ridx, int cidx, TrieNode root, List<String> target) {
        if(root.isLeaf) {
            if(!target.contains(root.word))
                target.add(root.word);
            
        }
        
        int row = board.length;
        int col = board[0].length;
        if(ridx < 0 || ridx >= row || cidx < 0 || cidx >= col || board[ridx][cidx] == '0' || !root.subtree.containsKey(board[ridx][cidx])) return;
        
        //System.out.println(board[ridx][cidx] + " out");
        if(root.subtree.containsKey(board[ridx][cidx])) {
            //System.out.println(board[ridx][cidx] + " in");
            for(int i = 0; i < 4; i++) {
                char temp = board[ridx][cidx];
                board[ridx][cidx] = '0';
                search(board, ridx + dx[i], cidx + dy[i], root.subtree.get(temp), target);
                board[ridx][cidx] = temp;
            }
        }
    }
    
    class TrieNode {
        String word;
        boolean isLeaf;
        Map<Character, TrieNode> subtree;
        
        public TrieNode() {
            word = "";
            isLeaf = false;
            subtree = new HashMap<>();
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie(TrieNode r) {
            root = r;
        }
        
        public void insert(String str) {
            int len = str.length();
            TrieNode p = root;
            for(int i = 0; i < len; i++) {
                char c = str.charAt(i);
                if(!p.subtree.containsKey(c)) {
                    TrieNode cur = new TrieNode();
                    cur.word = p.word + c;
                    p.subtree.put(c, cur);
                }
                
                p = p.subtree.get(c);
            }
            
            p.isLeaf = true;
        }
    }

}
