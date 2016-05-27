import java.util.*;
public class SmashableWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSmable(Set<String> dictionary, String word, Map<String, Boolean> map) {
		if(!dictionary.contains(word)) {
			return false;
		}
		if(map.containsKey(word)) return true;
		
		int len = word.length();
		if(len == 0) return true;
		
		for(int i = 0; i < len; i++) {
			String newStr = word.substring(0, i) + word.substring(i+ 1);
			if(!isSmable(dictionary, newStr, map)) {
				return false;
			}
		}
		
		map.put(word, true);
		return true;
	}

}
