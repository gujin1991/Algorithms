package August8th;
import java.util.*;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int search(int[] nums, int target) {
        int len = nums.length;
        return search(nums, target, 0, len - 1);
    }
    
    private int search(int[] nums, int target, int lo, int hi) {
        
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;
            
            if(nums[lo] < nums[mid]) {
                if(nums[lo] <= target && nums[mid] >= target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else if(nums[lo] == nums[mid]) {
                lo = mid + 1;
            } else {
                if(nums[mid] <= target && nums[hi] >= target) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        return -1;
        
    }
}
