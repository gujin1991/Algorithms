package August6th;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len <= 1) return;
        
        int start = 0;

        for(int i = 0; i < len; i++) {
            if(nums[i] != 0) {
                swap(nums, start++, i);
            }
        }
    }
    
    private void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

}
