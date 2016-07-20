package July19th;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubArray(int[] nums, int k) {
        // write your code here
        int len = nums.length;
        int[][] globalmax = new int[k + 1][len + 1];
        int[][] localmax = new int[k + 1][len + 1];
        
        for(int i = 1; i <= k; i++) {
            localmax[i][i - 1] = Integer.MIN_VALUE;
            for(int j = i; j <= len; j++) {
                localmax[i][j] = Math.max(localmax[i][j - 1], globalmax[i - 1][j - 1]) + nums[j - 1];
                
                if(j == i) {
                    globalmax[i][j] = localmax[i][j];
                } else {
                    globalmax[i][j] = Math.max(localmax[i][j], globalmax[i][j - 1]);
                }
            }
        }
        
        return globalmax[k][len];
    }

}
