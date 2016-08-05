package August4th;

public class BestTimetoBuyandSellStockwithCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
		int len = prices.length;
	    if(len < 1) return 0;
	    int[] sell = new int[len];
	    int[] buy = new int[len];
	    int[] rest = new int[len];
	    
	    buy[0] = -prices[0];
	    for(int i = 1; i < len; i++) {
	        sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
	        buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
	        rest[i] = Math.max(rest[i - 1], sell[i - 1]);
	    }
	    
	    return sell[len - 1];
	}

}
