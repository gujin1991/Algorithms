import java.util.*;
public class GeneralizedAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generateAbbreviations(String word) {
        List<String> abbs = new ArrayList<>();
        
        generateAbbs(word, 0, 0, "", abbs);
        
        return abbs;
    }
    
    private void generateAbbs(String word, int pos, int cur, String prefix, List<String> abbs) {
        if(pos == word.length()) {
            if(cur != 0)    prefix += cur +"";
            abbs.add(prefix);
            return;
        }
        
        generateAbbs(word, pos + 1, cur + 1, prefix, abbs);
        generateAbbs(word, pos + 1, 0, prefix + (cur == 0 ? "" : cur) +word.charAt(pos), abbs);
    }

}
