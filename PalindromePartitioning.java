package June10th;
import java.util.*;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String one = "hello";
		String two = "hello";
		
		one = "hello" + "2";
		
		
				
		System.out.println(two);
	}
	
	public List<List<String>> partition(String s) {
        List<List<String>> palinds = new ArrayList<>();
        if(null == s) return palinds;
        
        List<String> prefix = new ArrayList<>();
        backTracking(s, prefix, palinds);
        
        return palinds;
    }
	
	private void backTracking(String s, List<String> prefix, List<List<String>> palinds) {
        int len = s.length();
        if(len == 0 ) {
            palinds.add(new ArrayList(prefix));
            return;
        }
        //if(map.containsKey(s)) return map.get(s);
        
        for(int i = 1; i <= len; i++) {
            String sub = s.substring(0, i);
            if(isPalind(sub)) {
                prefix.add(sub);
                backTracking(s.substring(i), prefix, palinds);
                prefix.remove(prefix.size() - 1);
            }
        }
        
    }
    
    private boolean isPalind(String s) {
        int len = s.length();
        for(int i = 0; i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        
        return true;
    }

}
