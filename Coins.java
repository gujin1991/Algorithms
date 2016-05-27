import java.util.Arrays;

public class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private static int countCoins(int[] coins, int amount) {
		int coinsNum = coins.length;
		if(coinsNum == 0 || amount <= 0) {
			return -1;
		}
		
		int[] dp = new int[amount + 1];
		Arrays.sort(coins);
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= amount; i++) {
			for(int j = 0; j < coinsNum; j++) {
				int diff = i - coins[j];
				if(diff < 0) break;
				if(dp[diff] == Integer.MAX_VALUE) continue;
				
				dp[i] = Math.min(dp[i], 1 + dp[diff]);
			}
		}
		
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

}
