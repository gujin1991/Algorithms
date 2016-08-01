package July31th;
import java.util.*;

public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        int len = s.length();
        int strLen = words[0].length();
        int maxLen = strLen * words.length;
        
        Map<String, Integer> dict = new HashMap<>();
        for(String str : words) {
            if(!dict.containsKey(str)) {
                dict.put(str, 0);
            }
            
            dict.put(str, dict.get(str) + 1);
        }

        //int i = 0;
        //while(i <= len - maxLen) {
        for(int i = 0; i <= len - maxLen; i++) {
            Map<String, Integer> map = new HashMap<>(dict);
            for(int j = i; j < i + maxLen; j += strLen) {
                String str = s.substring(j, j + strLen);
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) - 1);
                    
                    if(map.get(str) == 0) {
                        map.remove(str);
                    }
                    
                    
                    
                } else {
                    break;
                }
            }
            
            if(map.isEmpty()) {
                indices.add(i);            
            }
        }
        
        return indices;
    }

}
