import java.util.*;
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        if(len == 0) {
            return false;
        }
        if(wordDict.contains(s)) return true;
        
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j <= i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
	
}
