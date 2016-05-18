import java.util.*;
public class GroupShiftedStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> strGourp = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strings) {
            
            StringBuffer key = new StringBuffer();
            int offset = str.charAt(0) - 'a';
            for(int i = 0; i < str.length(); i++) {
                char c = (char)(str.charAt(i) - offset);
                if(c < 'a') {
                    c += 26;
                }
                
                key.append(c);
            }
            
            if(map.containsKey(key.toString())) {
                List<String> group = map.get(key.toString());
                group.add(str);
                System.out.println(group.size());
            } else {
                List<String> group = new ArrayList<String>();
                group.add(str);
                map.put(key.toString(), group);
            }
        }
        
        for(String str : map.keySet()) {
            List<String> group = map.get(str);
            Collections.sort(group);
            /*Collections.sort(group, new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        for(int i = 0; i < s1.length(); i++) {
                            if(s1.charAt(i) > s2.charAt(i)) {
                                return 1;
                            } else if(s1.charAt(i) < s2.charAt(i)) {
                                return -1;
                            }
                        }
                        
                        return 0;
                    }    
                });*/
            strGourp.add(group);    
        }
        
        return strGourp;
    }

}
