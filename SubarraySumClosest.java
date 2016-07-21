package July20th;
import java.util.*;

public class SubarraySumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] subarraySumClosest(int[] nums) {
        int len = nums.length;
        int sum = 0;
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        int[] idx = new int[2];
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
            sum += nums[i];
            Integer next = treemap.ceilingKey(sum);
            Integer prev = treemap.floorKey(sum);
            if(next != null) {
                if((next - sum) < min) {
                    min = next - sum;
                    idx[0] = treemap.get(next) + 1;
                    idx[1] = i;
                }
                
            }
            
            if(prev != null) {
                if((sum - prev) < min) {
                    min = sum - prev;
                    idx[0] = treemap.get(prev) + 1;
                    idx[1] = i;
                }
                
            }
            
            
            treemap.put(sum, i);
        }
        
        return idx;
    }

}
