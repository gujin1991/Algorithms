package July24th;
import java.util.*;

public class WordLAdderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> findLadders(String beginWord, String endWord,
            Set<String> wordList) {
        
        int cnt = 0;
        boolean mark = true;
        
        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> nextLevel = new HashMap<>();
        List<List<String>> ladders = new ArrayList<>();
        
        queue.offer(beginWord);
        wordList.add(beginWord);
        wordList.add(endWord);
        
        
        while(!queue.isEmpty() && mark) {
            int size = queue.size();
            List<String> temp = new ArrayList<>();
            for(int k = 0; k < size; k++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) {
                    mark = false;
                    continue;
                }
                
                nextLevel.put(cur, new ArrayList<String>());
                for(int i = 0; i < cur.length(); i++) {
                    for(int j = 0; j < 26; j++) {
                        char[] c = cur.toCharArray();
                        c[i] = (char)('a' + j);
                        String newStr = new String(c);
                        if(wordList.contains(newStr) && !queue.contains(newStr) && !cur.equals(newStr)) {
                            nextLevel.get(cur).add(newStr);
                            temp.add(newStr);
                        }
                    }
                }
                wordList.remove(cur);

            
            }
            
            for(String str : temp) {
                        queue.offer(str);
                }
            cnt++;
        }
        
        getLadders(cnt, beginWord, endWord, new ArrayList<String>(), ladders, nextLevel);
        
        
        return ladders;
        
    }
    
    private void getLadders(int cnt, String next, String end, List<String> prefix, List<List<String>> ladders, Map<String, List<String>> nextLevel) {
        if(cnt == 1) {
            if(next.equals(end)) {
                List<String> ladder = new ArrayList<>(prefix);
                ladder.add(end);
                ladders.add(ladder);
            }
            
        } else {
            prefix.add(next);
            for(String word : nextLevel.get(next)) {
                getLadders(cnt - 1, word, end, prefix,ladders, nextLevel);    
            }
            prefix.remove(prefix.size() - 1);
        }
    }

}
