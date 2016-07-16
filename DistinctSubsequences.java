package July15th;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numDistinct(String S, String T) {
        int slen = S.length();
        int tlen = T.length();
        if(tlen == 0) return 1;
        
        int[][] dp = new int[slen + 1][tlen + 1];
        for(int i = 0; i <= slen; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if(S.charAt(i - 1) == T.charAt(j - 1)) {
                     dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    
                } else {
                    dp[i][j] = dp[i - 1][j];    
                }
            }
        }
        
        return dp[slen][tlen];
    }

}
