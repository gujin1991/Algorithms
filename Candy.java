package August4th;
import java.util.*;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int candy(int[] ratings) {
	        int cnt = 0;
	        int len = ratings.length;
	        if(len <= 1) return len;
	        int[] dp = new int[len];
	        Arrays.fill(dp, 1);
	        
	        
	        for(int i = 1; i < len; i++) {
	            if(ratings[i] > ratings[i - 1]) {
	                dp[i] = dp[i - 1] + 1;
	            }
	        }
	        
	        for(int i = len - 2; i >= 0; i--) {
	            if(ratings[i] > ratings[i + 1]) {
	                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
	            }
	        }
	        
	        for(int val : dp) {
	            cnt += val;
	        }
	        return cnt;
	    }

}
