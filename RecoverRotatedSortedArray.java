package July17th;
import java.util.*;

public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
        if(len <= 1) return;
        int cnt = 1;
        while(cnt < len && nums.get(cnt - 1) <= nums.get(cnt)) {
            cnt++;
        }
        
        reverse(nums, 0, cnt - 1);
        reverse(nums, cnt, len - 1);
        reverse(nums, 0, len - 1);
        
    }
    
    private void reverse(ArrayList<Integer> nums, int lo, int hi) {
        while(lo < hi) {
            int temp = nums.get(lo);
            nums.set(lo, nums.get(hi));
            nums.set(hi, temp);
            
            lo++;
            hi--;
        }
    }

}
