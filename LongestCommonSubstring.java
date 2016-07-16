package July15th;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestCommonSubstring(String A, String B) {
        int max = 0;
        int alen = A.length();
        int blen = B.length();
        
        int[][] dp = new int[alen + 1][blen + 1];
        
        for(int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}
