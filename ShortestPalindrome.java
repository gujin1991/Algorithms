package July31th;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String shortestPalindrome(String s) {
        int len = s.length();
        
        if(len <= 1) return s;
        
        int j = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        
        if(j == len) return s;
        
        String prefix = s.substring(j);
        return new StringBuilder(prefix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + prefix;
    }

}
