import java.util.*;
public class ConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        int len = nums.length;
        if(len <= 1) {
            return len;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) continue;
            int left = 0;
            int right = 0;
            int sum = 0;
            if(map.containsKey(num - 1)) {
                left = map.get(num - 1);
            }
            
            if(map.containsKey(num + 1)) {
                right = map.get(num + 1);
            }
            
            sum = 1 + left + right;
            maxLen = Math.max(maxLen, sum);
            map.put(num, sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
        }
        
        return maxLen;
    }

}
