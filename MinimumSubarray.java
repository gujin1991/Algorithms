package July20th;
import java.util.*;

public class MinimumSubarray {
	
	public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int sum = nums.get(0);
        int min = sum;

        for(int i = 1; i < size; i++) {
            if(sum > 0) {
                sum = 0;
            }
            
            sum += nums.get(i);
            
            min = Math.min(min, sum);
            
            
        }
        
        return min;
    }

}
