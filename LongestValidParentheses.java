package August3rd;
import java.util.*;
public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestValidParentheses(String s) {
        int len = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if(s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        
        if(stack.isEmpty()) return len;
        else {
            int hi = len;
            while(!stack.isEmpty()) {
                int lo = stack.pop();
                max = Math.max(max, hi - lo - 1);
                hi = lo;
            }
            max = Math.max(max, hi);
        }
        
        return max;
    }	
	
	public int longestValidParenthesesDP(String s) {
        int len = s.length();
        int max = 0;
        int[] dp = new int[len];
        int open = 0;
        
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else if(s.charAt(i) == ')' && open > 0){
                open--;
                dp[i] = 2 + dp[i - 1];
                
                if(i - dp[i] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                
                max = Math.max(max, dp[i]);
            }
        }
        
        return max;
    }

}
