package July18th;
import java.util.*;

public class MaximumSubarrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        
        int sum = nums.get(0);
        left[0] = nums.get(0);
        for(int i = 1; i < left.length; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum += nums.get(i);
            left[i] = Math.max(left[i - 1], sum);
            
        }

        sum = nums.get(nums.size() - 1);
        right[right.length - 1] = nums.get(nums.size() - 1);
        for(int i = right.length - 2; i >= 0; i--) {
            if(sum < 0) {
                sum = 0;
            }
            sum += nums.get(i);
            right[i] = Math.max(right[i + 1], sum);
            
        }
        //System.out.println(right[0]);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i++) {

            max = Math.max(max, left[i] + right[i + 1]);
        }
        
        

        return max;
    }
}
