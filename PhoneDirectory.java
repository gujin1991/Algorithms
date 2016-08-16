package August15th;
import java.util.*;

public class PhoneDirectory {
	Queue<Integer> queue;
    Set<Integer> set;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        for(int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(queue.isEmpty()) return -1;
        int val = queue.poll();
        set.add(val);
        return val;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!set.contains(number)) return;
        queue.offer(number);
        set.remove(number);
    }
}
