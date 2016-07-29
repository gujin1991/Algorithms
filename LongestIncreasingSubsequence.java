package Elementum;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        
        int max = -1;
        int[] lis = new int[len];
        for(int i = 0; i < len; i++) {
            int idx = searchFirstBigger(lis, 0, max, nums[i]);
            //System.out.println(idx);
            max = Math.max(max, idx);
            lis[idx] = nums[i];
        }
        
        return max + 1;
    }
    
    private int searchFirstBigger(int[] nums, int lo, int hi, int target) {
        //if(lo > hi) return lo;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
        
    }

}
