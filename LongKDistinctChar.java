import java.util.*;
public class LongKDistinctChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//如果是流如何，如果k很大如何
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if(len <= k) {
            return len;
        }
        
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while(map.size() > k) {
                    
                    char startC = s.charAt(start);
                    int cnt = map.get(startC);
                    if(cnt == 1) {
                        map.remove(startC);
                    } else {
                        map.put(startC, map.get(startC)-1);
                    }
                    start++;
                }
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;    
    }

}
