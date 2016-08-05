package August5th;

public class HouseRobberDPLEVELUP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rob(int[] nums) {
        int len = nums.length;
        int notBuy = 0;
        int[] dp = new int[len + 1];
        
        
        for(int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + notBuy);
            notBuy = dp[i - 1];
        }
        
        return dp[len];
	}

}
