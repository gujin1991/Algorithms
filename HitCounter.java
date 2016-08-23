package August23th;
import java.util.*;

public class HitCounter {
    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!map.containsKey(timestamp)) {
            map.put(timestamp, 0);
        }
        map.put(timestamp, map.get(timestamp) + 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int end = timestamp > 300 ? timestamp + 1 - 300 : 1;
        int cnt = 0;
        Integer next = map.floorKey(timestamp);
        
        while(next != null && next >= end) {
            cnt += map.get(next);
            next = map.lowerKey(next);
        }
        
        return cnt;
    }

}
