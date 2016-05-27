import java.util.*;

public class priceCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int coinsCount(int[] coins) {
		int cnt = 0;
		int sum = 0;
		
		for(int coin : coins) {
			sum += coin;
		}
		
		int[] dp = new int[sum + 1];
		Arrays.sort(coins);
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= sum; i++) {
			for(int j = 0; j < coins.length; j++) {
				int diff = i - coins[j];
				if(diff < 0) break;
				if(dp[diff] == Integer.MAX_VALUE) continue;
				
				cnt++;
				dp[i] = 0;
				break;
			}
		}
			
		return cnt; 
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> pers = new ArrayList<>();
        Arrays.sort(nums);
        
        getPers(nums, new ArrayList<Integer>(), 0, pers);
        
        return pers;
    }
    
    private void getPers(int[] nums, List<Integer> curPer, int start, List<List<Integer>> pers) {
        if(start == nums.length) {
            pers.add(curPer);
            return;
        }    
        
        pers.add(curPer);
        for(int i = start; i < nums.length; i++) {
            if(i == start || nums[i] != nums[i - 1]) {
                List<Integer> newPer = new ArrayList<>(curPer);
                newPer.add(nums[i]);
                getPers(nums, newPer, i + 1, pers);
            }
        }
    }
}
