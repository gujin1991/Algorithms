import java.util.*;
public class GuessWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessWord test = new GuessWord();
		Set<String> set = new HashSet<>();
		set.add("abvde");
		set.add("aksjs");
		set.add("akicd");
		set.add("abasd");
		set.add("aoiui");
		test.update("abccc", 2, set);
		for(String str : set) {
			System.out.println(str);
		}

	}
	
	public String guess(Set<String> dictionary) {
		String target = "";
		int score = 0;
		
		while(score != 6) {
			String myguess = "";
			for(String word : dictionary) {
				myguess += word;
				break;
			}
			score = getScore(myguess);
			if(score == 6) return myguess;
			
			update(myguess, score, dictionary);
		}
		
		return "";
		
	}
	
	private void update(String myguess, int score, Set<String> dictionary) {
		// TODO Auto-generated method stub
		Set<String> temp = new HashSet<>();
		for(String word : dictionary) {
			int difference = diff(myguess, word);
			System.out.println(difference);
			if(difference < score) {
				temp.add(word);
			}
		}
		
		for(String word : temp) {
			dictionary.remove(word);
		}
	}

	private int diff(String myguess, String word) {
		// TODO Auto-generated method stub
		int cnt = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < myguess.length(); i++) {
			char c = myguess.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(map.containsKey(c)) {
				cnt++;
				if(map.get(c) == 1) {
					map.remove(c);
				} else {
					map.put(c, map.get(c) - 1);
				}
			}
		}
		return cnt;
	}

	private int getScore(java.lang.String myguess) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
