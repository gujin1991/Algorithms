package August2nd;
import java.util.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minWindow(String s, String t) {
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE, head = 0;
        int cnt = t.length();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            
            map.put(c, map.get(c) + 1);
        }
        
        
        while(end < len) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) cnt--;
            }
            
            while(cnt == 0) {
                char sc = s.charAt(start);
                
                if(map.containsKey(sc)) {
                    map.put(sc, map.get(sc) + 1);
                    if(map.get(sc) > 0) {
                        cnt++;
                        if(end - start < minLen) {
                            head = start;
                            minLen = end - start + 1;
                        }
                    }
                }
                start++;
            }
            end++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    }

}
