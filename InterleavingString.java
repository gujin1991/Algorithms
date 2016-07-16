package July15th;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 + len2 != s3.length()) return false;
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 2];
        dp[0][0] = true;
        
        for(int i = 1; i <= len1; i++) {
            if(s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
                
            } 
        }
        
        for(int j = 1; j <= len2; j++) {
            if(s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            } 
        }
        
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[len1][len2];
    }

}
