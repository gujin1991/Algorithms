package July31th;
import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        
        if(s == null || s.length() == 0) {
            return res;
        }
        
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));  
                if(dp[i]) {
                    break;
                }
            }
        }
        
        if(!dp[len]) {
            return res;
        }
        
        helper(s, "", res, wordDict);
        
        return res;
    }
    
    private void helper(String s, String prefix, List<String> res, Set<String> wordDict) {
        int len = s.length();
        if(len == 0) {
            res.add(prefix.trim());
            return;
        }
        
        for(int i = 1; i <= len; i++) {
            String cur = s.substring(0, i);
            if(wordDict.contains(cur)) {
                helper(s.substring(i, len), prefix + cur + " ", res, wordDict);
            }
        }
    }

}
