package June7th;
import java.util.*;

public class ContainsDuplicateTreeSet {
	public static int val = 1;
	public int data = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicateTreeSet test1 = new ContainsDuplicateTreeSet();
		ContainsDuplicateTreeSet test2 = new ContainsDuplicateTreeSet();
		System.out.println(test1.val);
		System.out.println(test2.val);
		test1.val = 2;
		test1.val = 2;
		System.out.println(test2.val);
		System.out.println(test2.data);
		

	}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Integer> value = new TreeSet<>();
        
        for(int i = 0; i < len; i++) {
            Integer low = value.ceiling(nums[i] - t);
            Integer high = value.floor(nums[i] + t);
            
            if((low != null && low <= nums[i]) || (high != null && high >= nums[i])) return true;
            
            value.add(nums[i]);
            if(value.size() > k) {
                value.remove(nums[i - k]);
            }
        }
        
        return false;
    }

}
