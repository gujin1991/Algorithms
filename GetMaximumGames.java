
public class GetMaximumGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getMax(int[] arr) {
		int len = arr.length;
		int[][] memo = new int[len][len];
		
		return findMax(arr, 0, len - 1, memo);
	}

	private int findMax(int[] arr, int lo, int hi, int[][] memo) {
		// TODO Auto-generated method stub
		if(lo > hi) {
			return 0;
		}
		
		if(memo[lo][hi] != 0) return memo[lo][hi];
		int a = arr[lo] + 
	    Math.min(findMax(arr, lo + 2, hi, memo), findMax(arr, lo + 1, hi - 1, memo));
		int b = arr[hi] +
		Math.min(findMax(arr, lo + 1, hi - 1, memo), findMax(arr, lo, hi - 2, memo));
		
		memo[lo][hi] = Math.max(a, b);
		return memo[lo][hi];
	}

}
