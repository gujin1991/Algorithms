package June7th;

import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] max = new int[len - k + 1];
        if(len == 0) return new int[0];
        
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int idx = 0;
        
        for(int i = 0; i < len; i++) {
            pq.offer(nums[i]);
            if(pq.size() == k){
                max[idx++] = pq.peek();
            } else if(pq.size() > k){
                pq.remove(nums[i - k]);
                max[idx++] = pq.peek();
            }
        }
        
        return max;
        
    }
	
	public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        int[] max = new int[len - k + 1];
        if(len == 0) return new int[0];
        
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        
        for(int i = 0; i < len; i++) {
            if(!dq.isEmpty() && i - k >= dq.peek()) {
                dq.poll();
            } 
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i + 1 >= k) {
                max[idx++] = nums[dq.peek()];
            }
        }
        
        return max;
    }

}
