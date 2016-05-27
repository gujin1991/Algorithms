
public class maxSumPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int len = nums.length;
        
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            
            if(sum < 0) {
                sum = 0;
            }
            
        }
        
        return maxSum;
    }
	
	public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        int max = nums[0];
        
        int maxP = nums[0];
        int minN = nums[0];
        for(int i = 1; i < len; i++) {
            if(nums[i] < 0) {
                int temp = maxP;
                maxP = minN;
                minN = temp;
            }
            
            maxP = Math.max(nums[i], maxP * nums[i]);
            minN = Math.min(nums[i], minN * nums[i]);
            max = Math.max(max, maxP);
        }
        
        return max;
    }

}
