
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        int fast = 0;
        int slow = 0;
        int min = len + 1;
        int sum = 0;
        
        while(fast < len) {
            while(fast < len && sum < s) {
                sum += nums[fast++];
            }
            
            while(slow < len && sum >= s) {
                sum -= nums[slow++];
            }
            
            min = Math.min(min, fast - slow + 1);
        }
        
        return min == len + 1 ? 0 : min;
    }
	
	public int minSubArrayLenBinary(int s, int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        int[] sums = new int[len];
        int temp = 0;
        int min = len + 1;
        
        for(int i = 0; i < len; i++) {
            temp += nums[i];
            sums[i] = temp;
            if(temp >= s) {
                min = Math.min(min, i - searchEorL(sums, 0, i, temp - s));
            }
        }
        
        return min == len + 1? 0 : min;
    }
    
    private int searchEorL(int[] arr, int lo, int hi, int target) {
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return hi;
    }

}
