package August8th;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len <= 1 || k == 0) return;
        
        k = k % len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);

        
    }
    
    private void reverse(int[] nums, int lo, int hi) {
        while(lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }

}
