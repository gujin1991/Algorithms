package July22th;
import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestConsecutive(int[] num) {
        // write you code here
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int val : num) {
            int left = val;
            int right = val;
            int cnt = 1;
            if(!map.containsKey(val)) {
                if(map.containsKey(val - 1)) {
                    cnt += map.get(val - 1);
                    left = val - map.get(val - 1);
                }
                
                if(map.containsKey(val + 1)) {
                    cnt += map.get(val + 1);
                    right = val + map.get(val + 1);
                }
                
                map.put(left, cnt);
                map.put(right,cnt);
                map.put(val, cnt);
                max = Math.max(max, cnt);
            }
        }
        
        return max;
    }

}
