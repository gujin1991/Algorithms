package July20th;

public class MaximumSubarrayDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int len = nums.length;
        int diff = Integer.MIN_VALUE;
        
        int[] rmax = new int[len];
        int[] rmin = new int[len];
        int[] lmax = new int[len];
        int[] lmin = new int[len];
        
        
        int sum1 = nums[0];
        int sum2 = nums[0];
        lmax[0] = sum1;
        lmin[0] = sum1;
        for(int i = 1; i < len; i++) {
            if(sum1 < 0) {
                sum1 = 0;
            }
            sum1 += nums[i];
            lmax[i] = Math.max(lmax[i - 1], sum1);
            
            if(sum2 > 0) {
                sum2 = 0;
            }
            sum2 += nums[i];
            lmin[i] = Math.min(lmin[i - 1], sum2);
            
            
        }
        
        
        sum1 = nums[len - 1];
        sum2 = nums[len - 1];
        rmax[len - 1] = sum1;
        rmin[len - 1] = sum1;
        for(int i = len - 2; i >= 0; i--) {
            if(sum1 < 0) {
                sum1 = 0;
            }
            sum1 += nums[i];
            rmax[i] = Math.max(rmax[i + 1], sum1);
            
            if(sum2 > 0) {
                sum2 = 0;
            }
            sum2 += nums[i];
            rmin[i] = Math.min(rmin[i + 1], sum2);
            
        }
        
        /*for(int i = 0; i < len; i++) {
            System.out.print(lmax[i] + " ");
            System.out.print(lmin[i] + " ");
        }
        System.out.println( " ");
        
        for(int i = len - 1; i >= 0; i--) {
            System.out.print(rmax[i] + " ");
            System.out.print(rmin[i] + " ");
        }*/
        
        for(int i = 0; i < len - 1; i++) {
            diff = Math.max(diff, Math.abs(lmax[i] - rmin[i + 1]));
            diff = Math.max(diff, Math.abs(lmin[i] - rmax[i + 1]));
        }
        
        return diff;
        
    }

}
