import java.util.*;
public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//what about we can add the ranges from time to time? red-black tree.
	}
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ranges = new LinkedList<>();
        int start = lower;
        
        
        for(int num : nums) {
            int end = num - 1;
            if(end == start) {
                ranges.add(start + "");
            } else if(start < end) {
                ranges.add(start + "->" + end);
            }
            start = num + 1;
        }
        
        if(start == upper) {
            ranges.add(start + "");
        } else if(start < upper){
            ranges.add(start + "->" + upper);
        }
        
        return ranges;
    }

}
