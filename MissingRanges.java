import java.util.*;
public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<String>();
        if(nums.length == 0) {
            if(lower == upper) {
                ranges.add(lower + "");
            } else {
                ranges.add(lower + "->" + upper);
            }
            return ranges;
        }
        
        int len = nums.length - 1;
        int left = lower;
        int right = nums[0] - 1;
        
        if(left != nums[0]) {
            if(left != right) {
                ranges.add(left + "->" + right);
            } else {
                ranges.add(left +"");
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] != nums[i + 1] - 1) {
                left = nums[i] + 1;
                right = nums[i + 1] - 1;
                if(left != right) {
                    ranges.add(left + "->" + right);
                } else {
                    ranges.add(left +"");
                }
            }
        }
        
        left = nums[len] + 1;
        right = upper;
        if(nums[len] != right) {
            if(left != right) {
                ranges.add(left + "->" + right);
            } else {
                ranges.add(left +"");
            }    
        }
        
        return ranges;
    }

}
