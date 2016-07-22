package July21th;

public class PartitionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int partitionArray(int[] nums, int k) {
	    int len = nums.length;
	    
	    if(len <= 0) return 0;
	    
	    int left = 0;
	    int right = len - 1;
	    
	    while(left < right) {
	        while(left < right && nums[left] < k) {
	            left++;
	        }
	        	        
	        while(left < right && nums[right] >= k) {
	            right--;
	        }
	        
	        swap(nums, left, right);
	        
	    }
	    
	    return nums[right] < k ? right + 1 : right;
    }
    
    private void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
}
