package August2nd;
import java.util.*;

public class PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        int len = words.length;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            map.put(words[i], i);
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if(isPalind(str1)) {
                    String rstr2 = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(rstr2) && map.get(rstr2) != i) {
                        list.add(Arrays.asList(map.get(rstr2), i));    
                    }
                }
                
                if(isPalind(str2)) {
                    String rstr1 = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(rstr1) && map.get(rstr1) != i && str2.length() != 0) {
                        list.add(Arrays.asList(i, map.get(rstr1)));    
                    }
                }
            }
        }
        
        return list;
        
    }
    
    private boolean isPalind(String str) {
        int len = str.length();

        int lo = 0;
        int hi = len - 1;
        while(lo < hi) {
            if(str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        
        return true;
    }
}
